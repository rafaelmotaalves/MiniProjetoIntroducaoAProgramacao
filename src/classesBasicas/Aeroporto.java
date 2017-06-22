package classesBasicas;

public class Aeroporto {
	private String cidade;
	private int capacidade;
	private String codigo;
	private int distancia;
	private int qntDeAvioesAtual;
	
	public Aeroporto(String cidade, String codigo, int capacidade, int distancia){
		this.cidade = cidade;
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.distancia = distancia;
		this.qntDeAvioesAtual = 0;
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
	
	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public int getQntDeAvioesAtual() {
		return qntDeAvioesAtual;
	}

	public void setQntDeAvioesAtual(int qntDeAvioesAtual) {
		this.qntDeAvioesAtual = qntDeAvioesAtual;
	}
}
