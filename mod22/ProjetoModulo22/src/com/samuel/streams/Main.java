package com.samuel.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite uma lista de nomes de pessoas com o gênero separados por vírgula.");
        String listaRecebida = entrada.nextLine();

//      Digitei essas inofrmações para testes
//      sam - m, alice - f, rute - f, marc - m, ellie - f, max - m

        String[] nomesRecebidos = listaRecebida.split(", ");

        List<String> listaNomes = Arrays.asList(nomesRecebidos);

        List<String> listaFeminina = listaNomes.stream()
                .filter(n -> n.contains("f"))
                .map(n -> {
                    int pos = n.indexOf(" ");
                    return n.substring(0, pos);
                })
                .collect(Collectors.toList());

        System.out.println("\n*** Lista Feminina ***");
        listaFeminina.forEach(System.out::println);

    }

}
