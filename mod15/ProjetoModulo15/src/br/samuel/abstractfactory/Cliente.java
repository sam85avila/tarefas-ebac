package br.samuel.abstractfactory;

public class Cliente {

    private boolean vip;

    public Cliente(boolean vip) {
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }
}
