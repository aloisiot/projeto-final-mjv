package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.exception.EntidadeImprocessavelException;
import edu.mjv.school.projetofinal.exception.RecursoNaoEncontradoException;
import edu.mjv.school.projetofinal.model.embeddable.Log;
import edu.mjv.school.projetofinal.model.embeddable.QtdProdutoPorPedido;
import edu.mjv.school.projetofinal.model.entity.Pedido;
import edu.mjv.school.projetofinal.model.entity.Produto;
import edu.mjv.school.projetofinal.repository.PedidoRepository;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService extends TemplateCrudService<Pedido> {
    private final PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    public PedidoService(PedidoRepository repository) {
        super(repository);
        this.repository = (PedidoRepository) super.repository;
    }

    @Override
    public Pedido salvar(Pedido pedido) throws EntidadeImprocessavelException {
        Log log = new Log();
        log.setDataRegistro(new Date());
        log.setDataAtualizacao(new Date());
        pedido.setLog(log);
        for(Produto p : pedido.getProdutos()) {
            for (QtdProdutoPorPedido produtoPedido:  pedido.getQtdProdutoPorPedido()) {
                if(p.getId().equals(produtoPedido.getProdutoId())) {
                    Produto produtoCorrente = produtoRepository.findById(p.getId()).get();
                    decrementarQtdProdutoEstoque(produtoCorrente, produtoPedido.getQuantidadePorPedido());
                    p = produtoRepository.save(produtoCorrente);
                }
            }
        }

        return super.salvar(pedido);
    }

    @Override
    public Pedido atualizar(Pedido pedido) throws RecursoNaoEncontradoException {
        System.err.println(new Date());
        pedido.getLog().setDataAtualizacao(new Date());
        return super.atualizar(pedido);
    }

    public List<Pedido> buscarPorFuncionarioId(Long funcionarioId) {
        List<Pedido> pedidos = repository.findByFuncionarioId(funcionarioId);
        if(pedidos.isEmpty()) {
            throw new RecursoNaoEncontradoException("nao ha pedidos associados a esse funcionario");
        }
        return pedidos;
    }

    public List<Pedido> buscarPorClienteId(Long clienteId) {
        List<Pedido> pedidos = repository.findByClienteId(clienteId);
        if(pedidos.isEmpty()) {
            throw new RecursoNaoEncontradoException("nao ha pedidos associados a esse cliente");
        }
        return pedidos;
    }

    private void decrementarQtdProdutoEstoque(Produto produto, int quantidadePorPedido) {
        int estoque = produto.getQuantidadeEstoque();
        if( produto.getQuantidadeEstoque() < quantidadePorPedido) {
            throw new EntidadeImprocessavelException();
        }
        produto.setQuantidadeEstoque(estoque - quantidadePorPedido);
    }
}
