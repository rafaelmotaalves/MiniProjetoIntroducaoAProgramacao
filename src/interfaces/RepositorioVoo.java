package interfaces;
import classesBasicas.Voo;
import exceptions.VooJaCadastradoException;
import exceptions.VooNaoCadastradoException;


public interface RepositorioVoo {

	void inserir (Voo voo) throws VooJaCadastradoException;
	Voo procurar (String num) throws VooNaoCadastradoException;
	void atualizar (String num, Voo voo) throws VooNaoCadastradoException;
	void remover (String num) throws VooNaoCadastradoException;
}
