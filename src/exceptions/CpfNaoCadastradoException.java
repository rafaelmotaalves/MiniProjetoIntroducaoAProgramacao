package exceptions;

public class CpfNaoCadastradoException extends Exception {
	public CpfNaoCadastradoException(){
		super("N�o h� nenhuma pessoa cadastrada com este CPF");
	}
}
