package com.samuel.dao;

import com.samuel.dao.generics.GenericDAO;
import com.samuel.domain.Cliente;
import com.samuel.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDao extends GenericDAO<Cliente, Long> implements IClienteDao {

    public ClienteDao() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
            entityCadastrado.setCidade(entity.getCidade());
            entityCadastrado.setCpf(entity.getCpf());
            entityCadastrado.setEndereco(entity.getEndereco());
            entityCadastrado.setEstado(entity.getEstado());
            entityCadastrado.setNome(entity.getNome());
            entityCadastrado.setNumero(entity.getNumero());
            entityCadastrado.setTelefone(entity.getTelefone());
    }

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        return null;
    }
}
