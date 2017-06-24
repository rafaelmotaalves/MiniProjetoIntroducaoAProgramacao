package exceptions;

public class VooNaoCadastradoException extends Exception {
	public VooNaoCadastradoException(){
		super("Não há nenhum voo cadastrado com este número.");
	}

}
