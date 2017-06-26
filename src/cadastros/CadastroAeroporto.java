package cadastros;
import classesBasicas.Aeroporto;
import exceptions.CapacidadeAeroportoInvalidaException;
import exceptions.AeroportoJaCadastradoException;
import exceptions.AeroportoNotFoundException;
import exceptions.AeroportoLotadoException;
import exceptions.AvioesIndisponiveisNoAeroportoException;
import interfaces.RepositorioAeroportos;

public class CadastroAeroporto {
	private RepositorioAeroportos aeroportos;
	
	public CadastroAeroporto(RepositorioAeroportos repositorio){
		this.aeroportos = repositorio;
	}
	
	public void cadastrar(Aeroporto aeroporto) throws CapacidadeAeroportoInvalidaException, AeroportoJaCadastradoException{ //Realiza o cadastro
		boolean podecadastrar = false;
		
		try{
			this.aeroportos.procurar(aeroporto.getCodigo());
		} catch (AeroportoNotFoundException erro) {
			podecadastrar = true;
			if(aeroporto.getCapacidade() <= 0) {
				throw new CapacidadeAeroportoInvalidaException();
			} else {
				aeroportos.inserir(aeroporto);
			}
		} finally {
			if(!podecadastrar){
				throw new AeroportoJaCadastradoException();
			}
		}
	}
	
	public void atualizarCadastroAeroporto(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException, CapacidadeAeroportoInvalidaException{ //Atualiza cadastro
		if(aeroporto.getCapacidade() <= 0) {
			throw new CapacidadeAeroportoInvalidaException();
		} else {
			this.aeroportos.atualizar(codigo, aeroporto);
		}
	}
	
	public void removerCadastroAeroporto(String codigo) throws AeroportoNotFoundException{ //Remove um cadastro
		this.aeroportos.remover(codigo);
	}
	
	public void decola(String codigo) throws AeroportoNotFoundException, AvioesIndisponiveisNoAeroportoException{ //Retira um aviao do aeroporto
		int qntAtual = this.aeroportos.procurar(codigo).getQntDeAvioesAtual();
		if(qntAtual == 0){
			throw new AvioesIndisponiveisNoAeroportoException();
		} else {
			this.aeroportos.procurar(codigo).setQntDeAvioesAtual(qntAtual - 1);
		}
	}
	
	public void pousa(String codigo) throws AeroportoNotFoundException, AeroportoLotadoException{ //Adiciona um aviao ao aeroporto
		int qntAtual = this.aeroportos.procurar(codigo).getQntDeAvioesAtual();
		int capacidade = this.aeroportos.procurar(codigo).getCapacidade();
		
		if(qntAtual == capacidade){
			throw new AeroportoLotadoException();
		} else {
			this.aeroportos.procurar(codigo).setQntDeAvioesAtual(qntAtual + 1);
		}
	}
	
	public Aeroporto procurar(String codigo) throws AeroportoNotFoundException{ //procura um aeroporto
		return this.aeroportos.procurar(codigo);
	}
}
