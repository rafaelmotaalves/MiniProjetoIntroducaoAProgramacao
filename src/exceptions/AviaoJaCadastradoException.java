package exceptions;

public class AviaoJaCadastradoException extends Exception {
	public AviaoJaCadastradoException(){
		super("O avião selecionado já foi cadastrado.");
	}

}
