package application;

import entities.Numeros;

import java.io.PrintStream;
import java.util.Scanner;

public class ProgramaExercicioSomaVetores {
    public static void main(String[] args) {
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos valores vai ter cada vetor? ");
        int N = sc.nextInt();

        Numeros[] vetorA = new Numeros[N];
        Numeros[] vetorB = new Numeros[N];
        int[] vetorC = new int[N];


        show.println("Digite os valores do vetor A: ");
        for (int i = 0; i < N; i++) {
            int numeros = sc.nextInt();
            vetorA[i] = new Numeros(numeros);
        }

        show.println("Digite os valores do vetor B: ");
        for (int i = 0; i < N; i++) {
            int numeros = sc.nextInt();
            vetorB[i] = new Numeros(numeros);
        }

        for (int i = 0; i < N; i++) {
            vetorC[i] = vetorA[i].getNumeros() + vetorB[i].getNumeros();
        }

        show.println("Vetor resultante: ");
        for (int i = 0; i < N; i++) {
            show.println(vetorC[i]);
        }

        sc.close();
    }
}
