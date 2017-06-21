package Exceptions;

public class cpfInvalidoException extends Exception {
	public cpfInvalidoException(){
		super("O cpf informado não possui o numero correto de caracteres");
	}
}
