package Exceptions;
public class capacidadeInvalidoException extends Exception{
	public capacidadeInvalidoException(){
		super("O avião indicado não tem capacidade suficiente para decolar");
	}

}
