package cadastros;

import classesBasicas.*;
import repositorios.*;
import exceptions.*;
import interfaces.RepositorioBagagem;

public class CadastroBagagem {

	private RepositorioBagagem bagagens;

	public CadastroBagagem(RepositorioBagagem bagagem) {
		this.bagagens = bagagem;
	}
	//adiciona a bagagem no repositório 
	public void cadastrarBagagem(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException {
		boolean cadastre = false;
		try {
			this.bagagens.procurar(bagagem.getCod());
		} catch (BagagemNaoExisteException erro) {
			cadastre = true;
			bagagens.inserir(bagagem);
		} 
		finally {
			if (!cadastre) {
				throw new BagagemJaExistenteException();
			}
		}
	}
	//retira a bagagem do repositório 
	public void estornarBagagem(int cod) throws BagagemNaoExisteException {
		boolean estorne = false;
		try {

			this.bagagens.remover(cod);

		} catch (BagagemNaoExisteException erro) {
			estorne = true;

		} finally {
			if (estorne) {
				throw new BagagemNaoExisteException();
			}
		}

	}

	
	//calcula e retorna valor do exceço de bagagem caso a bagagem ultrapasse 23 kg
	public double ExcessoBagagem(Bagagem bagagem, double taxa) {
		double excesso = 0;
		double peso = bagagem.getPeso();
		if(peso > 23){
			excesso = peso - 23;
		}
		excesso *= taxa;
		return excesso;
	}
	
	public void retirarBagagens(Voo voo) throws naoHaBagagensException, BagagemNaoExisteException {
		this.bagagens.remover(voo);
		
	}
}

