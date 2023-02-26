package com.samuel.services;

import com.samuel.domain.Cliente;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

    boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
