package application;

import util.CalculatorVetor;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioSomaVetor {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos números você vai digitar? ");
        int N = sc.nextInt();

        CalculatorVetor[] vec = new CalculatorVetor[N];

        for (int i = 0; i < vec.length; i++) {
            show.print("Digite um número: ");
            double numero = sc.nextDouble();
            vec[i] = new CalculatorVetor(numero);
        }

        show.println("VALORES = ");
        for (CalculatorVetor calculatorVetor : vec) {
            show.printf("%.1f%n", calculatorVetor.getNumero());
        }

        double soma = 0;
        for (CalculatorVetor calculatorVetor : vec) {
            soma += calculatorVetor.getNumero();
        }
        double media = soma/vec.length;

        show.printf("SOMA = %.2f%n", soma);
        show.printf("MEDIA = %.2f%n", media);


        sc.close();
    }
}
