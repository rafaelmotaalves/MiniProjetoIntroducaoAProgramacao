package Repositorios;

import ClassesBasicas.Pessoa;
import Exceptions.cpfJaCadastradoException;
import Exceptions.cpfNaoCadastradoException;
import Interfaces.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
	private Pessoa[] pessoas;
	private int indice;
	public RepositorioPessoasArray(int tamanho){
		this.pessoas=new Pessoa[tamanho];
		this.indice=0;
	}
	public boolean existe(String cpf){
		boolean existe=false;
		for(int i=0;i<this.indice && !existe;i++){
			if(pessoas[i].getCpf().equals(cpf)){
				existe=true;
			}
		}
		return existe;
	}

	public void inserir(Pessoa pessoa) throws cpfJaCadastradoException {
		if(existe(pessoa.getCpf())){
			throw new cpfJaCadastradoException();
		}else{
			pessoas[this.indice]=pessoa;
			this.indice++;
		}
	}

	public Pessoa procurar(String cpf) throws cpfNaoCadastradoException {
		boolean achei=false;
		Pessoa resultado=null;
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
		}else{
			for(int i=0;i<this.indice && !achei;i++){
				if(this.pessoas[i].getCpf().equals(cpf)){
					achei=true;
					resultado=pessoas[i];
				}
			}
		return resultado;
		}
	}

	public void atualizar(String cpf, Pessoa pessoa) throws cpfNaoCadastradoException {
		boolean achei=false;
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
		}else{
			for(int i=0;i<this.indice && !achei;i++){
				if(this.pessoas[i].getCpf().equals(cpf)){
					this.pessoas[i]=pessoa;
					achei=true;
				}
			}
		}
	}

	public void remover(String cpf) throws cpfNaoCadastradoException {
		boolean achei=false;
		if(!existe(cpf)){
			throw new cpfNaoCadastradoException();
		}else{
			for(int i=0;i<this.indice && !achei;i++){
				if(this.pessoas[i].getCpf().equals(cpf)){
					this.pessoas[i]=this.pessoas[this.indice];
					this.indice--;
				}
			}
		}
	}

}
