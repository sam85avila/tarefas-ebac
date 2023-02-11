package com.samuel;

public class Tipos {

    public static void main(String[] args) {

//        Conversão do tipo primitivo int para Wrappers Integer
        int i = 15;
        Integer i1 = Integer.valueOf(i);

//        Conversão do tipo primitivo double para Wrappers Double
//        utilizando o autoboxing
        double d = 10.2;
        Double d1 = d;

        System.out.println("Valor em Integer: " + i1);
        System.out.println("Valor em Double: " + d1);
    }
}
