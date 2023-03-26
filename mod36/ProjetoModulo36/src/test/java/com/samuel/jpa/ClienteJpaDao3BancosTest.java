package com.samuel.jpa;

import com.samuel.dao.jpa.ClienteJpaDB2DAO;
import com.samuel.dao.jpa.ClienteJpaDB3DAO;
import com.samuel.dao.jpa.ClienteJpaDao;
import com.samuel.dao.jpa.IClienteJpaDao;
import com.samuel.domain.jpa.ClienteJpa;
import com.samuel.domain.jpa.ClienteJpa2;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

public class ClienteJpaDao3BancosTest {

    private IClienteJpaDao<ClienteJpa> clienteDao;

    private IClienteJpaDao<ClienteJpa> clienteDB2Dao;

    private IClienteJpaDao<ClienteJpa2> clienteDB3Dao;

    private Random rd;

    public ClienteJpaDao3BancosTest() {
        this.clienteDao = new ClienteJpaDao();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        this.clienteDB3Dao = new ClienteJpaDB3DAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        excluir(list, clienteDao);

        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir(list2, clienteDB2Dao);

        Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
        excluir3(list3);
    }

    private void excluir(Collection<ClienteJpa> list, IClienteJpaDao<ClienteJpa> clienteDao) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir3(Collection<ClienteJpa2> list) {
        list.forEach(cli -> {
            try {
                clienteDB3Dao.excluir(cli);
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
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        ClienteJpa clienteConsultado2 = (ClienteJpa) clienteDB2Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

        ClienteJpa2 cliente2 = criarCliente2();
        clienteDB3Dao.cadastrar(cliente2);

        ClienteJpa2 clienteConsultado3 = (ClienteJpa2) clienteDB3Dao.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        ClienteJpa clienteConsultado1 = (ClienteJpa) clienteDao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = (ClienteJpa) clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Samuel Ferreira");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = (ClienteJpa) clienteDao.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Samuel Ferreira", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = (ClienteJpa) clienteDao.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = (ClienteJpa) clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = (ClienteJpa) clienteDao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        Assert.assertTrue(list != null);
        Assert.assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        Assert.assertTrue(list1 != null);
        Assert.assertTrue(list1.size() == 0);
    }

    private ClienteJpa criarCliente() {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Samuel");
        cliente.setEmail("sam@ebac.com");
        cliente.setCidade("Beberibe");
        cliente.setEndereco("Serra do Félix");
        cliente.setEstado("Ceará");
        cliente.setNumero(10);
        cliente.setTelelefone(8599999988L);
        return cliente;
    }

    private ClienteJpa2 criarCliente2() {
        ClienteJpa2 cliente = new ClienteJpa2();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Machado");
        cliente.setEmail("mac@ebac.com");
        cliente.setCidade("Beberibe");
        cliente.setEndereco("Serra do Félix");
        cliente.setEstado("Ceará");
        cliente.setNumero(69);
        cliente.setTelelefone(8599999999L);
        return cliente;
    }

}
