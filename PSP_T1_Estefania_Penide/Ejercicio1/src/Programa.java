import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			String n = br.readLine();
			System.out.println("N�mero:"+n);

			if (n.equals("")) {

				System.out.println("No se ha introducido ning�n par�metro");
			}

			int num = Integer.parseInt(n);

			StringBuilder numero = new StringBuilder(n);
			StringBuilder numeroReves = numero.reverse();

			if (numeroReves.toString().equals(n)) {
				System.out.println(n + " es capic�a.");
			} else {
				System.out.println(n + " NO es capic�a.");
			}

		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido un n�mero entero.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
