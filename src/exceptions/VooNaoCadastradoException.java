package exceptions;

public class VooNaoCadastradoException extends Exception {
	public VooNaoCadastradoException(int num){
		super("N�o h� nenhum voo cadastrado com este n�mero.");
	}

}
