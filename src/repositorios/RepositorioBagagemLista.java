 

import classesBasicas.*;
import exceptions.bagagemJaExistenteException;
import exceptions.bagagemNaoExisteException;
import exceptions.bagagemPesoException;
import interfaces.RepositorioBagagem;

public class RepositorioBagagemLista implements RepositorioBagagem {
	private Bagagem bagagem;
	private RepositorioBagagemLista proximo;

	public RepositorioBagagemLista() {
		this.bagagem = null;
		this.proximo = null;
	}

	public boolean existe(int cod) {
		boolean existe = false;
		if (this.bagagem != null) {
			if (this.bagagem.getCod() == cod) {
				existe = true;
			} else {
				this.proximo.existe(cod);
			}

		} else {
			existe = false;
		}
		return existe;
	}

	public void inserir(Bagagem bagagem) throws bagagemJaExistenteException, bagagemPesoException {
		if (existe(bagagem.getCod())) {
			throw new bagagemJaExistenteException();
		} else if(bagagem.getPeso() <= 0){
			throw new bagagemPesoException();
			}else {
			if (this.bagagem == null) {
				this.bagagem = bagagem;
				this.proximo = new RepositorioBagagemLista();
			} else {
				this.proximo.inserir(bagagem);
			}
		}
	}

	public Bagagem procurar(int cod) throws bagagemNaoExisteException {
		Bagagem b = null;
		if (existe(cod)) {
			if (this.bagagem.getCod() == cod) {
				b = this.bagagem;
			} else {
				this.proximo.procurar(cod);
			}

		} else {
			throw new bagagemNaoExisteException();
		}

		return b;
	}

	public void atualizar(int cod, Bagagem bagagem) throws bagagemNaoExisteException {
		boolean existe = existe(cod);
		if(existe){
			if(this.bagagem.getCod() == cod){
				this.bagagem = bagagem;
			}
		}else{
			throw new bagagemNaoExisteException(); 
		}
	}

	public void remover(int cod) throws bagagemNaoExisteException {
		boolean existe = existe(cod);
		if(existe){
			if(this.bagagem.getCod() == cod){
				this.bagagem = this.proximo.bagagem;
				this.proximo = this.proximo.proximo;
			}else{
				this.proximo.remover(cod);
			}
		}else{
			throw new bagagemNaoExisteException();
		}
	}

}
