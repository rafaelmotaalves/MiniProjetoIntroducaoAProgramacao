package interfaces;
import classesBasicas.Aeroporto;
import exceptions.AeroportoNotFoundException;

public interface RepositorioAeroportos {
	void inserir(String cidade, String codigo, int capacidade);
	Aeroporto procurar(String cidade) throws AeroportoNotFoundException;
	void atualizar(String codigo, int capacidade) throws AeroportoNotFoundException;
	void remover(String codigo) throws AeroportoNotFoundException;	
}


