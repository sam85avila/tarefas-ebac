package com.samuel.dao;

import com.samuel.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    Produto cadastrar(Produto produto);

    void excluir(Produto produto);

    Produto consultarPorId(Long id);

    List<Produto> buscarTodos();

    Produto alterar(Produto produto);
}
