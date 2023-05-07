package modulo7;

/**
 * @author samuel ferreira
 *
 * @version 1.0
 */
public class Cachorro {

    private String nome;
    private String raca;
    private String cor;
    private Double tamanho;

    /**
     * método que imprime a ação de comer do cachorro
     * @param comida
     */
    public void comer(String comida) {
        System.out.printf("\nO %s está comendo %s\n", nome, comida);
    }

    /**
     * método que descreve o cachorro emtindo som
     */
    public void latir() {
        System.out.println("\nAu! Au! Au!");
    }

    /**
     * método que descreve a ação de correr do cachorro
     */
    public void correr() {
        System.out.printf("\nO %s está correndo...\n", nome);
    }

    /**
     * método que apresenta todas as características do cachorro
     */
    public void apresentar() {
        System.out.printf("\n###Apresentação###\n" +
                        "Nome: %s\n" +
                        "Raça: %s\n" +
                        "Cor: %s\n" +
                        "Tamanho: %.2f m\n",
                        nome, raca, cor, tamanho);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }
}
