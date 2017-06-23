package fachada;
import cadastros.*;
import exceptions.*;
import classesBasicas.*;

public class CompanhiaAerea {
	private CadastroAeroporto aeroportos;
	private CadastroAviao avioes;
	private CadastroPessoas pessoas;
	
	public CompanhiaAerea(CadastroAeroporto aeroportos, CadastroAviao avioes, CadastroPessoas pessoas){
		this.aeroportos = aeroportos;
		this.avioes = avioes;
		this.pessoas = pessoas;
	}
	
	public void CadastrarAeroporto(Aeroporto aeroporto) throws CapacidadeAeroportoInvalidaException, AeroportoJaCadastradoException{
		this.aeroportos.cadastrar(aeroporto);
	}
	
	public void CadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, capacidadePassageirosInvalidoException{
		this.avioes.cadastrarAviao(aviao);
	}
	
	public void CadastrarPassageiro(Pessoa passageiro) throws cpfJaCadastradoException, cpfInvalidoException, passageiroInvalidoException{
		this.pessoas.cadastrarPassageiro(passageiro);
	}
	
	public void CadastrarFuncionario(Funcionario funcionario) throws cpfInvalidoException, salarioInvalidoException, cpfJaCadastradoException, funcionarioInvalidoException{
		this.pessoas.contratarFuncionario(funcionario);
	}
	
	
}
