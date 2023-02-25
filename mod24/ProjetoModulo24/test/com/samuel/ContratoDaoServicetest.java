package com.samuel;


import com.samuel.dao.ContratoDao;
import com.samuel.dao.IContratoDao;
import com.samuel.dao.mock.ContratoDaoMock;
import com.samuel.service.ContratoService;
import com.samuel.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoDaoServicetest {

    @Test
    public void salvarTest() {
        IContratoDao daoMock = new ContratoDaoMock();
        IContratoService service = new ContratoService(daoMock);
        String salvo = service.salvar();
        Assert.assertEquals("Sucesso", salvo);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String salvo = service.salvar();
        Assert.assertEquals("Sucesso", salvo);
    }

    @Test
    public void atualizarTest() {
        IContratoDao daoMock = new ContratoDaoMock();
        IContratoService service = new ContratoService(daoMock);
        String atualizado = service.atualizar();
        Assert.assertEquals("Sucesso", atualizado);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String atualizado = service.atualizar();
        Assert.assertEquals("Sucesso", atualizado);
    }

    @Test
    public void buscarTest() {
        IContratoDao daoMock = new ContratoDaoMock();
        IContratoService service = new ContratoService(daoMock);
        String encontrado = service.atualizar();
        Assert.assertEquals("Sucesso", encontrado);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String encontrado = service.atualizar();
        Assert.assertEquals("Sucesso", encontrado);
    }

    @Test
    public void excluirTest() {
        IContratoDao daoMock = new ContratoDaoMock();
        IContratoService service = new ContratoService(daoMock);
        String excluido = service.excluir();
        Assert.assertEquals("Sucesso", excluido);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String excluido = service.excluir();
        Assert.assertEquals("Sucesso", excluido);
    }
}
