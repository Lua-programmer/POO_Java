package entities;

public class PessoaFisica extends Contribuinte {

    private Double gastosSaude;

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double imposto() {
        double impostoPago;

        if (getRendaAnual() < 20000.00) {
            impostoPago = getRendaAnual() * 0.15;
        } else {
            if (getGastosSaude() > 0.0) {
                impostoPago = (getRendaAnual() * 0.25) - (getGastosSaude() * 0.50);
            } else {
                impostoPago = getRendaAnual() * 0.25;
            }
        }

        return impostoPago;
    }

    @Override
    public String toString() {
        return getNome() + ": $ " + String.format("%.2f", imposto());
    }
}
