package Repositorios;

import ClassesBasicas.*;
import Exceptions.bagagemJaExistenteException;
import Exceptions.bagagemNaoExisteException;
import Interfaces.RepositorioBagagem;

public class RepositorioBagagemArray implements RepositorioBagagem {
	private Bagagem bagagem[];
	private int index;
	private int tamanho;

	public RepositorioBagagemArray() {
		this.tamanho = 5;
		this.bagagem = new Bagagem[tamanho];
		this.index = 0;
	}

	public void checaTamanho() {
		if (this.index == tamanho - 1) {
			tamanho *= 2;

			Bagagem aux[] = new Bagagem[tamanho];

			for (int i = 0; i < tamanho / 2; i++) {
				aux[i] = bagagem[i];
			}

			bagagem = aux;
		}

	}

	public void inserir(Bagagem bagagem) throws bagagemJaExistenteException {
		checaTamanho();
		if (existe(bagagem.getCod())) {
			throw new bagagemJaExistenteException();
		} else {
			this.bagagem[index] = bagagem;
			index++;
		}

	}

	public Bagagem procurar(int cod) throws bagagemNaoExisteException{
		Bagagem bagagem = null;
		if (existe(cod)) {
			boolean chave = true;
			int pos = 0;
			for (int i = 0; i < tamanho && chave == true; i++) {
				if (this.bagagem[i].getCod() == cod) {
					bagagem = this.bagagem[i];
					chave = false;
				}
			}
			return bagagem;
		}else{
			throw new bagagemNaoExisteException();
		}
	}

	public void atualizar(int cod, Bagagem bagagem) throws bagagemNaoExisteException {
		boolean chave = existe(cod);
		if (chave == true) {
			boolean chave2 = true;
			for (int i = 0; i < tamanho && chave2 == true; i++) {
				if (this.bagagem[i].getCod() == cod) {
					this.bagagem[i] = bagagem;
					chave2 = false;
				}
			}

		} else {
			throw new bagagemNaoExisteException();
		}

	}

	public void remover(int cod) throws bagagemNaoExisteException {
		boolean chave = existe(cod);
		if (chave == true) {
			boolean chave2 = true;
			for (int i = 0; i < tamanho && chave2 == true; i++) {
				if (this.bagagem[i].getCod() == cod) {
					this.bagagem[i] = bagagem[tamanho - 1];
					index--;
					chave2 = false;
				}
			}

		} else {
			throw new bagagemNaoExisteException();
		}

	}

	public boolean existe(int cod) {
		boolean existe = false;
		for (int i = 0; i < tamanho && existe == false; i++) {
			if (this.bagagem[i].getCod() == cod) {
				existe = true;
				return existe;
			}
		}
		return existe;

	}

}
