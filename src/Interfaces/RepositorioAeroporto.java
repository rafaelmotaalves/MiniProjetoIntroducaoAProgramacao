package Interfaces;
import ClassesBasicas.Aeroporto;

public interface RepositorioAeroporto {
	void inserir(String cidade, String codigo, int capacidade);
	Aeroporto procurar(String cidade);
	void atualizar(Aeroporto aeroporto);
	void remover(Aeroporto aeroporto);	
}


