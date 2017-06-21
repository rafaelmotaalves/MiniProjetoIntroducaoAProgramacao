package Repositorios;
import ClassesBasicas.Aviao;
import Interfaces.RepositorioAviao;
import Exceptions.*;
public class RepositorioAviaoLista implements RepositorioAviao {
	private Aviao aviao;
	private RepositorioAviaoLista proximo;
	public void repositorioAviaoLista(){
		this.aviao=null;
		this.proximo=null;
	}
	public boolean existe(int ID){
		boolean existe=false;
		if(this.aviao!=null){
			if(this.aviao.getID()==ID){
				existe=true;
			}
			else{
				this.proximo.existe(ID);
			}
		}
		return existe;
	}
	public void inserir(Aviao aviao) throws AviaoJaCadastradoException{
		if(existe(aviao.getID())){
			throw new AviaoJaCadastradoException();
		}
		else{
			if(this.aviao==null){
				this.aviao=aviao;
				this.proximo=new RepositorioAviaoLista();
			}
			else{
				this.proximo.inserir(aviao);
			}
		}
	}
	public Aviao procurar(int ID)  throws IdNaoCadastradaException{
		Aviao procurado=null;
		boolean encontrado=false;
		if(!existe(aviao.getID())){
			throw new IdNaoCadastradaException(ID);
		}
		else{
			if(!encontrado && this.aviao!=null)
				if(this.aviao.getID()==ID){
					procurado=this.aviao;
					encontrado=true;
				}
				else{
					this.proximo.procurar(ID);
				}
		}
		return procurado;
	}
	public void atualizar(int ID, Aviao aviao) throws IdNaoCadastradaException{
		boolean atualizado=false;
		if(!existe(ID)){
			throw new IdNaoCadastradaException(ID);
		}
		else{
			if(this.aviao!=null && !atualizado){
				if(this.aviao.getID()==ID){
					this.aviao=aviao;
				}
				else{
					this.proximo.atualizar(ID, aviao);
				}
			}
		}
	}
	public void remover(int ID) throws IdNaoCadastradaException{
		if(!existe(ID)){
			throw new IdNaoCadastradaException(ID);
		}
		else{
			if(this.aviao!=null){
				if(this.aviao.getID()==ID){
					this.aviao=this.proximo.aviao;
					this.proximo=this.proximo.proximo;
				}
				else{
					this.proximo.remover(ID);
				}
			}
		}
	}



}