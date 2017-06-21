package Interfaces;
import ClassesBasicas.Voo;
import Exceptions.*;

public interface RepositorioVoo {

	void inserir (Voo voo) throws VooJaCadastradoException;
	Voo procurar (int num) throws VooNaoCadastradoException;
	void atualizar (int num) throws VooNaoCadastradoException;
	void remover (int num) throws VooNaoCadastradoException;
}
