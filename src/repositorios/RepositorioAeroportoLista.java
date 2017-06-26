package repositorios;

import classesBasicas.Aeroporto;
import exceptions.AeroportoNotFoundException;
import interfaces.RepositorioAeroportos;

public class RepositorioAeroportoLista implements RepositorioAeroportos {
	private Aeroporto aeroporto;
	private RepositorioAeroportoLista proximo;
	
	public RepositorioAeroportoLista(){
		this.aeroporto = null;
		this.proximo = null;
	}
	
	public void inserir(Aeroporto aeroporto) { //insere um aeroporto ao repositorio
		if(this.aeroporto == null){
			this.aeroporto = aeroporto;
			this.proximo = new RepositorioAeroportoLista();
		} else {
			proximo.inserir(aeroporto);
		}

	}

	public Aeroporto procurar(String codigo) throws AeroportoNotFoundException { //procura um aeroporto
		Aeroporto aeroporto = null;
		boolean achou = false;
		
		if(this.aeroporto != null && !achou){
			if(this.aeroporto.getCodigo().equals(codigo)){
				aeroporto = this.aeroporto;
				achou = true;
			} else {
				this.proximo.procurar(codigo);
			}
		} else {
			throw new AeroportoNotFoundException();
		}
		return aeroporto;
	}

	public void atualizar(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException { //atualiza um aeroporto
		boolean achou = false;
		
		if(this.aeroporto != null && !achou){
			if(this.aeroporto.getCodigo().equals(codigo)){
				this.aeroporto = aeroporto;
				achou = true;
			} else {
				this.proximo.atualizar(codigo, aeroporto);
			}
		} else {
			throw new AeroportoNotFoundException();
		}

	}

	public void remover(String codigo) throws AeroportoNotFoundException { //remove um aeroporto
		boolean achou = false;
		
		if(this.aeroporto != null && !achou){
			if(this.aeroporto.getCodigo().equals(codigo)){
				this.aeroporto = this.proximo.aeroporto;
				this.proximo = this.proximo.proximo;
				achou = true;
			} else {
				this.proximo.atualizar(codigo, aeroporto);
			}
		} else {
			throw new AeroportoNotFoundException();
		}

	}

}
