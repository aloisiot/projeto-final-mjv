package edu.mjv.school.projetofinal.service;

import edu.mjv.school.projetofinal.exception.EmpityRepositoryExceprion;
import edu.mjv.school.projetofinal.exception.ResorceNotFoundException;
import edu.mjv.school.projetofinal.exception.UnprocessableEntityException;
import edu.mjv.school.projetofinal.model.Pedido;
import edu.mjv.school.projetofinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido salvar(Pedido pedido){
        if(pedido.getId() != null) {
            throw new UnprocessableEntityException("Id nao deve ser expecificado");
        }
        return repository.save(pedido);
    }

    public Pedido atualizar(Pedido pedido) {
        if(! repository.existsById(pedido.getId())) {
            throw new ResorceNotFoundException("registro de pedido nao encontrado");
        }
        return repository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isEmpty()) {
            throw new ResorceNotFoundException("registro de pedido nao encontrado");
        }
        return pedido.get();
    }

    public List<Pedido> buscarTodos() {
        List<Pedido> pedidos = repository.findAll();
        if(pedidos.isEmpty()) {
            throw new EmpityRepositoryExceprion("nao ha pedidos registrados");
        }
        return pedidos;
    }

    public List<Pedido> buscarPorFuncionaioId(Long funcionarioId) {
        List<Pedido> pedidos = repository.findByFuncionarioId(funcionarioId);
        if(pedidos.isEmpty()) {
            throw new ResorceNotFoundException("nao ha pedidos associados a esse funcionario");
        }
        return pedidos;
    }

    public List<Pedido> buscarPorClienteId(Long clienteId) {
        List<Pedido> pedidos = repository.findByClienteId(clienteId);
        if(pedidos.isEmpty()) {
            throw new ResorceNotFoundException("nao ha pedidos associados a esse cliente");
        }
        return pedidos;
    }

    public void deletar (Long id) {
        if(! repository.existsById(id)) {
            throw new ResorceNotFoundException("registro de produto nao encontrado");
        }
        repository.deleteById(id);
    }
}
