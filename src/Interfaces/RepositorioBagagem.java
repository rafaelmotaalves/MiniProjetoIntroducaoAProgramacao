package Interfaces;
import ClassesBasicas.Bagagem;

public interface RepositorioBagagem {
	void inserir(Bagagem bagagem);
	Bagagem procurar(int Cod);
	void atualizar(int Cod, Bagagem bagagem);
	void remover(int Cod);
	boolean existe (int Cod);
}
