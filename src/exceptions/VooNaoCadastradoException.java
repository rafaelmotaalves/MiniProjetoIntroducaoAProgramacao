package exceptions;

public class VooNaoCadastradoException extends Exception {
	public VooNaoCadastradoException(){
		super("N�o h� nenhum voo cadastrado com este n�mero.");
	}

}
