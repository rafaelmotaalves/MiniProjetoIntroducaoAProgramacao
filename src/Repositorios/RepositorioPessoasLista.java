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
	public void inserir(Pessoa pessoa) throws cpfJaCadastradoException {
		if(existe(pessoa.getCpf())){
			throw new cpfJaCadastradoException();
		}else{
			if(this.pessoa==null){
				this.pessoa=pessoa;
				this.proximo=new RepositorioPessoasLista();
			}else{
				this.proximo.inserir(pessoa);
			}
		}
	}

	public Pessoa procurar(String cpf) throws cpfNaoCadastradoException {
		Pessoa resultado=null;
		boolean achei=false;
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
		}else{
			if(this.pessoa!=null && !achei){
				if(this.pessoa.getCpf().equals(cpf)){
					resultado=pessoa;
					achei=true;
				}else{
					this.proximo.procurar(cpf);
				}
			}
		}
		return resultado;
	}

	public void atualizar(String cpf, Pessoa pessoa) throws cpfNaoCadastradoException {
		boolean achei=false;
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
		}else{
			if(this.pessoa!=null && !achei){
				if(this.pessoa.getCpf().equals(cpf)){
					this.pessoa=pessoa;
				}else{
					this.proximo.atualizar(cpf,pessoa);
				}
			}
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
