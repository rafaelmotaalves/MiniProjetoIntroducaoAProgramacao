package exceptions;

public class CpfNaoCadastradoException extends Exception {
	public CpfNaoCadastradoException(){
		super("Não há nenhuma pessoa cadastrada com este CPF");
	}
}
