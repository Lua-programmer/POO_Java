package services;

import entities.AluguelDoCarro;
import entities.Fatura;

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
        long t1 = aluguelDoCarro.getInicio().getTime(); //pega o valor em milisegundos da data
        long t2 = aluguelDoCarro.getFim().getTime();
        //t2-t1 vai achar a diferenca em milisegundos / 1000 para segundos /60 para minutos /60 para horas
        double horas = (double) (t2 - t1) / 1000 / 60 / 60;

        double pagamentoBasico;
        if (horas <= 12) {
            pagamentoBasico = Math.ceil(horas) * precoHora; //Math.ceil vai arredondar a hora pra cima
        } else {
            pagamentoBasico = Math.ceil(horas / 24) * precoDia; //Math.ceil vai arredondar o dia pra cima
        }

        double taxa = taxaServico.taxa(pagamentoBasico);

        aluguelDoCarro.setFatura(new Fatura(pagamentoBasico, taxa));
    }
}
