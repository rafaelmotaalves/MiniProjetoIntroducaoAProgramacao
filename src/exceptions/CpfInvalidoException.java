package exceptions;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException(){
		super("O cpf informado n�o possui o numero correto de caracteres");
	}
}
