package classesBasicas;

public class Bagagem {
	
	private int Cod;
	private double peso;
	private Voo voo;
	private Aeroporto aeroporto;
	private Passageiro passageiro;
	
	public Bagagem(int cod, double peso, Voo voo, Aeroporto aeroporto, Passageiro passageiro) {
		this.Cod = cod;
		Cod = cod;
		this.peso = peso;
		this.setVoo(voo);
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

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	
	
	
	
	

}
