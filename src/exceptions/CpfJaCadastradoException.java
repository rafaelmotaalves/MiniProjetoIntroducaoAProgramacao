package exceptions;

public class CpfJaCadastradoException extends Exception{
	public CpfJaCadastradoException(){
		super("Ja existe uma pessoa utilizando este CPF");
	}
}
