package repositorios;
import classesBasicas.Aviao;
import exceptions.AviaoJaCadastradoException;
import exceptions.IdNaoCadastradaException;
import interfaces.RepositorioAviao;
public class RepositorioAviaoLista implements RepositorioAviao {
	private Aviao aviao;
	private RepositorioAviaoLista proximo;
	public void repositorioAviaoLista(){
		this.aviao=null;
		this.proximo=null;
	}
	public boolean existe(int id){ //checa se o avião existe
		boolean existe=false;
		if(this.aviao!=null){
			if(this.aviao.getID()==id){
				existe=true;
			}
			else{
				this.proximo.existe(id);
			}
		}
		return existe;
	}
	public void inserir(Aviao aviao) throws AviaoJaCadastradoException{ //insere novos aviões a lista
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
	public Aviao procurar(int id)  throws IdNaoCadastradaException{ //procura aviões na lista
		Aviao procurado=null;
		boolean encontrado=false;
		if(!existe(id)){
			throw new IdNaoCadastradaException(id);
		}
		else{
			if(!encontrado && this.aviao!=null)
				if(this.aviao.getID()==id){
					procurado=this.aviao;
					encontrado=true;
				}
				else{
					this.proximo.procurar(id);
				}
		}
		return procurado;
	}
	public void atualizar(int id, Aviao aviao) throws IdNaoCadastradaException{ //atualiza informações do avião
		boolean atualizado=false;
		if(!existe(id)){
			throw new IdNaoCadastradaException(id);
		}
		else{
			if(this.aviao!=null && !atualizado){
				if(this.aviao.getID()==id){
					this.aviao=aviao;
				}
				else{
					this.proximo.atualizar(id, aviao);
				}
			}
		}
	}
	public void remover(int id) throws IdNaoCadastradaException{ //remove um avião da lista
		if(!existe(id)){
			throw new IdNaoCadastradaException(id);
		}
		else{
			if(this.aviao!=null){
				if(this.aviao.getID()==id){
					this.aviao=this.proximo.aviao;
					this.proximo=this.proximo.proximo;
				}
				else{
					this.proximo.remover(id);
				}
			}
		}
	}



}
