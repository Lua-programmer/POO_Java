package application;

import entities.Aluguel;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioPensionato {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos quartos você pretende alugar? ");
        int N = sc.nextInt();

        Aluguel[] quartos = new Aluguel[10];

        for (int i = 0; i < N; i++) {
            show.println(" ");
            show.printf("Aluguel #%d%n", i + 1);
            show.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine(); //VARIAVEL TEMPORARIA.
            show.print("E-mail: ");
            String email = sc.nextLine();
            show.print("Quarto: ");
            int numeroQuarto = sc.nextInt();

            Aluguel pessoa = new Aluguel(nome, email); //INSTANCIA O OBJETO E ATRIBUI A REFERENCIA DELE AO
            //VETOR QUARTOS NA POSIÇAO QUE O USUARIO INFORMOU
            quartos[numeroQuarto] = pessoa;
        }

        show.println(" ");
        show.println("QUARTOS OCUPADOS: ");
        for (int i = 0; i < 10; i++) {
            if (quartos[i] != null) show.println("Quarto " + i + ": " + quartos[i]);
        }

        sc.close();
    }
}
