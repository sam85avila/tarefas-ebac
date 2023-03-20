package com.samuel.jpa;

import com.samuel.dao.IProdutoJpaDao;
import com.samuel.dao.ProdutoJpaDao;
import com.samuel.domain.Produto;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Collection;

public class ProdutoJpaDAOTest {
    private IProdutoJpaDao produtoDao;

    public ProdutoJpaDAOTest() {
        this.produtoDao = new ProdutoJpaDao();
    }

    @After
    public void end() throws DAOException {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(cli -> {
            try {
                produtoDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getId());
        assertNotNull(produtoDB);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A3");
        assertNotNull(produto);
        this.produtoDao.excluir(produto);
        Produto produtoBD = this.produtoDao.consultar(produto.getId());
        assertNull(produtoBD);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A4");
        produto.setNome("Rodrigo Pires");
        produtoDao.alterar(produto);
        Produto produtoBD = this.produtoDao.consultar(produto.getId());
        assertNotNull(produtoBD);
        assertEquals("Rodrigo Pires", produtoBD.getNome());
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Produto prod : list) {
            this.produtoDao.excluir(prod);
        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("ebac");
        produtoDao.cadastrar(produto);
        return produto;
    }
}
