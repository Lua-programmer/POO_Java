package services;

import entities.AluguelDoCarro;
import entities.Fatura;

public class ServicoAluguel {
    private Double precoDia;
    private Double precoHora;

    private TaxaServicoInterface taxaServicoInterface;

    public ServicoAluguel(Double precoDia, Double precoHora, TaxaServicoInterface taxaServicoInterface) {
        this.precoDia = precoDia;
        this.precoHora = precoHora;
        this.taxaServicoInterface = taxaServicoInterface;
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

        double taxa = taxaServicoInterface.taxa(pagamentoBasico);

        aluguelDoCarro.setFatura(new Fatura(pagamentoBasico, taxa));
    }
}
