package exceptions;

public class FuncionarioInvalidoException extends Exception {
	public FuncionarioInvalidoException(){
		super("A pessoa fornecida não é um funcionario válido");
	}
}
