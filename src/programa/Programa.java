package programa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import classesBasicas.*;
import interfaces.*;
import exceptions.*;
import repositorios.*;
import cadastros.*;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			Scanner in = new Scanner(new FileReader("config.txt"))
					.useDelimiter("\\||\\n");
			String nome = in.next();
			
			RepositorioAeroportos repAeroportos;
			RepositorioAviao repAvioes;
			RepositorioBagagem repBagagens;
			RepositorioPessoas repPessoas;
			RepositorioVoo repVoos;
			
			
			//in.close();
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
			
			Aeroporto aeroporto;
			Aviao aviao;
			Bagagem bagagem;
			Passageiro passageiro;
			Funcionario funcionario;
			Piloto piloto;
			
			aeroporto = new Aeroporto("Recife","REC", 10, 0);
			try {
				aeroportos.cadastrar(aeroporto);
			} catch (CapacidadeAeroportoInvalidaException | AeroportoJaCadastradoException e) {
					System.out.println(e.getMessage());
			}
			
			aeroporto = new Aeroporto("Los Angeles","LAX", 50, 10000);
			try {
				aeroportos.cadastrar(aeroporto);
			} catch (CapacidadeAeroportoInvalidaException | AeroportoJaCadastradoException e) {
					System.out.println(e.getMessage());
			}
			
			aviao = new Aviao();
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
	}
		
		
	}
}
