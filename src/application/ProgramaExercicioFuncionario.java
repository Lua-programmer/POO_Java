package application;

import entities.Funcionario;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioFuncionario {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();

        show.println("Entre com os dados do funcionário: ");
        show.print("Nome: ");
        funcionario.nome = sc.nextLine();
        show.print("Salário bruto: R$ ");
        funcionario.salarioBruto = sc.nextDouble();
        show.print("Taxa de imposto: R$ ");
        funcionario.imposto = sc.nextDouble();

        show.println(funcionario);

        show.print("\nQual porcentagem para acrescentar ao salário? ");
        double porcentagem = sc.nextDouble();

        funcionario.salarioAumento(porcentagem);
        show.println(funcionario);

        sc.close();
    }
}
