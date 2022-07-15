package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import javax.xml.transform.stax.StAXResult;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PrintStream show = System.out;

        List<Contribuinte> contribuintes = new ArrayList<>();

        show.print("Entre com o número de contribuintes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            show.println();
            show.println("Dados do " + i + "° contribuinte: ");
            show.print("Invidual ou Empresa: (I / E): ");
            char choice = sc.next().toUpperCase().charAt(0);

            while (choice != 'E' && choice != 'I') {
                show.print("Entrada inválida, tente novamente: ");
                choice = sc.next().toUpperCase().charAt(0);
            }

            show.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();

            show.print("Renda Anual: R$");
            double rendaAnual = sc.nextDouble();

            if (choice == 'E') {
                show.print("Número de funcionários: ");
                int numeroFuncionarios = sc.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            } else {
                show.print("Despesas com saúde: R$");
                double gastosSaude = sc.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            }
        }

        show.println();
        show.println("Impostos a serem pagos pelos contribuintes: ");

        for (Contribuinte cb : contribuintes) {
            show.println(cb);
        }

        show.println();

        double taxa = 0;
        for (Contribuinte tx : contribuintes) {
            taxa += tx.imposto();
        }

        show.printf("Total de impostos: R$ %.2f", taxa);


        sc.close();
    }
}
