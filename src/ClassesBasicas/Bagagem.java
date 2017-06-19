package ClassesBasicas;

public class Bagagem {
	
	private int Cod;
	private double peso;
	private Voo voo;
	private Aeroporto aeroporto;
	private Passageiro passageiro;
	
	public Bagagem(int cod, double peso, Voo voo, Aeroporto aeroporto, Passageiro passageiro) {
		Cod = cod;
		this.peso = peso;
		this.voo = voo;
		this.aeroporto = aeroporto;
		this.passageiro = passageiro;
	}
	
	public int getCod() {
		return Cod;
	}
	public void setCod(int cod) {
		Cod = cod;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Aeroporto getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	
	
	
	
	

}
