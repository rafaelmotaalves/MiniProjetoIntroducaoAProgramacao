package cadastros;
import classesBasicas.Voo;
import classesBasicas.Passageiro;
import exceptions.VooJaCadastradoException;
import exceptions.NumVooInvalidoException;
import exceptions.VooNaoCadastradoException;
import exceptions.CapacidadePassageirosInvalidoException;
import interfaces.RepositorioVoo;

public class CadastroVoo {

	private RepositorioVoo voos;
	private int indice;
	
	public CadastroVoo(RepositorioVoo voos){
		this.voos = voos;
		this.indice = 0;
	}
	
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{ //Realiza o cadastro
		 // Para um voo ser valido, o mesmo precisa ter 4 digitos
		if((voo.getNum().length() != 4)){
			throw new NumVooInvalidoException();
		}else{
			voos.inserir(voo);
		}
	}
	
	public void removerVoo(String num) throws VooNaoCadastradoException, NumVooInvalidoException{ //Cancela um voo
		if (voos.procurar(num) instanceof Voo){
			voos.remover(num);
		}else{
			throw new NumVooInvalidoException();
		}
	}
	
	public void atualizarVoo(String num, Voo voo) throws VooNaoCadastradoException, NumVooInvalidoException{ //Atualiza o voo
		// Para um voo ser valido, o mesmo precisa ter 4 digitos
		if((voo.getNum().length() != 4)){ 
			throw new NumVooInvalidoException();
		}else{
			voos.atualizar(num, voo);
		}
	}
	
	public Voo procurarVoo(String num) throws VooNaoCadastradoException, NumVooInvalidoException{ //Procura um voo
		// Para um voo ser valido, o mesmo precisa ter 4 digitos
		if((num.length() != 4)){ 
			throw new NumVooInvalidoException();
		}else{
			return voos.procurar(num);
		}
	}
	
	//Adiciona os passageiros ao aviao
	public void embarcarPassageiro(String num, Passageiro passageiro) throws VooNaoCadastradoException, NumVooInvalidoException, CapacidadePassageirosInvalidoException{ 
		// Obter o array de passageiros do voo atual
		Passageiro arrayPassageiros[] = this.voos.procurar(num).getArrayPassageiros(); 
		// Para um voo ser valido, o mesmo precisa ter 4 digitos
		if((num.length() != 4)){ 
			throw new NumVooInvalidoException();
		}
		else if (this.indice < this.voos.procurar(num).getAviao().getCapacidade()){
			// Caso o avião ainda tenha assentos disponíveis, adicionar um passageiro ao array
			arrayPassageiros[this.indice] = passageiro; 
			this.indice++;
			// Gravar o novo array atualizado de passageiros
			this.voos.procurar(num).setArrayPassageiros(arrayPassageiros); 
		}else{
			throw new CapacidadePassageirosInvalidoException();
		}
	}
}
