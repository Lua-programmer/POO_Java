package application;

import entities.AluguelDoCarro;
import entities.Veiculo;
import services.ServicoAluguel;
import services.TaxaServico;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:ss");
        PrintStream show = System.out;

        show.println("Entre com os dados do aluguel:");
        show.print("Modelo do carro: ");
        String modelo = sc.nextLine();
        show.print("Check-in: (dd/MM/yyy HH:ss) ");
        Date inicio = sdf.parse(sc.nextLine());
        show.print("Check-out: (dd/MM/yyy HH:ss) ");
        Date fim = sdf.parse(sc.nextLine());

        AluguelDoCarro aluguelDoCarro = new AluguelDoCarro(inicio, fim, new Veiculo(modelo));

        show.println();
        show.print("Entre com o valor do preço por hora: R$ ");
        double precoHora = sc.nextDouble();
        show.print("Entre com o valor do preço por dia: R$ ");
        double precoDia = sc.nextDouble();

        ServicoAluguel servicoAluguel = new ServicoAluguel(precoDia, precoHora, new TaxaServico());

        servicoAluguel.processamentoFatura(aluguelDoCarro);

        show.println("FATURA:");
        show.println("Pagamento básico: " + String.format("%.2f", aluguelDoCarro.getFatura().getPagamentoBasico()));
        show.println("Taxa: " + String.format("%.2f", aluguelDoCarro.getFatura().getTaxa()));
        show.println("Pagamento final: " + String.format("%.2f", aluguelDoCarro.getFatura().getPagamentoTotal()));

        sc.close();
    }
}
