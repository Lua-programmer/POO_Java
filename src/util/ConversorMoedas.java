package util;

public class ConversorMoedas {
    public static double valorMoeda;
    public static double quantComprada;

    public static final double IOF = 0.06;

    public static double conversaoParaReal() {
        quantComprada += quantComprada * IOF;
        return valorMoeda * quantComprada;
    }
}
