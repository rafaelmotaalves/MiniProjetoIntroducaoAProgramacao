package Exceptions;

public class VooJaCadastradoException extends Exception {
	public VooJaCadastradoException(){
		super("O voo selecionado j� foi cadastrado.");
	}

}