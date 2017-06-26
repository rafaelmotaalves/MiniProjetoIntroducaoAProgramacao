package exceptions;

public class PassageiroInvalidoException extends Exception {
	public PassageiroInvalidoException(){
		super("A pessoa fornecida não é uma Passageira válida");
	}
}
