package classesBasicas;

public class Bagagem {
	
	private int cod;
	private double peso;
	private Voo voo;
	private Aeroporto aeroporto;
	private Passageiro passageiro;
	
	public Bagagem(int cod, double peso, Voo voo, Aeroporto aeroporto, Passageiro passageiro) {
		this.setCod(cod);
		this.setPeso(peso);
		this.setVoo(voo);
		this.setAeroporto(aeroporto);
		this.setPassageiro(passageiro);
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
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
