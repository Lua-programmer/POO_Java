package application;

import util.ConversorMoedas;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioCotacao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("Qual o preço do dollar? ");
        ConversorMoedas.valorMoeda = sc.nextDouble();

        show.print("Quanto em dollar deseja obter? ");
        ConversorMoedas.quantComprada = sc.nextDouble();

        show.printf("O valor em real que você deverá pagar é de: R$ %.2f", ConversorMoedas.conversaoParaReal());

        sc.close();
    }
}
