package exceptions;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException(){
		super("O cpf informado não possui o numero correto de caracteres");
	}
}
