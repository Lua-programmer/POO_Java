package entities;

import java.util.Date;

public class AluguelDoCarro {
    private Date inicio;
    private Date fim;

    private Veiculo veiculo; //o aluguel terá um veiculo
    private Fatura fatura; // o aluguel terá uma fatura

    public AluguelDoCarro(Date inicio, Date fim, Veiculo veiculo) {
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        //não coloca o da fatura pq a fatura pode ainda estar processando
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
