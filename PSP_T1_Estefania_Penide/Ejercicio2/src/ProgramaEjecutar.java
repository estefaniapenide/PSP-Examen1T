import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProgramaEjecutar {

	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Programa");
		//pb.command("java", "Programa","1","aa","bb");
		//pb.command("java", "Programa","1","2","3");
		//pb.command("java", "Programa","1","-3","-2","5");
		pb.directory(directorio);

		Process p = pb.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String cadena;
		while ((cadena = br.readLine()) != null) {
			System.out.println(cadena);
		}
		
		br.close();

		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		String error;
		while ((error = brEr.readLine()) != null) {
			System.out.println("ERROR > " + error);
		}
		
		brEr.close();

		int valSalida;
		//try {
			//valSalida=p.waitFor();
			valSalida = p.exitValue();
			switch (valSalida) {
			case 2:
				System.out.println("VALOR DE SALIDA: " + valSalida);
				System.out.println("TODOS LOS VALORES ERAN ENTEROS POSITIVOS");
				break;
			case 3:
				System.out.println("VALOR DE SALIDA: " + valSalida);
				System.out.println("EXISTE AL MENOS UN ENTERO NEGATIVO");
				break;
			case 0:
				System.out.println("VALOR DE SALIDA: " + valSalida);
				System.out.println("EXISTE AL MENOS UNA CADENA");
				break;
			case -1:
				System.out.println("VALOR DE SALIDA: " + valSalida);
				System.out.println("NO SE HA ENVIADO NINGÚN ARGUMENTO");
				break;
			}
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		p.destroy();

	}

}
