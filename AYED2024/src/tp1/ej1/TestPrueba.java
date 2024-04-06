package tp1.ej1;
import java.util.Scanner;
public class TestPrueba {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Ingrese numero a ");
			int a = s.nextInt();
			System.out.print("Ingrese numero b ");
			int b = s.nextInt();
			Prueba.incisoC(a, b);
		}
	}

}
