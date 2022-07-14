package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramExercicioClient {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        show.println("Entre client data: ");
        show.print("Name: ");
        String name = sc.nextLine();
        show.print("Email: ");
        String email = sc.next();
        show.print("Birth date (DD/MM/YYYY): ");
        Date birthDate;
        birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        show.println("Enter order data: ");
        show.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        show.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            show.println("Enter #" + i + " item data:");
            show.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            show.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            show.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        show.println();
        show.println("ORDER SUMMARY:");
        show.println(order);


        sc.close();
    }
}
