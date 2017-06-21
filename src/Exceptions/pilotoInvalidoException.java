package Exceptions;

public class pilotoInvalidoException extends Exception {
	public pilotoInvalidoException(){
		super("A pessoa fornecida não é um piloto válido");
	}
}
