package com.samuel.jpa;

import com.samuel.dao.ClienteJpaDao;
import com.samuel.dao.IClienteJpaDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

public class ClienteJpaDaoTest {
    private IClienteJpaDao clienteDao;

    private Random random;

    public ClienteJpaDaoTest() {
        this.clienteDao = new ClienteJpaDao();
        random = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Cliente cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
       assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(retorno.getId());
        assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        Cliente clienteConsultado1 = clienteDao.consultar(retorno.getId());
        assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Samuel Ferreira");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        assertNotNull(clienteAlterado);
        assertEquals("Samuel Ferreira", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        Cliente cliente1 = criarCliente();
        Cliente retorno1 = clienteDao.cadastrar(cliente1);
        assertNotNull(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(random.nextLong());
        cliente.setNome("Samuel");
        cliente.setEmail("samuel@ebac.com");
        cliente.setCidade("Beberibe");
        cliente.setEndereco("Serra do Félix");
        cliente.setEstado("Ceará");
        cliente.setNumero(69);
        cliente.setTelelefone(1199999999L);
        return cliente;
    }
}
