package entities;

public class Retangulo {
    public double largura;
    public double altura;

    public double area() {
        return largura * altura;
    }

    public double perimetro() {
        return 2 * (largura + altura);
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
    }

    @Override
    public String toString() {
        return "A área do retangulo vale: " + String.format("%.2f%n", area()) +
                "O perimetro do retangulo vale: " + String.format("%.2f%n", perimetro()) +
                "A diagonal do retangulo vale: " + String.format("%.2f%n", diagonal());
    }
}
