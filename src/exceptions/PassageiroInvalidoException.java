package exceptions;

public class PassageiroInvalidoException extends Exception {
	public PassageiroInvalidoException(){
		super("A pessoa fornecida n�o � uma Passageira v�lida");
	}
}
