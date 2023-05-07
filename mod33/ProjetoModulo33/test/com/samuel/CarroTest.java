package com.samuel;

import com.samuel.dao.*;
import com.samuel.domain.Acessorio;
import com.samuel.domain.Carro;
import com.samuel.domain.Marca;
import static org.junit.Assert.*;
import org.junit.Test;

public class CarroTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Carro carro = criarCarro("HBO20E7");
        assertNotNull(carro);
        assertNotNull(carro.getId());

    }

    private Carro criarCarro(String placa) {
        Marca marca = criarMarca("H1");
        Acessorio acessorio1 = criarAcessorio("H3");
        Acessorio acessorio2 = criarAcessorio("H4");

        Carro carro = new Carro();
        carro.setPlaca(placa);
        carro.setModelo("HB20");
        carro.setMarca(marca);
        carro.add(acessorio1);
        carro.add(acessorio2);
        Carro carroCadastrado = carroDao.cadastrar(carro);
        return carroCadastrado;
    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome("hyundai");
        return acessorio;
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Hyundai");
        Marca marcaCadastrada = marcaDao.cadastrar(marca);
        return marcaCadastrada;
    }
}
