package Interfaces;
import ClassesBasicas.Aeroporto;
import Exceptions.AeroportoNotFoundException;

public interface RepositorioAeroportos {
	void inserir(Aeroporto aeroporto);
	Aeroporto procurar(String codigo) throws AeroportoNotFoundException;
	void atualizar(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException;
	void remover(String codigo) throws AeroportoNotFoundException;	
}


