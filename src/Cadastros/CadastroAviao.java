package Cadastros;
import ClassesBasicas.Aviao;
import Exceptions.*;
import Interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviaos;
	CadastroAviao(RepositorioAviao rep){
		this.aviaos=rep;
	}
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, capacidadePassageirosInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new capacidadePassageirosInvalidoException();
		}
		else{
		aviaos.inserir(aviao);
		}	
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, capacidadePassageirosInvalidoException{
		if(aviaos.procurar(ID).getCapacidade()<=0){
			throw new capacidadePassageirosInvalidoException();
		}
		else{
			aviaos.remover(ID);
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, capacidadePassageirosInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new capacidadePassageirosInvalidoException();
		}
		else{
			aviaos.atualizar(ID, aviao);
		}
	}
	



}
