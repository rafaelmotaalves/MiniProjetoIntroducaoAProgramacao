package exceptions;

public class SalarioInvalidoException extends Exception {
	public SalarioInvalidoException(){
		super("O salario fornecido não é válido (menor que zero) ");
	}
}
