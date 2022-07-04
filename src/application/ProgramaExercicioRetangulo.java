package application;

import entities.Retangulo;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioRetangulo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        Retangulo retangulo = new Retangulo();

        show.println("Entre com a largura e a altura do retangulo, respectivamente. \nA seguir é apresentado o valor da sua área, perimetro e diagonal.");
        show.print("Largura: ");
        retangulo.largura = sc.nextDouble();
        show.print("Altura: ");
        retangulo.altura = sc.nextDouble();

        show.println(retangulo);

        sc.close();
    }
}
