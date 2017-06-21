package Exceptions;
public class aviaoInvalidoException extends Exception{
	public aviaoInvalidoException(){
		super("O avião fornecido não é um avião válido");
	}

}
