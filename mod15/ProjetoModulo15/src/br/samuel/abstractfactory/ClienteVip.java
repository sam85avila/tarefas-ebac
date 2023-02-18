package br.samuel.abstractfactory;

public class ClienteVip extends Factory {

    @Override
    Copia recuperarCopia(boolean vip) {
        if (vip) {
            return new CopiaPremium("premium", "alta");
        }
        return null;
    }
}
