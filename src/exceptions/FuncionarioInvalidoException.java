package exceptions;

public class FuncionarioInvalidoException extends Exception {
	public FuncionarioInvalidoException(){
		super("A pessoa fornecida n�o � um funcionario v�lido");
	}
}
