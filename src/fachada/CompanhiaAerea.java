package fachada;
import cadastros.*;
import exceptions.*;
import classesBasicas.*;

public class CompanhiaAerea {
	private CadastroAeroporto aeroportos;
	private CadastroAviao avioes;
	private CadastroPessoas pessoas;
	private CadastroBagagem bagagens;
	private CadastroVoo voos;
	
	public CompanhiaAerea(CadastroAeroporto aeroportos, CadastroAviao avioes, CadastroPessoas pessoas, CadastroBagagem bagagens, CadastroVoo voos){
		this.aeroportos = aeroportos;
		this.avioes = avioes;
		this.pessoas = pessoas;
		this.bagagens = bagagens;
		this.voos = voos;
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
	
	public void cadastrarBagagem(Bagagem bagagem) throws bagagemJaExistenteException, bagagemPesoException{
		this.bagagens.cadastrarBagagem(bagagem);
	}
	
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{
		this.voos.cadastrarVoo(voo);
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
	
	public void atualizarBagagem(int codigo, Bagagem bagagem) throws bagagemNaoExisteException, bagagemJaExistenteException, bagagemPesoException{
		this.bagagens.estornarBagagem(codigo);
		this.bagagens.cadastrarBagagem(bagagem);
	}
	
	public void atualizarVoo(String numero, Voo voo) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.atualizarVoo(numero, voo);
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
	
	public void estornarBagagem(int codigo) throws bagagemNaoExisteException{
		this.bagagens.estornarBagagem(codigo);
	}
	
	public void removerVoo(String numero) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.removerVoo(numero);
	}
	
	public void embarcarPassageiro(String numeroVoo, String cpfPassageiro) throws VooNaoCadastradoException, NumVooInvalidoException, capacidadePassageirosInvalidoException{
		this.voos.embarcarPassageiro(numeroVoo, pessoas.BuscarPassageiro(cpfPassageiro));
	}
	
	//!!!!Metodo nao finalizado!!!!
	public void executarVoo(String numero) throws AeroportoNotFoundException, AeroportoLotadoException, cpfNaoCadastradoException, pilotoInvalidoException, IdNaoCadastradaException, capacidadePassageirosInvalidoException, VooNaoCadastradoException, NumVooInvalidoException{
		String codigoAeroportoBase = "REC";
		this.aeroportos.decola(codigoAeroportoBase);//Aeroporto base de operaçoes do programa
		this.aeroportos.pousa(voos.procurarVoo(numero).getDestino().getCodigo());
		this.pessoas.realocarPiloto(voos.procurarVoo(numero).getPiloto(), voos.procurarVoo(numero).getDestino());
		Aviao aviaoAtualizado = new Aviao(voos.procurarVoo(numero).getAviao().getID(), voos.procurarVoo(numero).getAviao().getModelo(),voos.procurarVoo(numero).getAviao().getCapacidade(), voos.procurarVoo(numero).getDestino());
		this.avioes.atualizarDadosAviao(voos.procurarVoo(numero).getAviao().getID(), aviaoAtualizado);
		this.voos.removerVoo(voos.procurarVoo(numero).getNum());
	}
}
