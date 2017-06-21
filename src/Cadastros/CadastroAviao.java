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
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, capacidadeInvalidoException{
		if(aviaos.procurar(ID).getCapacidade()<=0){
			throw new capacidadeInvalidoException();
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, capacidadeInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new capacidadeInvalidoException();
		}
	}
	



}
