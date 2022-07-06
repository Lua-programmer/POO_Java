package application;

import util.NumerosFloat;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioAbaixoDaMedia {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos elementos vai ter seu vetor? ");
        int N = sc.nextInt();

        NumerosFloat[] numeros = new NumerosFloat[N];

        double soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            show.print("Digite um número: ");
            double numero = sc.nextDouble();
            numeros[i] = new NumerosFloat(numero);
            soma += numeros[i].getNumero();
        }

        double media = soma / numeros.length;

        show.printf("Média do vetor = %.3f\n", media);
        show.println("Elementos abaixo da média:");

        for (NumerosFloat numero : numeros) {
            if (numero.getNumero() < media) show.println(numero.getNumero());
        }

        sc.close();
    }
}
