package cadastros;
import classesBasicas.*;
import exceptions.*;
import interfaces.RepositorioPessoas;
public class CadastroPessoas {
	private RepositorioPessoas pessoas;
	public CadastroPessoas(RepositorioPessoas rep){
		pessoas=rep;
	}
	public void cadastrarPassageiro(Pessoa passageiro) throws cpfJaCadastradoException, cpfInvalidoException, passageiroInvalidoException { // Realiza cadastro
		if(passageiro.getCpf().length()!=14){//testa se o cpf tem o tamanho válido
			throw new cpfInvalidoException();
		}
		if(!(passageiro instanceof Passageiro) ){//testa se a pessoa a ser cadastrada tem os atributos de um passageiro
			throw new passageiroInvalidoException();
		}
		pessoas.inserir(passageiro);
	}
	public void contratarFuncionario(Funcionario funcionario) throws cpfInvalidoException, salarioInvalidoException, cpfJaCadastradoException, funcionarioInvalidoException{
		if(funcionario.getCpf().length()!=14){//testa se o cpf tem o tamanho válido
			throw new cpfInvalidoException();
		}
		if(funcionario.getSalario()<0){//testa se o valor do salário é positivo
			throw new salarioInvalidoException();
		}
		if(!(funcionario instanceof Funcionario)){//testa se a pessoa a ser cadastrada tem os atributos de um funcionario
			throw new funcionarioInvalidoException();
		}
		pessoas.inserir(funcionario);
	}
	public void removerPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro ){
			pessoas.remover(cpf);
		}else{//testa se a pessoa a ser removida é um passageiro
			throw new passageiroInvalidoException();
		}
	}
	public void demitirFuncionario(String cpf) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){
			pessoas.remover(cpf);
		}else{//testa se a pessoa a ser demitida é um funcionario
			throw new funcionarioInvalidoException();
		}
	}
	public void atualizarDadosPassageiro(String cpf,Pessoa passageiro) throws cpfNaoCadastradoException, passageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro && passageiro instanceof Passageiro){//testa se o cpf fornecido é de um passageiro e se os dados a ser atualizados sao atributos de um passageiro
			pessoas.atualizar(cpf, passageiro);
		}else{
			throw new passageiroInvalidoException();
		}
	}
	public void atualizarDadosFuncionairo(String cpf,Pessoa funcionario) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){//testa se o cpf fornecido é de um funcionario e se os dados a ser atualizados sao atributos de um funcionario
			pessoas.atualizar(cpf, funcionario);
		}else{
			throw new funcionarioInvalidoException();
		}
	}
	public void realocarPiloto(String cpf,Aeroporto local) throws cpfNaoCadastradoException, pilotoInvalidoException{
		Pessoa piloto =pessoas.procurar(cpf);
		if(piloto instanceof Piloto){//testa se o dono do cpf fornecido é um piloto;
			((Piloto)pessoas.procurar(piloto.getCpf())).setLocalizacao(local);
		}else{
			throw new pilotoInvalidoException();
		}
}
	public Passageiro BuscarPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			return (Passageiro) aux;
		}else{
			throw new passageiroInvalidoException();
		}
	}
	public void renderMilhas(String cpf,int distancia) throws cpfNaoCadastradoException, passageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			((Passageiro) aux).setMilhas(((Passageiro) aux).getMilhas()+distancia);
		}else{
			throw new passageiroInvalidoException();
		}
	}
	public int getMilhas(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			return ((Passageiro) aux).getMilhas();
		}else{
			throw new passageiroInvalidoException();
		}
	}
}
