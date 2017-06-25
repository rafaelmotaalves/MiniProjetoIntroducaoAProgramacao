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
	public boolean existe(int ID){
		if(estaCheio()){
			duplicarTamanho();	
		}
		boolean existe = false;
		for(int c=0; c<this.indice; c++){
			if(aviao[c].getID()==ID){
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
	public Aviao procurar(int ID) throws IdNaoCadastradaException{
		boolean encontrado=false;
		Aviao procurado=null;
		if(existe(ID)){
			for(int c=0; c<this.indice && !encontrado; c++){
				if(this.aviao[c].getID()==ID){
					encontrado=true;
					procurado=aviao[c];
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(ID);
		}
		return procurado;
		
	}
	public void atualizar(int ID, Aviao aviao) throws IdNaoCadastradaException{
		if(existe(ID)){
			boolean atualizado=false;
			for(int c=0; c<this.indice && !atualizado; c++){
				if(this.aviao[c].getID()==ID){
					this.aviao[c]=aviao;
					atualizado=true;
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(ID);
		}
	}
	public void remover(int ID) throws IdNaoCadastradaException{
		boolean removido=false;
		if(existe(ID)){
			for(int c=0; c<indice && !removido; c++){
				if(aviao[c].getID()==ID){
					this.aviao[c]=this.aviao[indice];
					indice--;
					removido=true;
				}
			}
		}
		else{
			throw new IdNaoCadastradaException(ID);
		}
	}
	

}