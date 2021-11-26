import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			String n = br.readLine();
			System.out.println("Número:"+n);

			if (n.equals("")) {

				System.out.println("No se ha introducido ningún parámetro");
			}

			int num = Integer.parseInt(n);

			StringBuilder numero = new StringBuilder(n);
			StringBuilder numeroReves = numero.reverse();

			if (numeroReves.toString().equals(n)) {
				System.out.println(n + " es capicúa.");
			} else {
				System.out.println(n + " NO es capicúa.");
			}

		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido un número entero.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
