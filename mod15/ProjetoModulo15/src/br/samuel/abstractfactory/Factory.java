package br.samuel.abstractfactory;

public abstract class Factory {

    public Copia copiar(boolean vip) {
        Copia copia = recuperarCopia(vip);
        copia = prepararCopia(copia);
        return copia;
    }

    public Copia prepararCopia(Copia copia) {
        copia.info();
        return copia;
    }

    abstract Copia recuperarCopia(boolean vip);
}
