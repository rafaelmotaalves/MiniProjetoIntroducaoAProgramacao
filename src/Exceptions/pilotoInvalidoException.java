package Exceptions;

public class pilotoInvalidoException extends Exception {
	public pilotoInvalidoException(){
		super("A pessoa fornecida n�o � um piloto v�lido");
	}
}
