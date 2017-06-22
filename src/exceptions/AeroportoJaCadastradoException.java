package exceptions;

public class AeroportoJaCadastradoException extends Exception{
	public AeroportoJaCadastradoException (){
		super("Aeroporto já cadastrado");
	}
}
