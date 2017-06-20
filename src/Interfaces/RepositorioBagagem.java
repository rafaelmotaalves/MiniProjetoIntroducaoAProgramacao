package interfaces;
import classesBasicas.Bagagem;

public interface RepositorioBagagem {
	void inserir(Bagagem bagagem);
	Bagagem procurar(int Cod);
	void atualizar(int Cod, Bagagem bagagem);
	void remover(int Cod);
	boolean existe (int Cod);
}
