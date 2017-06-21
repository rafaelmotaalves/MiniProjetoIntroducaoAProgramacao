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
	
	public void inserir(Aeroporto aeroporto) {
		this.aeroportos [indice] = aeroporto;
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

	public void atualizar(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException {
		boolean achou = false;
		for(int i = 0; (i < this.indice) && !achou; i++){
			if(codigo.equals(aeroportos[i].getCodigo())){
				aeroportos[i] = aeroporto;
				achou = true;
			}
		}
		if(!achou) {
			throw new AeroportoNotFoundException();
		}
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
