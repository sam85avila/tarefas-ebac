package br.samuel.abstractfactory;

public class ClienteNormal extends Factory{

    @Override
    Copia recuperarCopia(boolean vip) {
        if(!vip) {
            return new CopiaNormal("normal", "normal");
        }
        return null;
    }
}
