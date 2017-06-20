package exceptions;

public class IdNaoCadastradaException extends Exception{
	public IdNaoCadastradaException(int ID){
		super("Não há nenhum avião cadastrado com esta ID.");
	}

}
