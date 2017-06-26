package repositorios;

import classesBasicas.Pessoa;
import exceptions.cpfJaCadastradoException;
import exceptions.cpfNaoCadastradoException;
import interfaces.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
	private Pessoa[] pessoas;
	private int indice;
	private int tamanho;
	public RepositorioPessoasArray(int tamanho){
		this.tamanho=tamanho;
		this.pessoas=new Pessoa[tamanho];
		this.indice=0;
	}
	public int getTamanho(){ //descobre o tamanho do repositorio
		return pessoas.length;
	}
	public void duplicarTamanho(){ //duplica o tamanho
		Pessoa[] aux = new Pessoa[tamanho*2];
		for(int i=0;i<this.tamanho;i++){
			aux[i]=this.pessoas[i];
		}
		this.pessoas=aux;
		this.tamanho=this.tamanho*2;
	}
	public boolean estaCheio(){ //verifica se esta cheio
		return this.indice==this.tamanho;
	}
	public boolean existe(String cpf){ //verifica se existe
		if(estaCheio()){
			duplicarTamanho();	
		}
		boolean existe=false;
		for(int i=0;i<this.indice && !existe;i++){
			if(pessoas[i].getCpf().equals(cpf)){
				existe=true;
			}
		}
		return existe;
	}

	public void inserir(Pessoa pessoa) throws cpfJaCadastradoException { //insere uma pessoa
		if(existe(pessoa.getCpf())){
			throw new cpfJaCadastradoException();
		}else{
			pessoas[this.indice]=pessoa;
			this.indice++;
		}
	}

	public Pessoa procurar(String cpf) throws cpfNaoCadastradoException { //procura uma pessoa
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

	public void atualizar(String cpf, Pessoa pessoa) throws cpfNaoCadastradoException { //atualiza a pessoa
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

	public void remover(String cpf) throws cpfNaoCadastradoException { //remove uma pessoa
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
