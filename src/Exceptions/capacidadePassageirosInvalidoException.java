package Exceptions;
public class capacidadePassageirosInvalidoException extends Exception{
	public capacidadePassageirosInvalidoException(){
		super("O avião indicado não tem capacidade suficiente para decolar");
	}

}
