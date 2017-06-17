package Exceptions;

public class funcionarioInvalidoException extends Exception {
	public funcionarioInvalidoException(){
		super("A pessoa fornecida não é um funcionario válido");
	}
}
