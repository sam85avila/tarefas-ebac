package com.samuel;

import java.util.Scanner;

public class Media {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int count = 0;
        Double notas = 0d;

        while (count < 4) {
            System.out.println("Digite a nota " + (count + 1));
            Double nota = entrada.nextDouble();
            if (nota >= 0 && nota <= 10) {
                notas+=nota;
                count++;
            } else {
                System.out.println("Nota inválida. Tente novamente.");
            }
        }

        Double media = notas / 4;

        if (media >= 7) {
            System.out.println("Parabéns! Aprovado com média: " + media);
        } else if (media >= 5) {
            System.out.println("Recuperação! Média: " + media);
        } else {
            System.out.println("Reprovado com média: " + media);
        }

        entrada.close();
    }
}
