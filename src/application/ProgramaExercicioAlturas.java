package application;

import entities.Pessoa;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioAlturas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantas pessoas serão digitadas? ");
        int N = sc.nextInt();

        Pessoa[] pessoa = new Pessoa[N];

        for (int i = 0; i < pessoa.length; i++) {
            show.printf("Dados da %dª pessoa\n", i + 1);

            show.print("Nome: ");
            String nome = sc.next();

            show.print("Idade: ");
            int idade = sc.nextInt();

            show.print("Altura: ");
            double altura = sc.nextDouble();

            pessoa[i] = new Pessoa(nome, idade, altura);
        }

        int menorIdade = 0;
        double alturaSoma = 0;

        for (Pessoa value : pessoa) {
            if (value.getIdade() < 16) {
                menorIdade++;
            }

            alturaSoma += value.getAltura();
        }

        double menorIdadePorcentagem = ((double) menorIdade / pessoa.length) * 100;
        double alturaMedia = alturaSoma / pessoa.length;

        show.printf("Altura média: %.2f\n", alturaMedia);
        show.printf("Porcentagem dos menores de 16 anos: %.2f%%\n", menorIdadePorcentagem);
        show.println("Menores de 16: ");

        for (Pessoa value : pessoa) {
            if (value.getIdade() < 16) {
                show.printf("%s\n", value.getNome());
            }
        }
        sc.close();
    }
}
