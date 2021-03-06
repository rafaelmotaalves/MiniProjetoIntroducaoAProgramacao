package repositorios;

import classesBasicas.Pessoa;
import exceptions.CpfJaCadastradoException;
import exceptions.CpfNaoCadastradoException;
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
	public int getTamanho(){
		return pessoas.length;
	}
	public void duplicarTamanho(){
		Pessoa[] aux = new Pessoa[tamanho*2];
		for(int i=0;i<this.tamanho;i++){
			aux[i]=this.pessoas[i];
		}
		this.pessoas=aux;
		this.tamanho=this.tamanho*2;
	}
	public boolean estaCheio(){
		return this.indice==this.tamanho;
	}
	public boolean existe(String cpf){
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

	public void inserir(Pessoa pessoa) throws CpfJaCadastradoException {
		if(existe(pessoa.getCpf())){
			throw new CpfJaCadastradoException();
		}else{
			pessoas[this.indice]=pessoa;
			this.indice++;
		}
	}

	public Pessoa procurar(String cpf) throws CpfNaoCadastradoException {
		boolean achei=false;
		Pessoa resultado=null;
		if(!existe(cpf)){
			throw new CpfNaoCadastradoException();
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

	public void atualizar(String cpf, Pessoa pessoa) throws CpfNaoCadastradoException {
		boolean achei=false;
		if(!existe(cpf)){
			throw new CpfNaoCadastradoException();
		}else{
			for(int i=0;i<this.indice && !achei;i++){
				if(this.pessoas[i].getCpf().equals(cpf)){
					this.pessoas[i]=pessoa;
					achei=true;
				}
			}
		}
	}

	public void remover(String cpf) throws CpfNaoCadastradoException {
		boolean achei=false;
		if(!existe(cpf)){
			throw new CpfNaoCadastradoException();
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
