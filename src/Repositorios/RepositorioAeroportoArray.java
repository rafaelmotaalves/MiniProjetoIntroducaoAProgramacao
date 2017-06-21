package Repositorios;

import Exceptions.AeroportoNotFoundException;
import Interfaces.RepositorioAeroportos;
import ClassesBasicas.Aeroporto;

public class RepositorioAeroportoArray implements RepositorioAeroportos {
	private Aeroporto [] aeroportos;
	private int indice;
	
	public RepositorioAeroportoArray(int tamanho){
		this.aeroportos = new Aeroporto [tamanho];
		indice = 0;
	}
	
	public void inserir(String cidade, String codigo, int capacidade) {
		this.aeroportos [indice] = new Aeroporto(cidade, codigo, capacidade);
		this.indice++;
		if (indice >= this.aeroportos.length){
			Aeroporto [] aeroportoaux = new Aeroporto[2*this.aeroportos.length];
			for(int i = 0; i < this.aeroportos.length; i++){
				aeroportoaux[i] = this.aeroportos[i];
			}
			this.aeroportos = aeroportoaux;			
		}
	}

	public Aeroporto procurar(String codigo) throws AeroportoNotFoundException {
		Aeroporto aeroporto = null;
		boolean achou = false;
		for(int i = 0; (i < this.indice) && !achou; i++){
			if(codigo.equals(aeroportos[i].getCodigo())){
				aeroporto = aeroportos[i];
				achou = true;
			}
		}
		if(aeroporto != null){
			return aeroporto;
		} else {
			throw new AeroportoNotFoundException();
		}
	}

	public void atualizar(String codigo, int capacidade) throws AeroportoNotFoundException {
		Aeroporto aeroporto;
		aeroporto = this.procurar(codigo);
		aeroporto.setCapacidade(capacidade);
	}

	public void remover(String codigo) throws AeroportoNotFoundException {
		int indiceprocurado = this.indice;
		boolean achou = false;
		for(int i = 0; (i < this.indice) && !achou; i++){
			if(codigo.equals(aeroportos[i].getCodigo())){
				indiceprocurado = i;
				achou = true;
			}
		}
		for(int i = indiceprocurado; i < this.indice; i++){
			this.aeroportos[i] = this.aeroportos[i + 1];
		}
		this.indice--;
	}

}
