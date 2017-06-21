package Interfaces;
import ClassesBasicas.Aviao;
import Exceptions.AviaoJaCadastradoException;
import Exceptions.IdNaoCadastradaException;

public interface RepositorioAviao {
	void inserir(Aviao aviao) throws AviaoJaCadastradoException;
	Aviao procurar(int ID) throws IdNaoCadastradaException;
	void atualizar(int ID, Aviao aviao) throws IdNaoCadastradaException;
	void remover (int ID) throws IdNaoCadastradaException;

}
