package application;

import entities.Numeros;

import java.io.PrintStream;
import java.util.Scanner;

public class ProgramaExercicioNegativos {
    public static void main(String[] args) {
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos números você vai digitar? ");
        int N = sc.nextInt();

        //VALIDAÇÃO PARA ENTRAR APENAS 10 NÚMEROS
        while (N <= 0 || N > 10) {
            show.print("No máximo 10 números, digite novamente: ");
            N = sc.nextInt();
        }

        Numeros[] vector = new Numeros[N];

        for (int i = 0; i < vector.length; i++) {
            show.print("Digite um número: ");
            int numero = sc.nextInt();
            vector[i] = new Numeros(numero);
        }

        show.println("Números negativos: ");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].getNumeros() < 0){
                show.printf("%d%n", vector[i].getNumeros());
            }
        }

        sc.close();
    }
}
