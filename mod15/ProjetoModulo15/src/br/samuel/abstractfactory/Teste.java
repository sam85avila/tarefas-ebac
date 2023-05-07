package br.samuel.abstractfactory;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        Cliente clienteVip = new Cliente(true);
        Factory factory = getFactory(clienteVip);
        Copia copia = factory.copiar(clienteVip.isVip());

        Cliente cliente = new Cliente(false);
        factory = getFactory(cliente);
        copia = factory.copiar(cliente.isVip());
    }

    private static Factory getFactory(Cliente cliente) {
        if (cliente.isVip()) return new ClienteVip();
        return new ClienteNormal();
    }
}
