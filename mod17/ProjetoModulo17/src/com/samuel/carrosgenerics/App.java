package com.samuel.carrosgenerics;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Chevrolet(1L, "Onix Plus"));
        carros.add(new Fiat(2L, "Mobi"));
        carros.add(new Hyundai(3L, "HB20"));

        imprimirCarros(carros);
    }

    public static void imprimirCarros(List<? extends Carro> lista) {
        for (Carro c : lista) c.info();
    }

}
