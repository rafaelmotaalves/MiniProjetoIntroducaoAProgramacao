package repositorios;


import classesBasicas.Bagagem;
import classesBasicas.Voo;
import exceptions.BagagemJaExistenteException;
import exceptions.BagagemNaoExisteException;
import exceptions.BagagemPesoException;
import interfaces.RepositorioBagagem;

public class RepositorioBagagemLista implements RepositorioBagagem {
	private Bagagem bagagem;
	private RepositorioBagagemLista proximo;

	public RepositorioBagagemLista() {
		this.bagagem = null;
		this.proximo = null;
	}

	//checa se a bagagem existe na lista
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
	
	//insere bagagem na lista
	public void inserir(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException {
		if (existe(bagagem.getCod())) {
			throw new BagagemJaExistenteException();
		} else if (bagagem.getPeso() <= 0) {
			throw new BagagemPesoException();
		} else {
			if (this.bagagem == null) {
				this.bagagem = bagagem;
				this.proximo = new RepositorioBagagemLista();
			} else {
				this.proximo.inserir(bagagem);
			}
		}
	}
	//procura a bagagem 
	public Bagagem procurar(int cod) throws BagagemNaoExisteException {
		Bagagem b = null;
		if (existe(cod)) {
			if (this.bagagem.getCod() == cod) {
				b = this.bagagem;
			} else {
				this.proximo.procurar(cod);
			}

		} else {
			throw new BagagemNaoExisteException();
		}

		return b;
	}
	//atualiza bagagem substituindo por um novo objeto
	public void atualizar(int cod, Bagagem bagagem) throws BagagemNaoExisteException {
		boolean existe = existe(cod);
		if (existe) {
			if (this.bagagem.getCod() == cod) {
				this.bagagem = bagagem;
			}
		} else {
			throw new BagagemNaoExisteException();
		}
	}
	//remove bagagem através do código
	public void remover(int cod) throws BagagemNaoExisteException {
		boolean existe = existe(cod);
		if (existe) {
			if (this.bagagem.getCod() == cod) {
				this.bagagem = this.proximo.bagagem;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cod);
			}
		} else {
			throw new BagagemNaoExisteException();
		}
	}
	//remove todas as bagagens alocadas em um voo 
	public void remover(Voo voo) throws BagagemNaoExisteException {
		while (this.bagagem != null) {
			if (this.bagagem.getVoo().getNum() == voo.getNum()) {
				int cod = this.bagagem.getCod();
				remover(cod);
			}else{
				remover(this.proximo.bagagem.getVoo());
			}
		}

	}

}
