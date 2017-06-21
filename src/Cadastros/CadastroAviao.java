package Cadastros;
import ClassesBasicas.Aviao;
import Exceptions.*;
import Interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviaos;
	CadastroAviao(RepositorioAviao rep){
		this.aviaos=rep;
	}
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, capacidadeInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new capacidadeInvalidoException();
		}
		else{
		aviaos.inserir(aviao);
		}	
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, capacidadeInvalidoException{
		if(aviaos.procurar(ID).getCapacidade()<=0){
			throw new capacidadeInvalidoException();
		}
		else{
			aviaos.remover(ID);
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, capacidadeInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new capacidadeInvalidoException();
		}
		else{
			aviaos.atualizar(ID, aviao);
		}
	}
	



}
