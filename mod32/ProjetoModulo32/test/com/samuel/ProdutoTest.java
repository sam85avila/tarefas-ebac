package com.samuel;

import com.samuel.dao.ProdutoDAO;
import com.samuel.dao.IProdutoDAO;
import com.samuel.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO cursoDAO;

    public ProdutoTest() {
        cursoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrar() {
        Produto produto = criarProduto("M12");
        assertNotNull(produto);
        assertNotNull(produto.getId());
        cursoDAO.excluir(produto);

        Produto produtoConsultado = cursoDAO.consultarPorId(produto.getId());
        assertTrue(produtoConsultado == null);
    }

    @Test
    public void consultar() {
        Produto produto = criarProduto("C32");
        assertNotNull(produto);

        cursoDAO.excluir(produto);
        Produto produtoConsultado = cursoDAO.consultarPorId(produto.getId());
        assertNull(produtoConsultado);
    }

    @Test
    public void consultarTodos() {
        Produto produto1 = criarProduto("C4");
        assertNotNull(produto1);
        Produto produto2 = criarProduto("C98");
        assertNotNull(produto2);

        List<Produto> produtos = cursoDAO.buscarTodos();
        assertTrue(produtos != null);
        assertTrue(produtos.size() == 2);

        for( Produto c: produtos) {
            cursoDAO.excluir(c);
        }
        produtos = cursoDAO.buscarTodos();
        assertTrue(produtos != null);
        assertTrue(produtos.size() == 0);
    }

    @Test
    public void alterar() {
        Produto produto = criarProduto("J7");
        produto.setNome("Curso Spring Boot");
        cursoDAO.alterar(produto);

        Produto produtoConsultado = cursoDAO.consultarPorId(produto.getId());
        assertNotNull(produtoConsultado);
        assertEquals("Curso Spring Boot", produtoConsultado.getNome());

        cursoDAO.excluir(produtoConsultado);
        produtoConsultado = cursoDAO.consultarPorId(produtoConsultado.getId());
        assertNull(produtoConsultado);
    }

    @Test
    public void excluir() {
        Produto produto = criarProduto("A80");
        assertNotNull(produto);

        cursoDAO.excluir(produto);
        Produto produtoConsultado = cursoDAO.consultarPorId(produto.getId());
        assertNull(produtoConsultado);
    }

     private Produto criarProduto(String codigo) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setValor(BigDecimal.valueOf(2989.99));
        produto.setNome("Samsung Galaxy");
        cursoDAO.cadastrar(produto);
        return produto;
    }
}
