package com.samuel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parte1 {

    public static void main(String[] args) {

        String[] nomesRecebidos = {"Rute", "Alex", "Pedro", "Silas", "Bernardo"};
        List<String> nomes = new ArrayList<>();

        for(int i = 0; i < nomesRecebidos.length; i++) {
            nomes.add(nomesRecebidos[i]);
        }

        Collections.sort(nomes);
        System.out.println(nomes);
    }
}
