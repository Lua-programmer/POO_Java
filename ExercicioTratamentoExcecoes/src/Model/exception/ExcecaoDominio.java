package Model.exception;

public class ExcecaoDominio extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public  ExcecaoDominio(String msg) {
        super(msg); //Passando o msg para o construtor da superclasse
    }
}
