package tp1.ej7;
import java.util.*;
public class Ej7h {
	public void invertirArrayList(ArrayList<Integer> arr) {
		// caso base, lista vacia o lista no instanciada
		if(arr == null || arr.isEmpty()) {
			return;
		}
		// recursion, se guarda el elemento, envia lista sin el 1er elemento para que vuelva invertida
		Integer val = arr.remove(0);
		invertirArrayList(arr);
		// agrego a la lista invertida devuelta, el valor guardado con "add", que agrega al final.
		arr.add(val);
	}
}
