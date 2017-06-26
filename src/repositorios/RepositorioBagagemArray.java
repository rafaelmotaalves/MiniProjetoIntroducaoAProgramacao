package repositorios;

import classesBasicas.*;
import exceptions.BagagemJaExistenteException;
import exceptions.BagagemNaoExisteException;
import exceptions.BagagemPesoException;
import interfaces.RepositorioBagagem;

public class RepositorioBagagemArray implements RepositorioBagagem {
	private Bagagem bagagem[];
	private int index;
	private int tamanho;
	
	public RepositorioBagagemArray() {
		this.tamanho = 1;
		this.bagagem = new Bagagem[tamanho];
		this.index = 0;
	}

	//checa se array está completo, caso positivo, dobra o tamanho
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

	//adiciona bagagens no array
	public void inserir(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException {
		checaTamanho();
		if (existe(bagagem.getCod())) {
			throw new BagagemJaExistenteException();
		} else if (bagagem.getPeso() < 0) {
			throw new BagagemPesoException();
		} else {
			this.bagagem[index] = bagagem;
			index++;
		}

	}
	
	//procura uma bagagem através do código
	public Bagagem procurar(int cod) throws BagagemNaoExisteException {
		Bagagem bagagem = null;
		if (existe(cod)) {
			boolean chave = true;
			for (int i = 0; i < tamanho && chave == true; i++) {
				if (this.bagagem[i].getCod() == cod) {
					bagagem = this.bagagem[i];
					chave = false;
				}
			}
			return bagagem;
		} else {
			throw new BagagemNaoExisteException();
		}
	}

	//atualiza uma bagagem do array substituindo por um novo objeto 
	public void atualizar(int cod, Bagagem bagagem) throws BagagemNaoExisteException {
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
			throw new BagagemNaoExisteException();
		}

	}

	//remove uma bagagem atráves do código
	public void remover(int cod) throws BagagemNaoExisteException {
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
			throw new BagagemNaoExisteException();
		}

	}
	//remove as bagagens relacionadas a um vôo
	public void remover(Voo voo) throws BagagemNaoExisteException {

		for (int i = 0; i <= index-1; i++) {
			if (this.bagagem[i].getVoo().getNum() == voo.getNum()) {
				int cod = this.bagagem[i].getCod();
				this.remover(cod);
			}
		}

	}

	//retorna a existência ou nao da bagagem no array
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
