package repositorios;
import classesBasicas.Voo;
import exceptions.VooJaCadastradoException;
import exceptions.VooNaoCadastradoException;
import interfaces.RepositorioVoo;

public class RepositorioVooArray implements RepositorioVoo{

	private Voo[] voos;
	private int indice;
	private int tamanho;
	
	public RepositorioVooArray(int tam){
		this.voos = new Voo [tam];
		this.tamanho = tam;
		this.indice = 0;
	}
	
	//checa se existe tal voo no repositorio
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
	
	//retorna se o array está lotado ou nao
	public boolean arrayLotado(){
		return this.indice == this.tamanho;
	}
	
	public void criarNovoArray(){
		// Criar um novo array com o dobro do tamanho do anterior caso o mesmo fique lotado
		Voo [] aux = new Voo[tamanho * 2];
		for (int i = 0; i < this.tamanho; i++){
			aux[i] = this.voos[i];
		}
		// O novo array ficara no lugar do anterior
		this.voos = aux;
		this.tamanho = this.tamanho * 2;
	}
	//insere voo no repositorio
	public void inserir (Voo voo) throws VooJaCadastradoException{
		if (achou(voo.getNum())){
			throw new VooJaCadastradoException();
		}else{
			this.voos[this.indice] = voo;
			indice++;
		}
	}
	//procura voo no repositorio
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
	//atualiza voo substituindo por um novo objeto
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
	//remove voo do repositorio 
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
