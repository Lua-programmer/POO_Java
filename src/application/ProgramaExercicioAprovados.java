package application;

import entities.Alunos;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioAprovados {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantos alunos serão digitados? ");
        int N = sc.nextInt();

        Alunos[] alunos = new Alunos[N];

        for (int i = 0; i < alunos.length; i++) {
            show.printf("Digite o nome, primeira e segunda nota do %d ° aluno:\n", i + 1);
            sc.nextLine();
            String nome = sc.nextLine();
            double primeiraNota = sc.nextDouble();
            double segundaNota = sc.nextDouble();

            alunos[i] = new Alunos(nome, primeiraNota, segundaNota);
        }

        show.println("Alunos Aprovados: ");

        for (Alunos aluno : alunos) {
            double media = aluno.mediaFinal();
            if (media >= 6.0) show.printf("%s\n", aluno.getNome());
        }

        sc.close();

    }
}
