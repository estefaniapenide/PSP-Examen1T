import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class EjecutarPrograma {

	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");

		File fOut = new File("fichero.txt");

		ProcessBuilder pb = new ProcessBuilder("java", "Programa");
		pb.directory(directorio);

		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));

		Process p = pb.start();

		PrintStream ps = new PrintStream(p.getOutputStream());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un número: ");
		String numero;
		while ((numero = br.readLine()) != null) {
			ps.println(numero);
			ps.flush();
		}
		
		ps.close();
		br.close();
		
		p.destroy();
		
	}

}
