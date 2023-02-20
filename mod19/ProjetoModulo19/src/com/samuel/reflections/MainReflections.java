package com.samuel.reflections;

import java.lang.annotation.Annotation;

public class MainReflections {

    public static void main(String[] args) {

        obterAnnotations();

    }

    public static void obterAnnotations() {

        Tabela tabela = new Tabela();
        Annotation[] annotations = tabela.getClass().getAnnotations();

        for (Annotation an : annotations) {
            System.out.println("Tipo de anotação: " + an.annotationType());
        }

        if (tabela.getClass().isAnnotationPresent(TabelaAnnotation.class)) {
            TabelaAnnotation tabelaAnnotation = tabela.getClass().getAnnotation(TabelaAnnotation.class);
            System.out.println("Nome da anotação: " + tabelaAnnotation.toString());
            System.out.println("Valor da anotação: " + tabelaAnnotation.value());
        }

    }
}
