package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PayPalService;

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
        PrintStream show = System.out;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        show.println("Enter contract data: ");
        show.print("Number: ");
        Integer number = sc.nextInt();

        show.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.nextLine());

        show.print("Contract value R$: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        show.print("Enter number of installments: ");
        int N = sc.nextInt();

        ContractService cs = new ContractService(new PayPalService());

        cs.processContract(contract, N);

        show.println("Installments: ");
        for (Installment it : contract.getInstallments()) {
            show.println(it);
        }

        sc.close();
    }
}
