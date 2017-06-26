package cadastros;
import classesBasicas.Aviao;
import exceptions.AviaoJaCadastradoException;
import exceptions.CapacidadePassageirosInvalidoException;
import exceptions.IdNaoCadastradaException;
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
	public void removerAviao(int id) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{ //Remove um avião
		if(aviaos.procurar(id).getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.remover(id);
		}
	}
	public void atualizarDadosAviao(int id, Aviao aviao) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{ //Atualiza os dados
		if(aviao.getCapacidade()<=0){
			throw new CapacidadePassageirosInvalidoException();
		}
		else{
			aviaos.atualizar(id, aviao);
		}
	}
	
	public Aviao procurarAviao(int id) throws IdNaoCadastradaException{ //Procura um avião
		return this.aviaos.procurar(id);
	}


}
