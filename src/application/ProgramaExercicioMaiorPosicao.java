package application;

import util.NumerosFloat;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioMaiorPosicao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos números você vai digitar? ");
        int N = sc.nextInt();

        NumerosFloat[] numeros = new NumerosFloat[N];

        for (int i = 0; i < numeros.length; i++) {
            show.print("Digite um número: ");
            double numero = sc.nextDouble();
            numeros[i] = new NumerosFloat(numero);
        }

        double maiorValor = numeros[0].getNumero();
        int maiorPosicao = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].getNumero() > maiorValor) {
                maiorValor = numeros[i].getNumero();
                maiorPosicao = i;
            }
        }

        show.printf("Maior valor: %.2f%n", maiorValor);
        show.printf("Posição de maior valor: %d", maiorPosicao);

        sc.close();
    }
}
