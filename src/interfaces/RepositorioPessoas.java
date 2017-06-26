package interfaces;
import classesBasicas.Pessoa;
import exceptions.*;

public interface RepositorioPessoas {
	void inserir(Pessoa pessoa) throws CpfJaCadastradoException;
	Pessoa procurar(String cpf) throws CpfNaoCadastradoException;
	void atualizar(String cpf,Pessoa pessoa) throws CpfNaoCadastradoException ;
	void remover(String cpf) throws CpfNaoCadastradoException;
}
