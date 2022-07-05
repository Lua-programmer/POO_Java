package application;

import entities.Aluno;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioAluno {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();

        show.println("Entre com os dados do aluno a seguir: ");
        show.print("Nome: ");
        aluno.nomeAluno = sc.nextLine();

        show.print("Primeira Nota: ");
        aluno.primeiraNota = sc.nextDouble();

        show.print("Segunda Nota: ");
        aluno.segundaNota = sc.nextDouble();

        show.print("Terceira Nota: ");
        aluno.terceiraNota = sc.nextDouble();

        aluno.notaFinal();

        if (aluno.notaFinal() >= 60.00) {
            show.println(aluno.notaFinal());
            show.print("Aprovado");
        } else {
            show.println(aluno.notaFinal());
            show.println("Reprovado");
            show.print("Restam " + aluno.restoNota() + " pontos para se aprovado!");
        }

        sc.close();
    }
}
