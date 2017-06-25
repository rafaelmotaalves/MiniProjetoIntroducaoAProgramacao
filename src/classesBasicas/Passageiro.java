package classesBasicas;

public class Passageiro extends Pessoa {
	private int milhas;
	public Passageiro(String cpf,String nome){
		super(cpf, nome);
		this.milhas=0;
	}
	public int getMilhas(){
		return this.milhas;
	}
	public void setMilhas(int milhas){
		this.milhas=milhas;
	}
}
