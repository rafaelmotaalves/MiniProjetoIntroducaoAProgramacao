package cadastros;
import classesBasicas.*;
import exceptions.*;
import interfaces.RepositorioPessoas;
public class CadastroPessoas {
	private RepositorioPessoas pessoas;
	public CadastroPessoas(RepositorioPessoas rep){
		pessoas=rep;
	}
	public void cadastrarPassageiro(Pessoa passageiro) throws CpfJaCadastradoException, CpfInvalidoException, PassageiroInvalidoException {
		if(passageiro.getCpf().length()!=14){//testa se o cpf tem o tamanho válido
			throw new CpfInvalidoException();
		}
		if(!(passageiro instanceof Passageiro) ){//testa se a pessoa a ser cadastrada tem os atributos de um passageiro
			throw new PassageiroInvalidoException();
		}
		pessoas.inserir(passageiro);
	}
	public void contratarFuncionario(Funcionario funcionario) throws CpfInvalidoException, SalarioInvalidoException, CpfJaCadastradoException, FuncionarioInvalidoException{
		if(funcionario.getCpf().length()!=14){//testa se o cpf tem o tamanho válido
			throw new CpfInvalidoException();
		}
		if(funcionario.getSalario()<0){//testa se o valor do salário é positivo
			throw new SalarioInvalidoException();
		}
		if(!(funcionario instanceof Funcionario)){//testa se a pessoa a ser cadastrada tem os atributos de um funcionario
			throw new FuncionarioInvalidoException();
		}
		pessoas.inserir(funcionario);
	}
	public void removerPassageiro(String cpf) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro ){
			pessoas.remover(cpf);
		}else{//testa se a pessoa a ser removida é um passageiro
			throw new PassageiroInvalidoException();
		}
	}
	public void demitirFuncionario(String cpf) throws CpfNaoCadastradoException, FuncionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){
			pessoas.remover(cpf);
		}else{//testa se a pessoa a ser demitida é um funcionario
			throw new FuncionarioInvalidoException();
		}
	}
	public void atualizarDadosPassageiro(String cpf,Pessoa passageiro) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		if(pessoas.procurar(cpf) instanceof Passageiro && passageiro instanceof Passageiro){//testa se o cpf fornecido é de um passageiro e se os dados a ser atualizados sao atributos de um passageiro
			pessoas.atualizar(cpf, passageiro);
		}else{
			throw new PassageiroInvalidoException();
		}
	}
	public void atualizarDadosFuncionairo(String cpf,Pessoa funcionario) throws CpfNaoCadastradoException, FuncionarioInvalidoException{
		if(pessoas.procurar(cpf) instanceof Funcionario){//testa se o cpf fornecido é de um funcionario e se os dados a ser atualizados sao atributos de um funcionario
			pessoas.atualizar(cpf, funcionario);
		}else{
			throw new FuncionarioInvalidoException();
		}
	}
	public void realocarPiloto(String cpf,Aeroporto local) throws CpfNaoCadastradoException, PilotoInvalidoException{
		Pessoa piloto =pessoas.procurar(cpf);
		if(piloto instanceof Piloto){//testa se o dono do cpf fornecido é um piloto;
			((Piloto)pessoas.procurar(piloto.getCpf())).setLocalizacao(local);
		}else{
			throw new PilotoInvalidoException();
		}
}
	public Passageiro BuscarPassageiro(String cpf) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			return (Passageiro) aux;
		}else{
			throw new PassageiroInvalidoException();
		}
	}
	public void renderMilhas(String cpf,int distancia) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			((Passageiro) aux).setMilhas(((Passageiro) aux).getMilhas()+distancia);
		}else{
			throw new PassageiroInvalidoException();
		}
	}
	public int getMilhas(String cpf) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		Pessoa aux=pessoas.procurar(cpf);
		if(aux instanceof Passageiro){//testa se o dono do cpf fornecido é um passageiro
			return ((Passageiro) aux).getMilhas();
		}else{
			throw new PassageiroInvalidoException();
		}
	}
}
