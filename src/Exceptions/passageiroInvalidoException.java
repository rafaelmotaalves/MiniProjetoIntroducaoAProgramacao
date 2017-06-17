package Exceptions;

public class passageiroInvalidoException extends Exception {
	public passageiroInvalidoException(){
		super("A pessoa fornecida não é uma Passageira válida");
	}
}
