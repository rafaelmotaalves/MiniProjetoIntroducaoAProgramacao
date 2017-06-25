package exceptions;
public class CapacidadePassageirosInvalidoException extends Exception{
	public CapacidadePassageirosInvalidoException(){
		super("O avião indicado não tem capacidade suficiente para decolar");
	}

}
