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
	
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, CapacidadePassageirosInvalidoException{
		this.avioes.cadastrarAviao(aviao);
	}
	
	public void cadastrarPassageiro(Pessoa passageiro) throws CpfJaCadastradoException, CpfInvalidoException, PassageiroInvalidoException{
		this.pessoas.cadastrarPassageiro(passageiro);
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) throws CpfInvalidoException, SalarioInvalidoException, CpfJaCadastradoException, FuncionarioInvalidoException{
		this.pessoas.contratarFuncionario(funcionario);
	}
	
	public void cadastrarBagagem(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException{
		this.bagagens.cadastrarBagagem(bagagem);
	}
	
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{
		this.voos.cadastrarVoo(voo);
	}
	
	public void atualizarAeroporto(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException, CapacidadeAeroportoInvalidaException{
		this.aeroportos.atualizarCadastroAeroporto(codigo, aeroporto);
	}
	
	public void atualizarAviao(int id, Aviao aviao) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		this.avioes.atualizarDadosAviao(id, aviao);
	}
	
	public void atualizarPassageiro(String cpf, Pessoa passageiro) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		this.pessoas.atualizarDadosPassageiro(cpf, passageiro);
	}
	
	public void atualizarBagagem(int codigo, Bagagem bagagem) throws BagagemNaoExisteException, BagagemJaExistenteException, BagagemPesoException{
		this.bagagens.estornarBagagem(codigo);
		this.bagagens.cadastrarBagagem(bagagem);
	}
	
	public void atualizarVoo(String numero, Voo voo) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.atualizarVoo(numero, voo);
	}
	
	public void removerAeroporto(String codigo) throws AeroportoNotFoundException{
		this.aeroportos.removerCadastroAeroporto(codigo);
	}
	
	public void removerAviao(int id) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		this.avioes.removerAviao(id);
	}
	
	public void removerPassageiro(String cpf) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		this.pessoas.removerPassageiro(cpf);
	}
	
	public void demitirFuncionario(String cpf) throws CpfNaoCadastradoException, FuncionarioInvalidoException{
		this.pessoas.demitirFuncionario(cpf);
	}
	
	public void estornarBagagem(int codigo) throws BagagemNaoExisteException{
		this.bagagens.estornarBagagem(codigo);
	}
	
	public void removerVoo(String numero) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.removerVoo(numero);
	}
	
	public Aeroporto procurarAeroporto(String codigo) throws AeroportoNotFoundException{
		return this.aeroportos.procurar(codigo);
	}
	
	public Aviao procurarAviao(int ID) throws IdNaoCadastradaException{
		return this.avioes.procurarAviao(ID);
	}
	
	public Passageiro procurarPassageiro(String cpf) throws CpfNaoCadastradoException, PassageiroInvalidoException{
		return this.pessoas.BuscarPassageiro(cpf);
	}
	
	public Voo procurarVoo(String numero) throws VooNaoCadastradoException, NumVooInvalidoException{
		return this.voos.procurarVoo(numero);
	}
	
	public void realocarPiloto(String cpf, Aeroporto local) throws CpfNaoCadastradoException, PilotoInvalidoException{
		this.pessoas.realocarPiloto(cpf, local);
	}
	
	public void realocarAviao(String codigoAeroporto) throws AeroportoNotFoundException, AeroportoLotadoException{
		this.aeroportos.pousa(codigoAeroporto);
	}
	
	public void embarcarPassageiro(String numeroVoo, String cpfPassageiro) throws VooNaoCadastradoException, NumVooInvalidoException, CapacidadePassageirosInvalidoException, CpfNaoCadastradoException, PassageiroInvalidoException{
		this.voos.embarcarPassageiro(numeroVoo, pessoas.BuscarPassageiro(cpfPassageiro));
	}
	
	public void executarVoo(String numero) throws AeroportoNotFoundException, AeroportoLotadoException, CpfNaoCadastradoException, PilotoInvalidoException, IdNaoCadastradaException, CapacidadePassageirosInvalidoException, VooNaoCadastradoException, NumVooInvalidoException, AvioesIndisponiveisNoAeroportoException, BagagemNaoExisteException{
		String codigoAeroportoBase = "REC";
		this.aeroportos.decola(codigoAeroportoBase);//Aeroporto base de operaçoes do programa
		this.aeroportos.pousa(this.voos.procurarVoo(numero).getDestino().getCodigo());
		this.pessoas.realocarPiloto(this.voos.procurarVoo(numero).getPiloto().getCpf(), this.voos.procurarVoo(numero).getDestino());
		Aviao aviaoAtualizado = new Aviao(this.voos.procurarVoo(numero).getAviao().getID(), this.voos.procurarVoo(numero).getAviao().getModelo(),this.voos.procurarVoo(numero).getAviao().getCapacidade(), this.voos.procurarVoo(numero).getDestino());
		this.avioes.atualizarDadosAviao(this.voos.procurarVoo(numero).getAviao().getID(), aviaoAtualizado);
		this.bagagens.retirarBagagens(this.voos.procurarVoo(numero));
		this.voos.removerVoo(this.voos.procurarVoo(numero).getNum());
	}
}
