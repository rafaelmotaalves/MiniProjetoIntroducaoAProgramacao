package exceptions;

public class IdNaoCadastradaException extends Exception{
	public IdNaoCadastradaException(int ID){
		super("N�o h� nenhum avi�o cadastrado com esta ID.");
	}

}
