package classesBasicas;

public class Aeroporto {
	private String cidade;
	private int capacidade;
	private String codigo;
	
	public Aeroporto(String cidade, String codigo, int capacidade){
		this.cidade = cidade;
		this.codigo = codigo;
		this.capacidade = capacidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
