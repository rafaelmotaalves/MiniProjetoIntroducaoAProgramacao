package Exceptions;

public class cpfInvalidoException extends Exception {
	public cpfInvalidoException(){
		super("O cpf informado n�o possui o numero correto de caracteres");
	}
}
