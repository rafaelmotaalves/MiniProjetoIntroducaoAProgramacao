package exceptions;
public class CapacidadePassageirosInvalidoException extends Exception{
	public CapacidadePassageirosInvalidoException(){
		super("O avi�o indicado n�o tem capacidade suficiente para decolar");
	}

}
