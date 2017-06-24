

import classesBasicas.*;
import repositorios.*;
import exceptions.*;
import interfaces.RepositorioBagagem;

public class CadastroBagagem {

	private RepositorioBagagem bagagens;

	public CadastroBagagem(RepositorioBagagem bagagem) {
		this.bagagens = bagagem;
	}

	public void cadastrarBagagem(Bagagem bagagem) throws bagagemJaExistenteException, bagagemPesoException {
		boolean cadastre = false;
		try {
			this.bagagens.procurar(bagagem.getCod());
		} catch (bagagemNaoExisteException erro) {
			cadastre = true;
			bagagens.inserir(bagagem);
		} 
		finally {
			if (!cadastre) {
				throw new bagagemJaExistenteException();
			}
		}
	}

	public void estornarBagagem(int cod) throws bagagemNaoExisteException {
		boolean estorne = false;
		try {

			this.bagagens.remover(cod);

		} catch (bagagemNaoExisteException erro) {
			estorne = true;

		} finally {
			if (estorne) {
				throw new bagagemNaoExisteException();
			}
		}

	}

	

	public double ExcessoBagagem(Bagagem bagagem, double taxa) {
		double excesso = 0;
		double peso = bagagem.getPeso();
		if(peso > 23){
			excesso = peso - 23;
		}
		excesso *= taxa;
		return excesso;
	}

}
