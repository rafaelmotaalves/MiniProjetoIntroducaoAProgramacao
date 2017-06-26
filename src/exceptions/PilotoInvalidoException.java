package exceptions;

public class PilotoInvalidoException extends Exception {
	public PilotoInvalidoException(){
		super("A pessoa fornecida não é um piloto válido");
	}
}
