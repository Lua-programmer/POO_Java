package application;

import entities.Numeros;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioMediaPares {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos elementos vai ter o vetor? ");
        int N = sc.nextInt();

        Numeros[] numeros = new Numeros[N];

        int soma = 0;
        int nPares = 0;
        for (int i = 0; i < numeros.length; i++) {
            show.print("Digite um número: ");
            int numero = sc.nextInt();
            numeros[i] = new Numeros(numero);

            if (numeros[i].getNumeros() % 2 == 0) {
                soma += numeros[i].getNumeros();
                nPares++;
            }
        }

        if (nPares > 0) {
            double media = (double) soma / nPares;
            show.printf("Média dos pares = %.2f", media);
        } else show.print("Nenhum número par");

        sc.close();
    }
}
