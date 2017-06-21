package Exceptions;

public class bagagemJaExistenteException extends Exception {
	public bagagemJaExistenteException(){
		super("bagagem já existe");
	}
}
