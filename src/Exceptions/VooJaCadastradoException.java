package Exceptions;

public class VooJaCadastradoException extends Exception {
	public VooJaCadastradoException(){
		super("O voo selecionado já foi cadastrado.");
	}

}