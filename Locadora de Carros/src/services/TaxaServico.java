package services;

public class TaxaServico implements TaxaServicoInterface {
    public double taxa(double quantia) {
        if (quantia <= 100.00) {
            return quantia * 0.2;
        } else {
            return quantia * 0.15;
        }
    }
}
