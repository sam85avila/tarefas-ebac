package com.samuel;

import com.samuel.dao.ClienteDaoMock;
import com.samuel.dao.IClienteDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import com.samuel.services.ClienteService;
import com.samuel.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setNome("Samuel");
        cliente.setCpf(12345678900L);
        cliente.setTelefone(85999988888l);
        cliente.setEndereco("Serra");
        cliente.setNumero(69);
        cliente.setCidade("Beberibe");
        cliente.setEstado("CE");
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean clienteSalvo = clienteService.salvar(cliente);
        Assert.assertTrue(clienteSalvo);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Sam");
        clienteService.alterar(cliente);

        Assert.assertEquals("Sam", cliente.getNome());
    }
}
