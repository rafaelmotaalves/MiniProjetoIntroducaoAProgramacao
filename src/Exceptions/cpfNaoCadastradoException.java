package exceptions;

public class cpfNaoCadastradoException extends Exception {
	public cpfNaoCadastradoException(){
		super("N�o h� nenhuma pessoa cadastrada com este CPF");
	}
}
