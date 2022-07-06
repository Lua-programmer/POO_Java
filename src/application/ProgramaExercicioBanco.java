package application;

import entities.Conta;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioBanco {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.println("------------BEM-VINDXS AO BANCO INSIDER------------");
        show.println(" ");
        show.println("A seguir, entre com os dados solicitados para a abertura de conta");
        show.println(" ");

        show.println("Digite o número da conta com 4 dígitos: ");
        int numeroDaConta = sc.nextInt();
        show.println(" ");

        while (numeroDaConta < 1000 || numeroDaConta > 9999) {
            if (numeroDaConta < 1000) {
                show.println("Você digitou menos de 4 dígitos, tente novamente: ");
                numeroDaConta = sc.nextInt();
                show.println(" ");
            } else if (numeroDaConta > 9999) {
                show.println("Você digitou mais de 4 dígitos, tente novamente: ");
                numeroDaConta = sc.nextInt();
                show.println(" ");
            }
        }

        show.print("Digite o nome do usuário: ");
        sc.nextLine(); //PARA ADICIONAR O NOME COMPLETO ATE A QUEBRA DE LINHA
        String usuarioDaConta = sc.nextLine();
        show.println(" ");

        show.print("Deseja fazer um depósito inicial (S/N)? ");
        char escolha = sc.next().toUpperCase().charAt(0);
        show.println(" ");

        while (escolha != 'S' && escolha != 'N') {
            show.print("Escolha errada, digite entre S / N: ");
            escolha = sc.next().toUpperCase().charAt(0);
            show.println(" ");
        }

        Conta conta = new Conta(numeroDaConta, usuarioDaConta);

        if (escolha == 'N') {
            show.println("Abertura de conta realizada com sucesso. \n>>>> DADOS DA CONTA: ");
            show.printf("Número da conta: %d, Usuário da conta: %s, Saldo: R$ %.2f%n", conta.getNumeroDaConta(), conta.getUsuarioDaConta(), conta.getSaldoDaConta());

        } else {
            show.print("Digite o valor inicial para depósito: R$ ");
            double quantia = sc.nextDouble();
            conta.deposito(quantia);
            show.println("Abertura de conta realizada com sucesso. \n>>>> DADOS DA CONTA: ");
            show.printf("Número da conta: %d, Usuário da conta: %s, Saldo: R$ %.2f%n", conta.getNumeroDaConta(), conta.getUsuarioDaConta(), conta.getSaldoDaConta());
        }

        show.println(" ");
        show.println("Selecione umas das opções para prosseguir: ");
        show.println(" ");
        show.println("1. SAIR  2.DEPOSITAR  3.SACAR  4.ALTERAR DADOS");
        show.println(" ");
        int escolhaFinal = sc.nextInt();
        show.println(" ");

        while (escolhaFinal > 4 || escolhaFinal <= 0) {
            show.print("OPS! Você digitou a opção errada, tente novamente: ");
            show.println(" ");
            escolhaFinal = sc.nextInt();
            show.println(" ");
        }

        switch (escolhaFinal) {
            case 1:
                show.print("OBRIGADA PELA PREFERÊNCIA");
                break;
            case 2:
                show.print("Entre com o valor de depósito: R$");
                double quantia = sc.nextDouble();
                conta.deposito(quantia);
                show.println("\n>>>> DADOS DA CONTA: ");
                show.printf("Número da conta: %d, Usuário da conta: %s, Saldo: R$ %.2f%n", conta.getNumeroDaConta(), conta.getUsuarioDaConta(), conta.getSaldoDaConta());
                break;
            case 3:
                show.print("Entre com o valor do saque: R$");
                quantia = sc.nextDouble();
                conta.saque(quantia);
                show.println("\n>>>> DADOS DA CONTA: ");
                show.printf("Número da conta: %d, Usuário da conta: %s, Saldo: R$ %.2f%n", conta.getNumeroDaConta(), conta.getUsuarioDaConta(), conta.getSaldoDaConta());
                break;
            case 4:
                show.println("Você só tem permissão de alterar o nome do usuário da conta");
                show.print("Digite o novo nome: ");
                sc.nextLine();
                usuarioDaConta = sc.nextLine();
                show.println(" ");
                conta.setUsuarioDaConta(usuarioDaConta);
                show.println("\n>>>> DADOS DA CONTA: ");
                show.printf("Número da conta: %d, Usuário da conta: %s, Saldo: R$ %.2f%n", conta.getNumeroDaConta(), conta.getUsuarioDaConta(), conta.getSaldoDaConta());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + escolhaFinal);
        }

        sc.close();
    }
}
