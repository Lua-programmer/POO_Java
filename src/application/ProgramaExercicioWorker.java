package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaExercicioWorker {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PrintStream show = System.out;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        show.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        show.println("Enter worker data: ");
        show.print("Name: ");
        String workerName = sc.nextLine();

        show.print("Level: ");
        String workerLevel = sc.nextLine();

        show.print("Base Salary: $");
        double baseSalary = sc.nextDouble();

        //instanciou um novo objeto do tipo work  -- intancia do WorkerLevel e do Department recebendo o valor que foi digitado
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        show.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++) {
            show.println("Enter contract #" + i +" data:");
            show.print("Date (DD/MM/YYYY): ");

            //para utilizar esse tipo precisa criar um simple date format
            Date contractDate = sdf.parse(sc.next());

            show.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            show.print("Duration (hours): ");
            int hour = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hour);
            //para associar o contrato com o trabalhador
            worker.addContract(contract);
        }

        show.println();
        show.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        show.println("Name : " + worker.getName());
        show.println("Department: " + worker.getDepartment().getName());
        show.println("Income for " + monthAndYear + ": $ " + String.format("%f", worker.income(year, month)));

        sc.close();
    }
}
