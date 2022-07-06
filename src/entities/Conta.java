package entities;

public class Conta {
    private int numeroDaConta;
    private String usuarioDaConta;
    private double saldoDaConta;

    //CONSTRUTOR COMPLETO
    public Conta(int numeroDaConta, String usuarioDaConta, double saldoDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.usuarioDaConta = usuarioDaConta;
        this.saldoDaConta = saldoDaConta;
    }

    //SOBRECARGA DO CONSTRUTOR COM A ENTRADA DE SALDO OPCIONAL
    public Conta(int numeroDaConta, String usuarioDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.usuarioDaConta = usuarioDaConta;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getUsuarioDaConta() {
        return usuarioDaConta;
    }

    public double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setUsuarioDaConta(String usuarioDaConta) {
        this.usuarioDaConta = usuarioDaConta;
    }


    public void deposito(double quantia) {
        saldoDaConta += quantia;
    }

    public void saque(double quantia) {
        saldoDaConta -= (quantia + 5.00);
    }


}
