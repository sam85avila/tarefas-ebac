package com.samuel.dao.mock;

import com.samuel.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public String salvar() {
        return "Sucesso";
    }

    @Override
    public String atualizar() {
        return "Sucesso";
    }

    @Override
    public String buscar() {
        return "Sucesso";
    }

    @Override
    public String buscarUm() {
        return "Sucesso";
    }

    @Override
    public String excluir() {
        return "Sucesso";
    }
}
