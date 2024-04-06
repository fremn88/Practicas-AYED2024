package tp1.ej7;
import java.util.*;
public class TestEj7h {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<3;i++) {
			arr.add(s.nextInt());
		}
		ImprimirArrayListInt.Imprimir(arr);
		Ej7h obj = new Ej7h();
		obj.invertirArrayList(arr);
		ImprimirArrayListInt.Imprimir(arr);
	}
}
	