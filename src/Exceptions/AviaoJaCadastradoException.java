package Exceptions;

public class AviaoJaCadastradoException extends Exception {
	public AviaoJaCadastradoException(){
		super("O avi�o selecionado j� foi cadastrado.");
	}

}
