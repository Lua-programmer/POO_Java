package Model.entities;

import Model.exception.ExcecaoDominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkIn, Date chockOut) {

        if (!checkOut.after(checkIn)) {
            throw new ExcecaoDominio("Data de check-Out é anterior a de check-In");
        }

        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = chockOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getChockOut() {
        return checkOut;
    }

    public long duracao() {
        long diferenca = checkOut.getTime() - checkIn.getTime(); //getTime() devolve a quantidade de milisegundos da data
        //convertendo os milisegundos para data
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoDatas(Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            //new IllegalArgumentException é usado quando os argumentos não estão corretos
            throw new ExcecaoDominio("Datas informadas estão antes da data atual");
        }
        if (!checkOut.after(checkIn)) {
            throw new ExcecaoDominio("Data de check-Out é anterior a de check-In");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto: " +
                numeroQuarto +
                ", check-in: " +
                sdf.format(checkIn) +
                ", check-out: " +
                sdf.format(checkOut) +
                ", " +
                duracao() + " noites.";
    }
}
