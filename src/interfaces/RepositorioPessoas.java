package interfaces;
import classesBasicas.Pessoa;
import exceptions.*;

public interface RepositorioPessoas {
	void inserir(Pessoa pessoa) throws cpfJaCadastradoException;
	Pessoa procurar(String cpf) throws cpfNaoCadastradoException;
	void atualizar(String cpf,Pessoa pessoa) throws cpfNaoCadastradoException ;
	void remover(String cpf) throws cpfNaoCadastradoException;
}
