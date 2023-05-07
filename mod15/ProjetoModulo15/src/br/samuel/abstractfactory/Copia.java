package br.samuel.abstractfactory;

public abstract class Copia {

    private String papel;
    private String impressao;

    public Copia(String papel, String impressao) {
        this.papel = papel;
        this.impressao = impressao;
    }

    public void info() {
        System.out.println("Cópia realizada com papel " + papel +
                " e impressão com qualidade " + impressao);
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getImpressao() {
        return impressao;
    }

    public void setImpressao(String impressao) {
        this.impressao = impressao;
    }
}
