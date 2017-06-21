package Cadastros;
import ClassesBasicas.*;
import Exceptions.*;
import Interfaces.RepositorioPessoas;
import Repositorios.*;
public class CadastroPessoas {
	private RepositorioPessoas pessoas;
	CadastroPessoas(RepositorioPessoas rep){
		pessoas=rep;
	}
	public void cadastrarPassageiro(Pessoa passageiro) throws cpfJaCadastradoException, cpfInvalidoException, passageiroInvalidoException {
		if(passageiro.getCpf().length()!=14){
			throw new cpfInvalidoException();
		}
		if(!(passageiro instanceof Passageiro) ){
			throw new passageiroInvalidoException();
		}
		pessoas.inserir(passageiro);
	}
	public void contratarFuncionario(Funcionario funcionario) throws cpfInvalidoException, salarioInvalidoException, cpfJaCadastradoException, funcionarioInvalidoException{
		if(funcionario.getCpf().length()!=14){
			throw new cpfInvalidoException();
		}
		if(funcionario.getSalario()<0){
			throw new salarioInvalidoException();
		}
		if(!(funcionario instanceof Funcionario)){
			throw new funcionarioInvalidoException();
		}
		pessoas.inserir(funcionario);
	}
	public void removerPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro ){
			pessoas.remover(cpf);
		}else{
			throw new passageiroInvalidoException();
		}
	}
	public void demitirFuncionario(String cpf) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){
			pessoas.remover(cpf);
		}else{
			throw new funcionarioInvalidoException();
		}
	}
	public void atualizarDadosPassageiro(String cpf,Pessoa passageiro) throws cpfNaoCadastradoException, passageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro){
			pessoas.atualizar(cpf, passageiro);
		}else{
			throw new passageiroInvalidoException();
		}
	}
	public void atualizarDadosFuncionairo(String cpf,Pessoa funcionario) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){
			pessoas.atualizar(cpf, funcionario);
		}else{
			throw new funcionarioInvalidoException();
		}
	}
	public void realocarPiloto(Piloto piloto,Aeroporto local) throws cpfNaoCadastradoException, pilotoInvalidoException{
		if(piloto instanceof Piloto){
		((Piloto)pessoas.procurar(piloto.getCpf())).setLocalizacao(local);
		}else{
			throw new pilotoInvalidoException();
		}
}
}
