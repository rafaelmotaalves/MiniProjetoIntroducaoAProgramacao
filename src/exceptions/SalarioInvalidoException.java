package exceptions;

public class SalarioInvalidoException extends Exception {
	public SalarioInvalidoException(){
		super("O salario fornecido n�o � v�lido (menor que zero) ");
	}
}
