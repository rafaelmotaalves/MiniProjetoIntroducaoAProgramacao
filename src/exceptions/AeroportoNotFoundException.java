package exceptions;

public class AeroportoNotFoundException extends Exception{
	public AeroportoNotFoundException(){
		super("Aeroporto n�o encontrado");
	}
}
