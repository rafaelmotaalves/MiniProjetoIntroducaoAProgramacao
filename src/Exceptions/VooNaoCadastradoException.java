package Exceptions;

public class VooNaoCadastradoException extends Exception {
	public VooNaoCadastradoException(int num){
		super("Não há nenhum voo cadastrado com este número.");
	}

}
