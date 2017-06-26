package cadastros;
import classesBasicas.Aviao;
import exceptions.*;
import interfaces.RepositorioAviao;
public class CadastroAviao {
	private RepositorioAviao aviaos;
	
	public CadastroAviao(RepositorioAviao rep){
		this.aviaos=rep;
	}
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, CapacidadePassageirosInvalidoException{ //Realiza o cadastro
		if(aviao.getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
		aviaos.inserir(aviao);
		}	
	}
	public void removerAviao(int ID) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{ //Remove um avião
		if(aviaos.procurar(ID).getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.remover(ID);
		}
	}
	public void atualizarDadosAviao(int ID, Aviao aviao) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{ //Atualiza os dados
		if(aviao.getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.atualizar(ID, aviao);
		}
	}
	
	public Aviao procurarAviao(int ID) throws IdNaoCadastradaException{ //Procura um avião
		return this.aviaos.procurar(ID);
	}


}
