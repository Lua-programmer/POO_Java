package entities;

public class DadosPessoais {
    private double altura;
    private char genero;

    public DadosPessoais(double altura, char genero) {
        this.altura = altura;
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public char getGenero() {
        return genero;
    }
}
