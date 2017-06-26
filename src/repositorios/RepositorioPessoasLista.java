package repositorios;

import classesBasicas.Pessoa;
import exceptions.cpfJaCadastradoException;
import exceptions.cpfNaoCadastradoException;
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
	public void inserir(Pessoa entrada) throws cpfJaCadastradoException {
		if(existe(entrada.getCpf())){
			throw new cpfJaCadastradoException();
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
		Pessoa pessoa=null;
		if(this.pessoa!=null){
			if(this.pessoa.getCpf().equals(cpf)){
				pessoa =  this.pessoa;
			}else{
				pessoa =  this.proximo.procurar(cpf);
			}
		}
		if(pessoa==null){
			throw new CpfNaoCadastradoException();
		}else{
			return pessoa;
		}
	}

	public void atualizar(String cpf, Pessoa pessoa) throws CpfNaoCadastradoException {
		if(this.pessoa!=null){
			if(this.pessoa.getCpf().equals(cpf)){
				this.pessoa=pessoa;
			}else{
				this.proximo.procurar(cpf);
			}
		}else{
			throw new CpfNaoCadastradoException();
		}
	}

	public void remover(String cpf) throws cpfNaoCadastradoException {
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
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
