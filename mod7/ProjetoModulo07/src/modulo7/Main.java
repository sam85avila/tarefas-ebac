package modulo7;

/**
 * @author samuel ferreira
 *
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        cachorro.setNome("Scooby Doo");
        cachorro.setCor("Marrom");
        cachorro.setRaca("dogue alemão");
        cachorro.setTamanho(1.2);

        cachorro.comer("ração");
        cachorro.latir();
        cachorro.correr();
        cachorro.apresentar();
    }
}
