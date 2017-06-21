package Exceptions;

public class cpfJaCadastradoException extends Exception{
	public cpfJaCadastradoException(){
		super("Ja existe uma pessoa utilizando este CPF");
	}
}
