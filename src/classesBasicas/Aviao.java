package classesBasicas;

public class Aviao {
		private int id;
		private String modelo;
		private int capacidade;
		private boolean manutencao;
		private Aeroporto aeroporto;
		public  Aviao(int id, String modelo, int capacidade, Aeroporto aeroporto){
			this.setID(id);
			this.setModelo(modelo);
			this.setCapacidade(capacidade);
			this.setManutencao(false);
			this.setAeroporto(aeroporto);
		}
		public int getID() {
			return id;
		}
		public void setID(int id) {
			id = id;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public int getCapacidade() {
			return capacidade;
		}
		public void setCapacidade(int capacidade) {
			this.capacidade = capacidade;
		}
		public boolean isManutencao() {
			return manutencao;
		}
		public void setManutencao(boolean manutencao) {
			this.manutencao = manutencao;
		}
		public Aeroporto getAeroporto() {
			return aeroporto;
		}
		public void setAeroporto(Aeroporto aeroporto) {
			this.aeroporto = aeroporto;
		}

	}

