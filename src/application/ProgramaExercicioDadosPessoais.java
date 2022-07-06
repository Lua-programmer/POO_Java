package application;

import entities.DadosPessoais;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioDadosPessoais {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantas pessoas serão digitadas? ");
        int N = sc.nextInt();

        DadosPessoais[] pessoa = new DadosPessoais[N];

        for (int i = 0; i < pessoa.length; i++) {
            show.printf("Altura da %d pessoa: ", i + 1);
            double altura = sc.nextDouble();

            show.printf("Gênero da %d pessoa: ", i + 1);
            char genero = sc.next().toUpperCase().charAt(0);
            while (genero != 'M' && genero != 'F') {
                show.println("Gênero inválido, digite novamente: ");
                genero = sc.next().toUpperCase().charAt(0);
            }

            pessoa[i] = new DadosPessoais(altura, genero);
        }

        double menorAltura = pessoa[0].getAltura();
        double maiorAltura = pessoa[0].getAltura();
        double somaDasAlturas = 0;
        int quantFeminino = 0;
        int quantMasculino = 0;

        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getAltura() < menorAltura) menorAltura = pessoa[i].getAltura();
            if (pessoa[i].getAltura() > maiorAltura) maiorAltura = pessoa[i].getAltura();
            if (pessoa[i].getGenero() == 'F') {
                somaDasAlturas += pessoa[i].getAltura();
                quantFeminino++;
            }
            if (pessoa[i].getGenero() == 'M') quantMasculino++;
        }

        double mediaAlturaFeminino = somaDasAlturas / quantFeminino;


        show.printf("Menor altura = %.2f%n", menorAltura);
        show.printf("Maior altura = %.2f%n", maiorAltura);
        show.printf("Media das alturas das mulheres = %.2f%n", mediaAlturaFeminino);
        show.printf("Número de homens = %d%n", quantMasculino);

        sc.close();
    }
}
