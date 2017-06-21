package Exceptions;

public class salarioInvalidoException extends Exception {
	public salarioInvalidoException(){
		super("O salario fornecido não é válido (menor que zero) ");
	}
}
