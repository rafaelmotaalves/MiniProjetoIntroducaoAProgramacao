package repositorios;

import classesBasicas.Pessoa;
import exceptions.CpfJaCadastradoException;
import exceptions.CpfNaoCadastradoException;
import interfaces.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {
	private Pessoa pessoa;
	private RepositorioPessoasLista proximo;
	public RepositorioPessoasLista(){
		this.pessoa=null;
		this.proximo=null;
	}
	public boolean existe(String cpf){
		boolean existe=false;
		if(this.pessoa!=null){
			if(this.pessoa.getCpf().equals(cpf)){
				existe=true;
			}else{
				this.proximo.existe(cpf);
			}
		}
		return existe;
	}
	public void inserir(Pessoa entrada) throws CpfJaCadastradoException {
		if(existe(entrada.getCpf())){
			throw new CpfJaCadastradoException();
		}
		else{
			if(this.pessoa==null){
				this.pessoa=entrada;
				this.proximo=new RepositorioPessoasLista();
			}
			else{
				this.proximo.inserir(entrada);
			}
		}
	}

	public Pessoa procurar(String cpf) throws CpfNaoCadastradoException {
		if(this.pessoa!=null){
			if(this.pessoa.getCpf().equals(cpf)){
				return this.pessoa;
			}else{
				return this.proximo.procurar(cpf);
			}
		}else{
			throw new CpfNaoCadastradoException();
		}
	}

	public void atualizar(String cpf, Pessoa pessoa) throws CpfNaoCadastradoException {
		if(!existe(cpf)){
			throw new CpfNaoCadastradoException();
		}else{
			if(this.pessoa!=null){
				if(this.pessoa.getCpf().equals(cpf)){
					this.pessoa=pessoa;
				}else{
					this.proximo.atualizar(cpf,pessoa);
				}
			}
		}
	}

	public void remover(String cpf) throws CpfNaoCadastradoException {
		if(!existe(cpf)){
			throw new CpfNaoCadastradoException();
		}else{
			if(this.pessoa!=null){
				if(this.pessoa.getCpf().equals(cpf)){
					this.pessoa=this.proximo.pessoa;
					this.proximo=this.proximo.proximo;
				}else{
					this.proximo.remover(cpf);
				}
			}
		}
	}

}
