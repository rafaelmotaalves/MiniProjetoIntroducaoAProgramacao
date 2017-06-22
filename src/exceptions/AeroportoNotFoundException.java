package exceptions;

public class AeroportoNotFoundException extends Exception{
	public AeroportoNotFoundException(){
		super("Aeroporto não encontrado");
	}
}
