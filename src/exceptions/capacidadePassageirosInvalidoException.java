package exceptions;
public class capacidadePassageirosInvalidoException extends Exception{
	public capacidadePassageirosInvalidoException(){
		super("O avi�o indicado n�o tem capacidade suficiente para decolar");
	}

}
