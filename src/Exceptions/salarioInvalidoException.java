package exceptions;

public class salarioInvalidoException extends Exception {
	public salarioInvalidoException(){
		super("O salario fornecido n�o � v�lido (menor que zero) ");
	}
}
