package Exceptions;

public class funcionarioInvalidoException extends Exception {
	public funcionarioInvalidoException(){
		super("A pessoa fornecida n�o � um funcionario v�lido");
	}
}
