package exceptions;

public class passageiroInvalidoException extends Exception {
	public passageiroInvalidoException(){
		super("A pessoa fornecida n�o � uma Passageira v�lida");
	}
}
