package Exceptions;
public class capacidadeInvalidoException extends Exception{
	public capacidadeInvalidoException(){
		super("O avi�o indicado n�o tem capacidade suficiente para decolar");
	}

}
