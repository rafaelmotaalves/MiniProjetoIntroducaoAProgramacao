package Interfaces;
import ClassesBasicas.Bagagem;
import Exceptions.bagagemJaExistenteException;
import Exceptions.bagagemNaoExisteException;

public interface RepositorioBagagem {
	void inserir(Bagagem bagagem) throws bagagemJaExistenteException;
	Bagagem procurar(int cod) throws bagagemNaoExisteException;
	void atualizar(int cod, Bagagem bagagem) throws bagagemNaoExisteException;
	void remover(int cod) throws bagagemNaoExisteException;
	boolean existe (int Cod);
}
