package exceptions;

public class PilotoInvalidoException extends Exception {
	public PilotoInvalidoException(){
		super("A pessoa fornecida n�o � um piloto v�lido");
	}
}
