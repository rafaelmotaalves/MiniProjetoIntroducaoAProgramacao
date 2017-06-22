package interfaces;
import classesBasicas.Aviao;
import exceptions.AviaoJaCadastradoException;
import exceptions.IdNaoCadastradaException;

public interface RepositorioAviao {
	void inserir(Aviao aviao) throws AviaoJaCadastradoException;
	Aviao procurar(int ID) throws IdNaoCadastradaException;
	void atualizar(int ID, Aviao aviao) throws IdNaoCadastradaException;
	void remover (int ID) throws IdNaoCadastradaException;

}
