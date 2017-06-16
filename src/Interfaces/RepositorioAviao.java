package Interfaces;
import ClassesBasicas.Aviao;

public interface RepositorioAviao {
	void inserir(Aviao aviao);
	Aviao procurar(int ID);
	void atualizar(int ID, Aviao aviao);
	void remover (int ID);

}
