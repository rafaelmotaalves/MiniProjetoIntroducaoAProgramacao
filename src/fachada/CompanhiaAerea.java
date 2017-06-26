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
	
	//cadastra aeroporto
	public void cadastrarAeroporto(Aeroporto aeroporto) throws CapacidadeAeroportoInvalidaException, AeroportoJaCadastradoException{
		this.aeroportos.cadastrar(aeroporto);
	}
	//cadastra aviao
	public void cadastrarAviao(Aviao aviao) throws AviaoJaCadastradoException, CapacidadePassageirosInvalidoException{
		this.avioes.cadastrarAviao(aviao);
	}
	//cadastra passageiro
	public void cadastrarPassageiro(Pessoa passageiro) throws cpfJaCadastradoException, cpfInvalidoException, passageiroInvalidoException{
		this.pessoas.cadastrarPassageiro(passageiro);
	}
	//cadastra funcionário
	public void cadastrarFuncionario(Funcionario funcionario) throws cpfInvalidoException, salarioInvalidoException, cpfJaCadastradoException, funcionarioInvalidoException{
		this.pessoas.contratarFuncionario(funcionario);
	}
	//cadastra bagagem
	public void cadastrarBagagem(Bagagem bagagem) throws BagagemJaExistenteException, BagagemPesoException{
		this.bagagens.cadastrarBagagem(bagagem);
	}
	//cadastra voo
	public void cadastrarVoo(Voo voo) throws VooJaCadastradoException, NumVooInvalidoException{
		this.voos.cadastrarVoo(voo);
	}
	//atualiza aeroporto, substituindo por um novo objeto aeroporto
	public void atualizarAeroporto(String codigo, Aeroporto aeroporto) throws AeroportoNotFoundException, CapacidadeAeroportoInvalidaException{
		this.aeroportos.atualizarCadastroAeroporto(codigo, aeroporto);
	}
	
	// Atualizar capacidade de passageiros de um aviao
	public void atualizarAviao(int id, Aviao aviao) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		this.avioes.atualizarDadosAviao(id, aviao);
	}
	
	// Atualizar dados cadastrais de um passageiro
	public void atualizarPassageiro(String cpf, Pessoa passageiro) throws cpfNaoCadastradoException, passageiroInvalidoException{
		this.pessoas.atualizarDadosPassageiro(cpf, passageiro);
	}
	//atualiza a bagagem de um passageiro substituindo por um novo objeto bagagem
	public void atualizarBagagem(int codigo, Bagagem bagagem) throws BagagemNaoExisteException, BagagemJaExistenteException, BagagemPesoException{
		this.bagagens.estornarBagagem(codigo);
		this.bagagens.cadastrarBagagem(bagagem);
	}
	
	// Atualizar dados de um voo
	public void atualizarVoo(String numero, Voo voo) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.atualizarVoo(numero, voo);
	}
	//remove aeroporto
	public void removerAeroporto(String codigo) throws AeroportoNotFoundException{
		this.aeroportos.removerCadastroAeroporto(codigo);
	}
	//remove aviao
	public void removerAviao(int id) throws IdNaoCadastradaException, CapacidadePassageirosInvalidoException{
		this.avioes.removerAviao(id);
	}
	//remove passageiro
	public void removerPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		this.pessoas.removerPassageiro(cpf);
	}
	//demite funcionario 
	public void demitirFuncionario(String cpf) throws cpfNaoCadastradoException, funcionarioInvalidoException{
		this.pessoas.demitirFuncionario(cpf);
	}
	
	//estorna bagagem
	public void estornarBagagem(int codigo) throws BagagemNaoExisteException{
		this.bagagens.estornarBagagem(codigo);
	}
	//remove voo
	public void removerVoo(String numero) throws VooNaoCadastradoException, NumVooInvalidoException{
		this.voos.removerVoo(numero);
	}
	//procura aeroporto
	public Aeroporto procurarAeroporto(String codigo) throws AeroportoNotFoundException{
		return this.aeroportos.procurar(codigo);
	}
	//procura aviao
	public Aviao procurarAviao(int ID) throws IdNaoCadastradaException{
		return this.avioes.procurarAviao(ID);
	}
	//procura passageiro
	public Passageiro procurarPassageiro(String cpf) throws cpfNaoCadastradoException, passageiroInvalidoException{
		return this.pessoas.BuscarPassageiro(cpf);
	}
	//procura voo
	public Voo procurarVoo(String numero) throws VooNaoCadastradoException, NumVooInvalidoException{
		return this.voos.procurarVoo(numero);
	}
	
	// Realocar piloto para um outro aeroporto
	public void realocarPiloto(String cpf, Aeroporto local) throws cpfNaoCadastradoException, pilotoInvalidoException{
		this.pessoas.realocarPiloto(cpf, local);
	}
	
	// Realocar aviao para um outro aeroporto
	public void realocarAviao(String codigoAeroporto) throws AeroportoNotFoundException, AeroportoLotadoException{
		this.aeroportos.pousa(codigoAeroporto);
	}
	//embarca passageiro 
	public void embarcarPassageiro(String numeroVoo, String cpfPassageiro) throws VooNaoCadastradoException, NumVooInvalidoException, CapacidadePassageirosInvalidoException, cpfNaoCadastradoException, passageiroInvalidoException{
		this.voos.embarcarPassageiro(numeroVoo, pessoas.BuscarPassageiro(cpfPassageiro));
	}
	
	// Realizar o voo partindo do aeroporto base para o destino determinado
	public void executarVoo(String numero) throws AeroportoNotFoundException, AeroportoLotadoException, cpfNaoCadastradoException, pilotoInvalidoException, IdNaoCadastradaException, CapacidadePassageirosInvalidoException, VooNaoCadastradoException, NumVooInvalidoException, AvioesIndisponiveisNoAeroportoException, BagagemNaoExisteException{
		String codigoAeroportoBase = "REC";
		this.aeroportos.decola(codigoAeroportoBase);//Aeroporto base de operaçoes do programa
		//this.aeroportos.pousa(this.voos.procurarVoo(numero).getDestino().getCodigo());
		this.pessoas.realocarPiloto(this.voos.procurarVoo(numero).getPiloto().getCpf(), this.voos.procurarVoo(numero).getDestino());
		Aviao aviaoAtualizado = new Aviao(this.voos.procurarVoo(numero).getAviao().getID(), this.voos.procurarVoo(numero).getAviao().getModelo(),this.voos.procurarVoo(numero).getAviao().getCapacidade(), this.voos.procurarVoo(numero).getDestino());
		this.avioes.atualizarDadosAviao(this.voos.procurarVoo(numero).getAviao().getID(), aviaoAtualizado);
		this.bagagens.retirarBagagens(this.voos.procurarVoo(numero));
		this.voos.removerVoo(this.voos.procurarVoo(numero).getNum());
	}
}
