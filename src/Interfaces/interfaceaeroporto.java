package Interfaces;
import classes.Aeroporto;
import exceptions.AeroportoNotFoundException;

public interface interfaceaeroporto {
	void inserir(String cidade, String codigo, int capacidade);
	Aeroporto procurar(String cidade) throws AeroportoNotFoundException;
	void atualizar(String codigo, int capacidade) throws AeroportoNotFoundException;
	void remover(String codigo) throws AeroportoNotFoundException;	
}


