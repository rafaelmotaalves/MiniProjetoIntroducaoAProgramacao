package exceptions;


public class AvioesIndisponiveisNoAeroportoException extends Exception{
	public AvioesIndisponiveisNoAeroportoException(){
		super("Esse Aeroporto não contém Aviões");
	}
}
