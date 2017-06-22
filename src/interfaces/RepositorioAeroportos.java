package interfaces;
import classesBasicas.Aeroporto;
import exceptions.AeroportoNotFoundException;

public interface RepositorioAeroportos {
	void inserir(Aeroporto aeroporto);
	Aeroporto procurar(String codigo) throws AeroportoNotFoundException;
	void atualizar(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException;
	void remover(String codigo) throws AeroportoNotFoundException;	
}


