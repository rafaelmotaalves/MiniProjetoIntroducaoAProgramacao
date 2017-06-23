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
	
	public void cadastrarAeroporto(Aeroporto aeroporto) throws CapacidadeAeroportoInvalidaException, AeroportoJaCadastradoException{
		this.aeroportos.cadastrar(aeroporto);
	}
	
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, capacidadePassageirosInvalidoException{
		this.avioes.cadastrarAviao(aviao);
	}
	
	public void cadastrarPassageiro(Pessoa passageiro) throws cpfJaCadastradoException, cpfInvalidoException, passageiroInvalidoException{
		this.pessoas.cadastrarPassageiro(passageiro);
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) throws cpfInvalidoException, salarioInvalidoException, cpfJaCadastradoException, funcionarioInvalidoException{
		this.pessoas.contratarFuncionario(funcionario);
	}
	
	public void atualizarAeroporto(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException, CapacidadeAeroportoInvalidaException{
		this.aeroportos.atualizarCadastroAeroporto(codigo, aeroporto);
	}
	
	public void atualizarAviao(int id, Aviao aviao) throws IdNaoCadastradaException, capacidadePassageirosInvalidoException{
		this.avioes.atualizarDadosAviao(id, aviao);
	}
	
	public void atualizarPassageiro(String cpf, Pessoa passageiro) throws cpfNaoCadastradoException, passageiroInvalidoException{
		this.pessoas.atualizarDadosPassageiro(cpf, passageiro);
	}
	
	public void removerAeroporto(String codigo) throws AeroportoNotFoundException{
		this.aeroportos.removerCadastroAeroporto(codigo);
	}
	
	public void removerAviao(int id) throws IdNaoCadastradaException, capacidadePassageirosInvalidoException{
		this.avioes.removerAviao(id);
	}
	
	public void removerPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		this.pessoas.removerPassageiro(cpf);
	}
	
	public void demitirFuncionario(String cpf) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		this.pessoas.demitirFuncionario(cpf);
	}
	
	//!!!!Metodo nao finalizado!!!!
	public void executarVoo(Voo voo) throws AeroportoNotFoundException, AeroportoLotadoException, cpfNaoCadastradoException, pilotoInvalidoException{
		//this.aeroportos.decola(String codigoAeroportoBase);//necessario criar um aeroporto virtual para ser a base de operaçoes do programa
		this.aeroportos.pousa(voo.getDestino().getCodigo());
		this.pessoas.realocarPiloto(voo.getPiloto(), voo.getDestino());
	}
}
