package classesBasicas;
public class Voo {

	private int num;
	private String horario, destino;
	private double preco;
	private Piloto piloto;
	private Aviao aviao;
	
	public Voo (int num, String horario, double preco, Piloto piloto, Aviao aviao, String destino){
		this.num = num;
		this.horario = horario;
		this.preco = preco;
		this.piloto = piloto;
		this.aviao = aviao;
		this.destino = destino;
	}
	public int getNum(){
		return this.num;
	}
	public void setNum(int num){
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
	public String getDestino(){
		return this.destino;
	}
	public void setDestino (String destino){
		this.destino = destino;
	}
}
