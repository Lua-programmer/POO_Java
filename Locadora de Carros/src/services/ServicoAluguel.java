package services;

import entities.AluguelDoCarro;

public class ServicoAluguel {
    private Double precoDia;
    private Double precoHora;

    private TaxaServico taxaServico;

    public ServicoAluguel(Double precoDia, Double precoHora, TaxaServico taxaServico) {
        this.precoDia = precoDia;
        this.precoHora = precoHora;
        this.taxaServico = taxaServico;
    }

    public Double getPrecoDia() {
        return precoDia;
    }

    public void setPrecoDia(Double precoDia) {
        this.precoDia = precoDia;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public TaxaServico getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(TaxaServico taxaServico) {
        this.taxaServico = taxaServico;
    }

    //metodo responsavel por gerar a nota de pagamento

    public void processamentoFatura(AluguelDoCarro aluguelDoCarro) {

    }
}
