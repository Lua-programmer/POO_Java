package View.application;

import Model.entities.Reserva;
import Model.exception.ExcecaoDominio;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramReservadeHotel {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PrintStream show = System.out;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            show.print("Número do quarto: ");
            int numeroQuarto = sc.nextInt();

            show.print("Data de check-In: ");
            Date checkIn = sdf.parse(sc.next());

            show.print("Data de check-Out: ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            show.println("Reserva: " + reserva);

            show.println("Entre com as datas de atualização da reserva: ");
            show.print("Data de check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            show.print("Data de check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizacaoDatas(checkIn, checkOut);
            show.println("Reserva: " + reserva);
        }
        catch (ParseException e ) {
            show.println("Formato de data inválido!");
        }
        catch (ExcecaoDominio e) {
            show.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            show.println("Erro inesperado");
        }


        sc.close();
    }
}
