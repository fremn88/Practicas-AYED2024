package tp1.ej7;
import java.util.*;
public class TestEj7j {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		ArrayList<Integer> arrCombinado = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(3);
		arr1.add(5);
		arr2.add(2);
		arr2.add(4);
		arr2.add(6);
		Ej7j obj = new Ej7j();
		for(Integer i: arr1) {
			System.out.println(i);
		}
		for(Integer i: arr2) {
				System.out.println(i);
		}
		arrCombinado = obj.combinarOrdenado(arr1, arr2);
		System.out.println("Resultado: ");
		for(Integer i: arrCombinado) {
			System.out.println(i);
		}
	}

}
