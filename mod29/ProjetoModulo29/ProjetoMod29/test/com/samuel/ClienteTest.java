package com.samuel;

import com.samuel.dao.ClienteDAO;
import com.samuel.dao.IClienteDAO;
import com.samuel.domain.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class ClienteTest {
        IClienteDAO clienteDAO = new ClienteDAO();

    @Test
    public void cadastrarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("85");
        cliente.setNome("Samuel");
        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(1 == qtd );

        Cliente clienteBD = clienteDAO.buscarUm(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(clienteBD.getCodigo(), cliente.getCodigo());
        assertEquals(clienteBD.getNome(), cliente.getNome());

        Integer qtdDel = clienteDAO.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("85");
        cliente.setNome("Samuel");
        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(1 == qtd);

        Cliente clienteBD = clienteDAO.buscarUm("85");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(clienteBD);
        assertTrue(qtdDel == 1);
    }

    @Test
    public void excluirTest() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCodigo("85");
        cliente.setNome("Samuel");
        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(1 == qtd);

        Cliente clienteBD = clienteDAO.buscarUm("85");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(clienteBD);
        assertTrue(qtdDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception{

        Cliente cliente = new Cliente();
        cliente.setCodigo("85");
        cliente.setNome("Samuel");
        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(1 == qtd);

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("87");
        cliente1.setNome("Avila");
        Integer qtd1 = clienteDAO.cadastrar(cliente1);
        assertTrue(1 == qtd1);

        List<Cliente> clientes = clienteDAO.buscarTodos();
        assertNotNull(clientes);
        assertEquals(2, clientes.size());

        int count = 0;
        for(Cliente c : clientes) {
            clienteDAO.excluir(c);
            count++;
        }
        assertEquals(clientes.size(), count);

        clientes = clienteDAO.buscarTodos();
        assertEquals(0, clientes.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("85");
        cliente.setNome("Samuel");
        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(1 == qtd);

        Cliente clienteBD = clienteDAO.buscarUm("85");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("1985");
        clienteBD.setNome("Samuel Ferreira");
        Integer qtdUp = clienteDAO.atualizar(clienteBD);
        assertTrue(1 == qtdUp );

        Cliente clienteModificado = clienteDAO.buscarUm("85");
        assertNull(clienteModificado);

        Cliente clienteAtualizado = clienteDAO.buscarUm("1985");
        assertNotNull(clienteAtualizado);
        assertEquals(clienteBD.getId(), clienteAtualizado.getId());
        assertEquals(clienteBD.getCodigo(), clienteAtualizado.getCodigo());
        assertEquals(clienteBD.getNome(), clienteAtualizado.getNome());

        List<Cliente> clientes = clienteDAO.buscarTodos();
        for (Cliente c: clientes) {
            clienteDAO.excluir(c);
        }
    }
}
