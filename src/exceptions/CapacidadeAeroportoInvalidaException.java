package exceptions;

public class CapacidadeAeroportoInvalidaException extends Exception{
	public CapacidadeAeroportoInvalidaException(){
		super("Aeroporto com capacidade invalida");
	}
}
