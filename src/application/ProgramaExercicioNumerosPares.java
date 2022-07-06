package application;

import util.SomaPares;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramaExercicioNumerosPares {
    public static void main(String[] args) {
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos números você vao digitar? ");
        int N = sc.nextInt();

        SomaPares[] numeros = new SomaPares[N];

        for (int i = 0; i < numeros.length; i++) {
            show.print("Digite um número: ");
            int numero = sc.nextInt();
            numeros[i] = new SomaPares(numero);
        }

        show.println("NÚMEROS PARES:");

        int quantNumerosPares = 0;

        for (SomaPares numero : numeros) {
            if (numero.getNumero() % 2 == 0) {
                show.print(numero.getNumero() + ", ");
                quantNumerosPares++;
            }
        }

        show.printf("\nQUANTIDADE DE PARES = %d", quantNumerosPares);

        sc.close();
    }
}
