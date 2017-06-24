package classesBasicas;
public class Voo {

	private String num;
	private String horario;
	private Aeroporto destino;
	private double preco;
	private Piloto piloto;
	private Aviao aviao;
	
	public Voo (String num, String horario, double preco, Piloto piloto, Aviao aviao, Aeroporto destino){
		this.num = num;
		this.horario = horario;
		this.preco = preco;
		this.piloto = piloto;
		this.aviao = aviao;
		this.destino = destino;
	}
	public String getNum(){
		return this.num;
	}
	public void setNum(String num){
		this.num = num;
	}
	public String getHorario(){
		return this.horario;
	}
	public void setHorario(String horario){
		this.horario = horario;
	}
	public double getPreco(){
		return this.preco;
	}
	public void setPreco(double preco){
		this.preco = preco;
	}
	public Piloto getPiloto(){
		return this.piloto;
	}
	public void setPiloto(Piloto piloto){
		this.piloto = piloto;
	}
	public Aviao getAviao(){
		return this.aviao;
	}
	public void setAviao (Aviao aviao){
		this.aviao = aviao;
	}
	public Aeroporto getDestino(){
		return this.destino;
	}
	public void setDestino (Aeroporto destino){
		this.destino = destino;
	}
}
