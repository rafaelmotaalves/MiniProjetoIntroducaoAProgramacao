package interfaces;
import classesBasicas.Bagagem;
import exceptions.bagagemJaExistenteException;
import exceptions.bagagemNaoExisteException;
import exceptions.bagagemPesoException;

public interface RepositorioBagagem {
	void inserir(Bagagem bagagem) throws bagagemJaExistenteException, bagagemPesoException;
	Bagagem procurar(int cod) throws bagagemNaoExisteException;
	void atualizar(int cod, Bagagem bagagem) throws bagagemNaoExisteException;
	void remover(int cod) throws bagagemNaoExisteException;
	boolean existe (int Cod);
}
