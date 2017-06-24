package repositorios;
import classesBasicas.*;
import exceptions.*;
import interfaces.RepositorioVoo;

public class RepositorioVooLista implements RepositorioVoo{

	private Voo voo;
	private RepositorioVooLista proximo;
	
	public RepositorioVooLista(){
		this.voo = null;
		this.proximo = null;
	}
	
	public boolean achou (String num){
		boolean achou = false;
		if (this.voo != null){
			if (this.voo.getNum().equals(num)){
				achou = true;
			}else{
				this.proximo.achou(num);
			}
		}else{
			achou = false;
		}
		return achou;
	}
	
	public void inserir(Voo voo) throws VooJaCadastradoException{
		if (achou(voo.getNum())){
			throw new VooJaCadastradoException();
		}else{
			if (this.voo == null){
				this.voo = voo;
				this.proximo = new RepositorioVooLista();
			}else{
				this.proximo.inserir(voo);
			}
		}
	}
	
	public Voo procurar(String num) throws VooNaoCadastradoException{
		Voo voo = null;
		if (achou(num)){
			if (this.voo.getNum().equals(num)){
				voo = this.voo;
			}else{
				this.proximo.procurar(num);
			}
		}else{
			throw new VooNaoCadastradoException();
		}
		return voo;
	}
	
	public void atualizar(String num, Voo voo) throws VooNaoCadastradoException{
		if (achou(num)){
			if (this.voo.getNum().equals(num)){
				this.voo = voo;
			}
		}else{
			throw new VooNaoCadastradoException();
		}
	}
	
	public void remover(String num) throws VooNaoCadastradoException{
		if (achou(num)){
			if (this.voo.getNum().equals(num)){
				this.voo = this.proximo.voo;
				this.proximo = this.proximo.proximo;
			}else{
				this.proximo.remover(num);
			}
		}else{
			throw new VooNaoCadastradoException();
		}
	}
}
