package com.samuel.services;

import com.samuel.dao.IClienteDao;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDao.cadastrar(cliente);
        return true;
    }

    @Override
    public Cliente buscarPorCpf(Long cpf)  {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDao.alterar(cliente);
    }

}
