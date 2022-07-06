package application;

import entities.Pessoa;

import java.io.PrintStream;
import java.util.Scanner;

public class ProgramaExercicioMaisVelho {
    public static void main(String[] args) {
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Quantas pessoas você vai digitar? ");
        int numPessoas = sc.nextInt();

        Pessoa[] pessoa = new Pessoa[numPessoas];

        for (int i = 0; i < pessoa.length; i++) {
            show.printf("Dados da %d ª pessoa\n", i + 1);
            show.print("Nome: ");
            String nome = sc.next();
            show.print("Idade: ");
            int idade = sc.nextInt();
            pessoa[i] = new Pessoa(nome, idade);
        }

        int maiorIdade = pessoa[0].getIdade();
        int posicaoMaiorIdade = 0;

        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getIdade() > maiorIdade) {
                maiorIdade = pessoa[i].getIdade();
                posicaoMaiorIdade = i;
            }
        }

        show.printf("Pessoa mais velha: %s\n", pessoa[posicaoMaiorIdade].getNome());

        sc.close();
    }
}
