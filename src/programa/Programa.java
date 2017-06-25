package programa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import classesBasicas.*;
import interfaces.*;
import exceptions.*;
import repositorios.*;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			Scanner in = new Scanner(new FileReader("config.txt"))
					.useDelimiter("\\||\\n");
			String nome = in.next();
			
			RepositorioAeroportos aeroportos;
			RepositorioAviao avioes;
			RepositorioBagagem bagagens;
			RepositorioPessoas pessoas;
			RepositorioVoo voos;
			
			//in.close();
			if (nome.toLowerCase().equals("array")){
				aeroportos = new RepositorioAeroportoArray(5);
				avioes = new RepositorioAviaoArray(5);
				bagagens = new RepositorioBagagemArray();
				pessoas = new RepositorioPessoasArray(5);
				voos = new RepositorioVooArray(5);
			} else if(nome.toLowerCase().equals("lista")){
				
			} else {
				System.out.println("Erro na indicaçao do Repositorio");
			}
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
	}
		
		
	}
}
