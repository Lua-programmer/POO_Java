package entities;

public class PessoaJuridica extends Contribuinte {

    private Integer numeroFuncionarios;

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double imposto() {
        double impostoPago;

        if (numeroFuncionarios > 10) {
             impostoPago = getRendaAnual() * 0.14;
        } else {
            impostoPago = getRendaAnual() * 0.16;
        }

        return impostoPago;
    }

    @Override
    public String toString() {
        return getNome() + ": $ " + String.format("%.2f", imposto());
    }
}
