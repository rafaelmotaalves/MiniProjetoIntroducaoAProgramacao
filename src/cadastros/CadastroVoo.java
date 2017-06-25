package cadastros;
import classesBasicas.*;
import exceptions.*;
import interfaces.RepositorioVoo;

public class CadastroVoo {

	private RepositorioVoo voos;
	private int indice;
	
	public CadastroVoo(RepositorioVoo voos){
		this.voos = voos;
		this.indice = 0;
	}
	
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{
		// Para um voo ser válido, o mesmo precisa ter 4 números
		if((voo.getNum().length() != 4)){
			throw new NumVooInvalidoException();
		}else{
			voos.inserir(voo);
		}
	}
	
	public void removerVoo(String num) throws VooNaoCadastradoException, NumVooInvalidoException{
		if (voos.procurar(num) instanceof Voo){
			voos.remover(num);
		}else{
			throw new NumVooInvalidoException();
		}
	}
	
	public void atualizarVoo(String num, Voo voo) throws VooNaoCadastradoException, NumVooInvalidoException{
		if((voo.getNum().length() != 4)){
			throw new NumVooInvalidoException();
		}else{
			voos.atualizar(num, voo);
		}
	}
	
	public Voo procurarVoo(String num) throws VooNaoCadastradoException, NumVooInvalidoException{
		if((num.length() != 4)){
			throw new NumVooInvalidoException();
		}else{
			return voos.procurar(num);
		}
	}
	
	public void embarcarPassageiro(String num, Passageiro passageiro) throws VooNaoCadastradoException, NumVooInvalidoException, capacidadePassageirosInvalidoException{
		Passageiro arrayPassageiros[] = this.voos.procurar(num).getArrayPassageiros();
		if((num.length() != 4)){
			throw new NumVooInvalidoException();
		}
		else if (this.indice < this.voos.procurar(num).getAviao().getCapacidade()){
			arrayPassageiros[this.indice] = passageiro;
			this.indice++;
			this.voos.procurar(num).setArrayPassageiros(arrayPassageiros);
		}else{
			throw new capacidadePassageirosInvalidoException();
		}
	}
}
