
import classesBasicas.Bagagem;
import classesBasicas.Voo;
import exceptions.BagagemJaExistenteException;
import exceptions.BagagemNaoExisteException;
import exceptions.BagagemPesoException;

public interface RepositorioBagagem {
	void inserir(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException;
	Bagagem procurar(int cod) throws BagagemNaoExisteException;
	void atualizar(int cod, Bagagem bagagem) throws BagagemNaoExisteException;
	void remover(int cod) throws BagagemNaoExisteException;
	boolean existe (int Cod);
	void remover(Voo voo) throws BagagemNaoExisteException;
}
