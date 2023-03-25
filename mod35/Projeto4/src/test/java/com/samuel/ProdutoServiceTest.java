package com.samuel;

import java.math.BigDecimal;

import com.samuel.exceptions.MaisDeUmRegistroException;
import com.samuel.exceptions.TableException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.samuel.dao.IProdutoDAO;
import com.samuel.dao.ProdutoDaoMock;
import com.samuel.domain.Produto;
import com.samuel.exceptions.DAOException;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;
import com.samuel.services.IProdutoService;
import com.samuel.services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException, MaisDeUmRegistroException, TableException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Lenovo");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Lenovo", produto.getNome());
	}
}
