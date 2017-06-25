package cadastros;
import classesBasicas.Aviao;
import exceptions.*;
import interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviaos;
	
	public CadastroAviao(RepositorioAviao rep){
		this.aviaos=rep;
	}
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, CapacidadePassageirosInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
		aviaos.inserir(aviao);
		}	
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		if(aviaos.procurar(ID).getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.remover(ID);
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		if(aviao.getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.atualizar(ID, aviao);
		}
	}
	



}
