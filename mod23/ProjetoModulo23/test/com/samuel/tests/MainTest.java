package com.samuel.tests;

import com.samuel.testes.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void testeListaFeminina() {

//      Digite essas informações para testes
//        sam - m, alice - f, rute - f, marc - m, ellie - f, max - m, lisa - f, mary - f

        String listaStr = JOptionPane.showInputDialog("Digite nomes de pessoas e o gênero separados " +
                "por traço\nExemplo: 'nome - sexo");
        String[] nomesRecebidos = listaStr.split(", ");

        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < nomesRecebidos.length; i++) {

            int pos = nomesRecebidos[i].indexOf("-");
            String n = nomesRecebidos[i].substring(0, pos-1);
            String s = nomesRecebidos[i].substring(pos+2, nomesRecebidos[i].length());

            Pessoa p = new Pessoa(n, s);
            pessoas.add(p);

        }

        List<Pessoa> listaFeminina = pessoas.stream()
                .filter(n -> n.getSexo().equals("f"))
                .collect(Collectors.toList());

        boolean testeLista = listaFeminina.stream()
                .allMatch(n -> n.getSexo().equals("f"));

        Assert.assertEquals(testeLista, true);
    }

}