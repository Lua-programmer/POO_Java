package entities;

public class Alunos {
    private String nome;
    private double primeiraNota;
    private double segundaNota;

    public Alunos(String nome, double primeiraNota, double segundaNota) {
        this.nome = nome;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

    public String getNome() {
        return nome;
    }

    public double getPrimeiraNota() {
        return primeiraNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    public double mediaFinal() {
        return (getPrimeiraNota() + getSegundaNota()) / 2;
    }

}
