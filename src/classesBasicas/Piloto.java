package classesBasicas;
public class Piloto extends Funcionario{
	private Aeroporto localizacao;
	public Piloto(String cpf,String nome,double salario){
		super(cpf,nome,salario);
		this.localizacao=null;
	}
	public Aeroporto getLocalizacao(){
		return this.localizacao;
	}
	public void setLocalizacao(Aeroporto localizacao){
		this.localizacao= localizacao;
	}
}
