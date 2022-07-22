package Model.entities;

import Model.exception.ExcecaoBusiness;

public class Conta {
    private Integer numeroConta;
    private String usuario;
    private Double saldo;
    private Double limiteSaque;

    public Conta(Integer numeroConta, String usuario, Double saldo, Double limiteSaque) {
        this.numeroConta = numeroConta;
        this.usuario = usuario;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getSaldo() {
        return saldo;
    }


    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public void deposito(double quantidade) {
        saldo += quantidade;
    }

    public void saque(double quantidade) {
        validacaoSaque(quantidade);
        saldo -= quantidade;
    }

    private void validacaoSaque(double quantidade) {
        if (quantidade > getLimiteSaque()) {
            throw new ExcecaoBusiness("Erro de saque: A quantia excede o limite de saque!");
        }
        if (quantidade > getSaldo()) {
            throw new ExcecaoBusiness("Erro de saque: Saldo insuficiente!");
        }
    }

}
