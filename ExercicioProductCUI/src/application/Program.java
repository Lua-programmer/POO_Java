package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        show.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            show.println("Product #" + i + " data:");
            show.print("Common, used or imported (C/U/I)? ");
            char choice = sc.next().toUpperCase().charAt(0);

            while (choice != 'C' && choice != 'U' && choice != 'I') {
                show.print("Invalid Input! Try again: ");
                choice = sc.next().toUpperCase().charAt(0);
            }

            show.print("Product Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            show.print("Price: ");
            Double price = sc.nextDouble();

            if (choice == 'C') {
                products.add(new Product(name, price));
            } else if (choice == 'I') {
                show.print("Customs fee: ");
                Double customsFee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsFee));
            } else {
                show.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());

                products.add(new UsedProduct(name, price, manufactureDate));
            }
        }

        show.println("PRICE TAGS: ");
        for (Product prod: products) {
            show.println(prod.priceTag());
        }

        sc.close();
    }
}
