package cadastros;
import classesBasicas.Voo;
import exceptions.*;
import interfaces.RepositorioVoo;

public class CadastroVoo {

	private RepositorioVoo voos;
	
	public CadastroVoo(RepositorioVoo voos){
		this.voos = voos;
	}
	
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{
		// Para um voo ser v�lido, o mesmo precisa ter 4 n�meros
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
}
