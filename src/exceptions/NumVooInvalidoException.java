package exceptions;

public class NumVooInvalidoException extends Exception{
	public NumVooInvalidoException(){
		super("A numeração do voo não é válida.");
	}

}
