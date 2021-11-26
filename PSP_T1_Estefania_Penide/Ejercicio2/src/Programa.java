import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		//ArrayList<String> cadenas = new ArrayList<String>();
		String cadena = "";
		int suma=0;

		if (args.length < 1) {
			System.exit(-1);
		}

		try {

			for (int i = 0; i < args.length; i++) {
				int num = Integer.parseInt(args[i]);
				numeros.add(num);
			}
			
			boolean existeNegativo=false;
			for(Integer aux : numeros) {
				if(aux<0) {
					existeNegativo=true;
				}
				suma=suma+aux;
			}
			
			System.out.println("SUMA TOTAL: "+suma);
			
			if(existeNegativo) {
				System.exit(3);
			}else if(!existeNegativo) {
				System.exit(2);
			}

		} catch (NumberFormatException e) {
			System.out.println("Cadenas: ");
			for(int i=(args.length-1); i>=0;i--) {
				cadena=cadena+args[i]+"-";
			}
	
			StringBuilder c = new StringBuilder(cadena);
			int j =cadena.length();
			int r=j-1;
			c.replace(r,j,"");
			System.out.println(c);
			
			System.exit(0);
		}

	}

}
