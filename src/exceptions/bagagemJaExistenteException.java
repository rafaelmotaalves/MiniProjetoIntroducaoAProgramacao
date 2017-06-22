package exceptions;

public class bagagemJaExistenteException extends Exception {
	public bagagemJaExistenteException(){
		super("bagagem já existe");
	}
}
