package com.samuel;

import com.samuel.dao.ProdutoDAO;
import com.samuel.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    ProdutoDAO produtoDAO = new ProdutoDAO();

    @Test
    public void cadastrarTest() throws Exception{
        Produto produto = new Produto();
        produto.setPreco(BigDecimal.valueOf(2599.99));
        produto.setNome("Notebook");
        Produto produto1 = produtoDAO.cadastrar(produto);
        assertNotNull(produto1);

        Produto produtoDB = produtoDAO.buscarUm(produto1.getId());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getId(), produto1.getId());
        assertEquals(produtoDB.getPreco(), produto1.getPreco());
        assertEquals(produtoDB.getNome(), produto1.getNome());

        Integer qtdDel = produtoDAO.excluir(produtoDB.getId());
        assertTrue(1 == qtdDel);
    }

    @Test
    public void buscarTest() throws Exception {
        Produto produto = new Produto();
        produto.setPreco(BigDecimal.valueOf(2599.99));
        produto.setNome("Notebook");
        Produto produto1 = produtoDAO.cadastrar(produto);
        assertNotNull(produto1);

        Produto produtoDB = produtoDAO.buscarUm(produto1.getId());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getId(), produto1.getId());
        assertEquals(produtoDB.getPreco(), produto1.getPreco());
        assertEquals(produtoDB.getNome(), produto1.getNome());

        Integer qtdDel = produtoDAO.excluir(produtoDB.getId());
        assertTrue(1 == qtdDel);

    }

    @Test
    public void excluirTest() throws Exception{
        Produto produto = new Produto();
        produto.setPreco(BigDecimal.valueOf(2599.99));
        produto.setNome("Notebook");
        Produto produto1 = produtoDAO.cadastrar(produto);
        assertNotNull(produto1);

        Produto produtoDB = produtoDAO.buscarUm(produto1.getId());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getId(), produto1.getId());
        assertEquals(produtoDB.getPreco(), produto1.getPreco());
        assertEquals(produtoDB.getNome(), produto1.getNome());

        Integer qtdDel = produtoDAO.excluir(produtoDB.getId());
        assertTrue(1 == qtdDel);
    }

    @Test
    public void buscarTodosTest() throws Exception{

        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(BigDecimal.valueOf(2599.99));
        Produto cadastrado = produtoDAO.cadastrar(produto);
        assertNotNull(cadastrado);

        Produto produto2 = new Produto();
        produto2.setNome("iPhone 12");
        produto2.setPreco(BigDecimal.valueOf(4599.99));
        Produto cadastrado1 = produtoDAO.cadastrar(produto2);
        assertNotNull(cadastrado1);

        List<Produto> produtos = produtoDAO.buscarTodos();
        assertNotNull(produtos);
        assertEquals(2, produtos.size());

        int count = 0;
        for(Produto p : produtos) {
            produtoDAO.excluir(p.getId());
            count++;
        }
        assertEquals(produtos.size(), count);

        produtos = produtoDAO.buscarTodos();
        assertEquals(0, produtos.size());
    }

    @Test
    public void atualizarTest() throws Exception{
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(BigDecimal.valueOf(2599.99));
        Produto produtoCadastrado = produtoDAO.cadastrar(produto);
        assertNotNull(produtoCadastrado);

        Produto produtoBD = produtoDAO.buscarUm(produtoCadastrado.getId());
        assertNotNull(produtoBD);
        assertEquals(produtoBD.getId(), produtoCadastrado.getId());
        assertEquals(produtoBD.getPreco(), produtoCadastrado.getPreco());
        assertEquals(produtoBD.getNome(), produtoCadastrado.getNome());

        produtoBD.setNome("Notebook Lenovo");
        produtoBD.setPreco(BigDecimal.valueOf(4567.99));
        Produto produtoUp = produtoDAO.atualizar(produtoBD);
        assertNotNull(produtoUp);

        Produto produtoBD1 = produtoDAO.buscarPorNome("Notebook");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscarUm(produtoUp.getId());
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getPreco(), produtoBD2.getPreco());

        List<Produto> produtos = produtoDAO.buscarTodos();
        for (Produto p : produtos) produtoDAO.excluir(p.getId());
    }
}
