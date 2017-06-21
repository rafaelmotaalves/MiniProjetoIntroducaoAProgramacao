package Cadastros;
import ClassesBasicas.Aeroporto;
import Repositorios.RepositorioAeroportoArray;
import Repositorios.RepositorioAeroportoLista;
import Interfaces.RepositorioAeroportos;
import Exceptions.*;

public class CadastroAeroporto {
	private RepositorioAeroportos aeroportos;
	
	public CadastroAeroporto(RepositorioAeroportos repositorio){
		this.aeroportos = repositorio;
	}
	
	public void cadastrar(Aeroporto aeroporto) throws CapacidadeAeroportoInvalidaException, AeroportoJaCadastradoException{
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
	
	public void decola(String codigo) throws AeroportoNotFoundException, AvioesIndisponiveisNoAeroportoException{
		int qntAtual = this.aeroportos.procurar(codigo).getQntDeAvioesAtual();
		int capacidade = this.aeroportos.procurar(codigo).getCapacidade();
		
		if(qntAtual == 0){
			throw new AvioesIndisponiveisNoAeroportoException();
		} else {
			this.aeroportos.procurar(codigo).setQntDeAvioesAtual(qntAtual - 1);
		}
	}
	
	public void pousa(String codigo) throws AeroportoNotFoundException, AeroportoLotadoException{
		int qntAtual = this.aeroportos.procurar(codigo).getQntDeAvioesAtual();
		int capacidade = this.aeroportos.procurar(codigo).getCapacidade();
		
		if(qntAtual == capacidade){
			throw new AeroportoLotadoException();
		} else {
			this.aeroportos.procurar(codigo).setQntDeAvioesAtual(qntAtual + 1);
		}
	}
}
