package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        show.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            show.println("Employee #" + i + " data: ");
            show.print("Outsourced (Y/N)? ");
            char choice = sc.next().toUpperCase().charAt(0);

            while (choice != 'Y' && choice != 'N') {
                show.println("Entrada inválida, digite novamente: ");
                choice = sc.next().toUpperCase().charAt(0);
            }

            show.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            show.print("Hours: ");
            int hours = sc.nextInt();
            show.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (choice == 'N') {

                Employee employee = new Employee(name, hours, valuePerHour);
                list.add(employee);
            } else {
                show.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(employee);
            }
        }

        show.println("PAYMENTS: ");
        for (Employee emp : list) {
            show.println(emp);
        }

        sc.close();
    }

}
