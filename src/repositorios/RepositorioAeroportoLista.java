package repositorios;

import classesBasicas.Aeroporto;
import exceptions.AeroportoNotFoundException;
import exceptions.CpfNaoCadastradoException;
import interfaces.RepositorioAeroportos;

public class RepositorioAeroportoLista implements RepositorioAeroportos {
	private Aeroporto aeroporto;
	private RepositorioAeroportoLista proximo;
	
	public RepositorioAeroportoLista(){
		this.aeroporto = null;
		this.proximo = null;
	}
	
	public void inserir(Aeroporto aeroporto) {
		if(this.aeroporto == null){
			this.aeroporto = aeroporto;
			this.proximo = new RepositorioAeroportoLista();
		} else {
			proximo.inserir(aeroporto);
		}

	}

	public Aeroporto procurar(String cod) throws AeroportoNotFoundException {
		if(this.aeroporto!=null){
			if(this.aeroporto.getCodigo().equals(cod)){
				return this.aeroporto;
			}else{
				return this.proximo.procurar(cod);
			}
		}else{
			throw new AeroportoNotFoundException();
		}
	}


	public void atualizar(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException {
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

	public void remover(String codigo) throws AeroportoNotFoundException {
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
