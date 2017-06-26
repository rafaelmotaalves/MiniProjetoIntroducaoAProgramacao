package repositorios;
import classesBasicas.Aviao;
import exceptions.*;
import interfaces.RepositorioAviao;
public class RepositorioAviaoArray implements RepositorioAviao {

	private Aviao[] aviao;
	private int indice;
	private int tamanhoArray;
	public RepositorioAviaoArray(int tamanhoArray){
		this.tamanhoArray=tamanhoArray;
		this.aviao=new Aviao[tamanhoArray];
		this.indice=0;
	}

	public boolean existe(int id){
		if(estaCheio()){
			duplicarTamanho();	
		}
		boolean existe = false;
		for(int c=0; c<this.indice; c++){
			if(aviao[c].getID()==id){
				existe=true;
			}
		}
		return existe; 
	}
	public int getTamanho(){
		return aviao.length;
	}
	public void duplicarTamanho(){
		Aviao[] aux = new Aviao[tamanhoArray*2];
		for(int i=0; i<this.tamanhoArray ;i++){
			aux[i]=this.aviao[i];
		}
		this.aviao=aux;
		this.tamanhoArray=this.tamanhoArray*2;
	}
	public boolean estaCheio(){
		return this.indice==this.tamanhoArray;
	}
	public void inserir(Aviao aviao) throws AviaoJaCadastradoException {
		if(existe(aviao.getID())){
			throw new AviaoJaCadastradoException();
		}
		else{
			this.aviao[this.indice]=aviao;
			indice++;
		}
	}
	public Aviao procurar(int id) throws IdNaoCadastradaException{
		boolean encontrado=false;
		Aviao procurado=null;
		if(existe(id)){
			for(int c=0; c<this.indice && !encontrado; c++){
				if(this.aviao[c].getID()==id){
					encontrado=true;
					procurado=aviao[c];
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(id);
		}
		return procurado;
		
	}
	public void atualizar(int id, Aviao aviao) throws IdNaoCadastradaException{
		if(existe(id)){
			boolean atualizado=false;
			for(int c=0; c<this.indice && !atualizado; c++){
				if(this.aviao[c].getID()==id){
					this.aviao[c]=aviao;
					atualizado=true;
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(id);
		}
	}
	public void remover(int id) throws IdNaoCadastradaException{
		boolean removido=false;
		if(existe(id)){
			for(int c=0; c<indice && !removido; c++){
				if(aviao[c].getID()==id){
					this.aviao[c]=this.aviao[indice];
					indice--;
					removido=true;
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(id);
		}
	}
	

}