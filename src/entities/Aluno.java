package entities;

public class Aluno {
    public String nomeAluno;
    public double primeiraNota;
    public double segundaNota;
    public double terceiraNota;

    public double notaFinal() {
        return primeiraNota + segundaNota + terceiraNota;
    }

    public double restoNota() {
        return 60 - notaFinal();
    }

    @Override
    public String toString() {
        return "Nota Final: " + notaFinal();
    }
}
