package Cadastros;
import ClassesBasicas.Aviao;
import Exceptions.*;
import Interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviao;
	CadastroAviao(RepositorioAviao rep){
		this.aviao=rep;
	}
	public void cadastrarAviao(Aviao aviao){
		if(aviao instanceof Aviao){
			this.aviao.inserir(aviao);
		}
		else{
			System.out.println("erro");
		}
	}
	public void removerAviao(int ID){
		if(aviao.procurar(ID) instanceof Aviao){
			aviao.remover(ID);
		}
		else{
			System.out.println("erro");
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao){
		if(aviao.procurar(ID) instanceof Aviao){
			aviao.atualizar(ID, aviao);
		}
		else{
			System.out.println("erro");
		}
	}
	



}
