package programa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Programa {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			Scanner scanner = new Scanner(new FileReader("config.txt"))
					.useDelimiter("\\||\\n");
			String nome = scanner.next();
			System.out.println(nome);
			scanner.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
	}
	}
}
