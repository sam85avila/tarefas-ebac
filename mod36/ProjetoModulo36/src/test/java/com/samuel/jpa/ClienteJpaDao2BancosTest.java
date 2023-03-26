package com.samuel.jpa;

import com.samuel.dao.jpa.ClienteJpaDB2DAO;
import com.samuel.dao.jpa.ClienteJpaDao;
import com.samuel.dao.jpa.IClienteJpaDao;
import com.samuel.domain.jpa.ClienteJpa;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteJpaDao2BancosTest {

    private IClienteJpaDao<ClienteJpa> clienteDao;

    private IClienteJpaDao<ClienteJpa> clienteDB2Dao;

    private Random rd;

    public ClienteJpaDao2BancosTest() {
        this.clienteDao = new ClienteJpaDao();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        ClienteJpa clienteConsultado2 = (ClienteJpa) clienteDB2Dao.consultar(cliente.getId());
        assertNotNull(clienteConsultado2);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(retorno.getId());
        assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        ClienteJpa clienteConsultado1 = (ClienteJpa) clienteDao.consultar(retorno.getId());
        assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Samuel Ferreira");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = (ClienteJpa) clienteDao.consultar(clienteConsultado.getId());
        assertNotNull(clienteAlterado);
        assertEquals("Samuel Ferreira", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = (ClienteJpa) clienteDao.consultar(clienteAlterado.getId());
        assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        assertNotNull(retorno);

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = (ClienteJpa) clienteDao.cadastrar(cliente1);
        assertNotNull(retorno1);

        Collection<ClienteJpa> list = clienteDao.buscarTodos();
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

        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private ClienteJpa criarCliente() {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Samuel");
        cliente.setEmail("samuel@ebac.com");
        cliente.setCidade("Beberibe");
        cliente.setEndereco("Serra do Félix");
        cliente.setEstado("Ceará");
        cliente.setNumero(10);
        cliente.setTelelefone(1199999999L);
        return cliente;
    }
}
