package Exceptions;

public class cpfNaoCadastradoException extends Exception {
	public cpfNaoCadastradoException(){
		super("Não há nenhuma pessoa cadastrada com este CPF");
	}
}
