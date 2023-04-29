package com.samuel.dao;

import com.samuel.domain.Cliente;
import com.samuel.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    Produto cadastrar(Produto produto) throws Exception;

    Produto buscarUm(Long id) throws Exception;

    Integer excluir(Long id) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Produto atualizar(Produto produto) throws Exception;
}
