package com.samuel;

import com.samuel.dao.ClienteDaoMock;
import com.samuel.dao.IClienteDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTeste {

    private Cliente cliente;
    private IClienteDao clienteDao;

    public ClienteDAOTeste() {
        clienteDao = new ClienteDaoMock();
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
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean clienteSalvo = clienteDao.cadastrar(cliente);
        Assert.assertTrue(clienteSalvo);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Sam");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Sam", cliente.getNome());
    }
}
