package com.samuel;

import java.util.ArrayList;
import java.util.List;

public class Parte2 {


    public static void main(String[] args) {
        String[] nomesRecebidos = {"Alice - f", "Jon - m", "Cecilia - f", "Max - m"};

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();


        for(int i = 0; i < nomesRecebidos.length; i++) {
            String[] split = nomesRecebidos[i].split(" - ");
            if (split[1].equals("m")) {
                masculino.add(split[0]);
            } else {
                feminino.add((split[0]));
            }
        }

        System.out.println("Grupo Masculino: " + masculino);
        System.out.println("Grupo Feminino: " +feminino);
    }

}
