package View.application;

import Model.entities.Conta;
import Model.exception.ExcecaoBusiness;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramContaBancaria {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PrintStream show = System.out;

        show.println("Informe os dados da conta: ");
        show.print("Número da conta: ");
        int numeroConta = sc.nextInt();

        show.print("Usuário: ");
        sc.nextLine();
        String usuario = sc.nextLine();

        show.print("Saldo inicial: R$ ");
        double saldo = sc.nextDouble();

        show.print("Limite da conta: R$ ");
        double limiteSaque = sc.nextDouble();

        Conta conta = new Conta(numeroConta, usuario, saldo, limiteSaque);

        show.println();
        show.print("Entre com a quantia de saque: R$ ");
        double quantidade = sc .nextDouble();

        try {
            conta.saque(quantidade);
            show.printf("Novo Saldo: R$ %.2f%n", conta.getSaldo());
        }
        catch (ExcecaoBusiness e) {
            show.println(e.getMessage());
        }

        sc.close();
    }
}
