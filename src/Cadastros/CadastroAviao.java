package Cadastros;
import ClassesBasicas.Aviao;
import Exceptions.*;
import Interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviaos;
	CadastroAviao(RepositorioAviao rep){
		this.aviaos=rep;
	}
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, aviaoInvalidoException{
		if(aviao instanceof Aviao){
			this.aviaos.inserir(aviao);
		}
		else{
			throw new aviaoInvalidoException();
		}
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, aviaoInvalidoException{
		if(aviaos.procurar(ID) instanceof Aviao){
			aviaos.remover(ID);
		}
		else{
			throw new aviaoInvalidoException();
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, aviaoInvalidoException{
		if(this.aviaos.procurar(ID) instanceof Aviao){
			this.aviaos.atualizar(ID, aviao);
		}
		else{
			throw new aviaoInvalidoException();
		}
	}
	



}
