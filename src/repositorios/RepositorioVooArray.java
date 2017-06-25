package repositorios;
import classesBasicas.Voo;
import exceptions.*;
import interfaces.*;

public class RepositorioVooArray implements RepositorioVoo{

	private Voo[] voos;
	private int indice;
	private int tamanho;
	
	public RepositorioVooArray(int tam){
		this.voos = new Voo [tam];
		this.tamanho = tam;
		this.indice = 0;
	}
	
	public boolean achou(String num){
		if (arrayLotado()){
			criarNovoArray();
		}
		boolean achou = false;
		for(int i = 0; i < this.indice; i++){
			if (this.voos[i].getNum().equals(num)){
				achou = true;
			}
		}
		return achou;
	}
	
	public boolean arrayLotado(){
		return this.indice == this.tamanho;
	}
	
	public int getTamanho(){
		return voos.length;
	}
	
	public void criarNovoArray(){
		Voo [] aux = new Voo[tamanho * 2];
		for (int i = 0; i < this.tamanho; i++){
			aux[i] = this.voos[i];
		}
		this.voos = aux;
		this.tamanho = this.tamanho * 2;
	}
	
	public void inserir (Voo voo) throws VooJaCadastradoException{
		if (achou(voo.getNum())){
			throw new VooJaCadastradoException();
		}else{
			this.voos[this.indice] = voo;
			indice++;
		}
	}
	
	public Voo procurar (String num) throws VooNaoCadastradoException{
		boolean achou = false;
		Voo voo = null;
		if (achou(num)){
			for (int i = 0; i < this.indice && !achou; i++){
				if (this.voos[i].getNum().equals(num)){
					achou = true;
					voo = voos[i];
				}
			}
		}else{
			throw new VooNaoCadastradoException();
		}
		return voo;
	}
	
	public void atualizar (String num, Voo voo) throws VooNaoCadastradoException{
		if (achou(num)){
			boolean ok = false;
			for (int i = 0; i < this.indice && !ok; i++){
				if (this.voos[i].getNum().equals(num)){
					this.voos[i] = voo;
					ok = true;
				}
			}
		}else{
			throw new VooNaoCadastradoException();
		}
	}
	
	public void remover (String num) throws VooNaoCadastradoException{
		boolean ok = false;
		if (achou(num)){
			for (int i = 0; i < this.indice && !ok; i++){
				if (this.voos[i].getNum().equals(num)){
					this.voos[i] = this.voos[indice];
					this.indice--;
					ok = true;
				}
			}
		}else{
			throw new VooNaoCadastradoException();
		}
	}
	
}
