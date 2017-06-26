package programa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import classesBasicas.*;
import interfaces.*;
import exceptions.*;
import repositorios.*;
import cadastros.*;
import fachada.*;

public class Programa {

	public static void main(String[] args) {
		try{
			Scanner in = new Scanner(new FileReader("config.txt"))
					.useDelimiter("\\||\\n");
			String nome = in.next();
			
			RepositorioAeroportos repAeroportos;
			RepositorioAviao repAvioes;
			RepositorioBagagem repBagagens;
			RepositorioPessoas repPessoas;
			RepositorioVoo repVoos;
			
			
			if (nome.toLowerCase().equals("array")){
				repAeroportos = new RepositorioAeroportoArray(5);
				repAvioes = new RepositorioAviaoArray(5);
				repBagagens = new RepositorioBagagemArray();
				repPessoas = new RepositorioPessoasArray(5);
				repVoos = new RepositorioVooArray(5);
			} else if(nome.toLowerCase().equals("lista")){
				repAeroportos = new RepositorioAeroportoLista();
				repAvioes = new RepositorioAviaoLista();
				repBagagens = new RepositorioBagagemLista();
				repPessoas = new RepositorioPessoasLista();
				repVoos = new RepositorioVooLista();
			} else {
				System.out.println("Erro na indicaçao do Repositorio, repositorio em lista usado como default");
				repAeroportos = new RepositorioAeroportoLista();
				repAvioes = new RepositorioAviaoLista();
				repBagagens = new RepositorioBagagemLista();
				repPessoas = new RepositorioPessoasLista();
				repVoos = new RepositorioVooLista();
			}
			
			CadastroAeroporto aeroportos = new CadastroAeroporto(repAeroportos);
			CadastroAviao avioes = new CadastroAviao(repAvioes);
			CadastroBagagem bagagens = new CadastroBagagem(repBagagens);
			CadastroPessoas pessoas = new CadastroPessoas(repPessoas);
			CadastroVoo voos = new CadastroVoo(repVoos);
			
			CompanhiaAerea companhiaAerea = new CompanhiaAerea(aeroportos, avioes, pessoas, bagagens, voos);
			
			Aeroporto aeroporto;
			Aviao aviao;
			Bagagem bagagem;
			Passageiro passageiro;
			Funcionario funcionario;
			Piloto piloto;
			Voo voo; 
			
			aeroporto = new Aeroporto("Recife","REC", 10, 0);
			try {
				companhiaAerea.cadastrarAeroporto(aeroporto);
			} catch (CapacidadeAeroportoInvalidaException | AeroportoJaCadastradoException e) {
					System.out.println(e.getMessage());
			}
			
			aeroporto = new Aeroporto("Los Angeles","LAX", 50, 10000);
			try {
				companhiaAerea.cadastrarAeroporto(aeroporto);
			} catch (CapacidadeAeroportoInvalidaException | AeroportoJaCadastradoException e) {
					System.out.println(e.getMessage());
			}
			
			try {
				aviao = new Aviao(1, "Boeing-747", 100, companhiaAerea.procurarAeroporto("REC"));
			} catch (AeroportoNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			funcionario = new Funcionario("001.002.003-12", "Clara Maria", 2000);
			try {
				companhiaAerea.cadastrarFuncionario(funcionario);
			} catch (cpfInvalidoException | salarioInvalidoException | cpfJaCadastradoException
					| funcionarioInvalidoException e) {
				System.out.println(e);
			}
			piloto = new Piloto("001.002.004-12", "Gisele Pessoa", 4000);
			try {
				companhiaAerea.cadastrarFuncionario(piloto);
			} catch (cpfInvalidoException | salarioInvalidoException | cpfJaCadastradoException
					| funcionarioInvalidoException e) {
				System.out.println(e.getMessage());
			} 
			try {
			pessoas.realocarPiloto("001.002.004-12", aeroportos.procurar("REC"));
			companhiaAerea.realocarPiloto(piloto.getCpf(), companhiaAerea.procurarAeroporto("REC"));
			} catch (cpfNaoCadastradoException | pilotoInvalidoException | AeroportoNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			passageiro = new Passageiro("001.002.004-12", "Marcos Augusto");
			try {
				companhiaAerea.cadastrarPassageiro(passageiro);
			} catch (cpfJaCadastradoException | cpfInvalidoException | passageiroInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
			
			passageiro = new Passageiro("001.002.005-12", "Marcos Augusto");
			try {
				companhiaAerea.cadastrarPassageiro(passageiro);
			} catch (cpfJaCadastradoException | cpfInvalidoException | passageiroInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				voo = new Voo("REC-LAX", "14:00", 2000, piloto, companhiaAerea.procurarAviao(1), companhiaAerea.procurarAeroporto("LAX"));
				try {
					companhiaAerea.cadastrarVoo(voo);
				} catch (VooJaCadastradoException | NumVooInvalidoException e) {
					System.out.println(e.getMessage());
				}
			} catch (AeroportoNotFoundException | IdNaoCadastradaException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				bagagem = new Bagagem(1, 10.0, companhiaAerea.procurarVoo("REC-LAX"), companhiaAerea.procurarAeroporto("LAX"), companhiaAerea.procurarPassageiro("001.002.005-12"));
			} catch (VooNaoCadastradoException | NumVooInvalidoException | AeroportoNotFoundException
					| cpfNaoCadastradoException | passageiroInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
	}
		
		
	}
}
