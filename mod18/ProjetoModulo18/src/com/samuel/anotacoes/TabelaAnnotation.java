package com.samuel.anotacoes;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface TabelaAnnotation {

    String value();

}
