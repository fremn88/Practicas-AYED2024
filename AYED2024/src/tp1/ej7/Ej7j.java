package tp1.ej7;
import java.util.*;
public class Ej7j {
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		// si lista1 es vacia y lista2  es vacia
		if(lista1.isEmpty()&&lista2.isEmpty()) {
			return resultado;
		}
		// si lista1 es vacia y lista2 no es vacia
		else if(lista1.isEmpty()&&!lista2.isEmpty()) {
			Integer val = lista2.remove(0);
			resultado.addAll(combinarOrdenado(lista1,lista2));
			resultado.add(0,val);
		}
		// si lista1 no es vacia y lista 2 es vacia
		else if(!lista1.isEmpty()&&lista2.isEmpty()) {
			Integer val = lista1.remove(0);
			resultado.addAll(combinarOrdenado(lista1,lista2));
			resultado.add(0,val);
		}
		// si ninguna es vacia
		else if(!lista1.isEmpty()&&!lista2.isEmpty()) {
			Integer val1 = lista1.remove(0);
			Integer val2 = lista2.remove(0);
			resultado.addAll(combinarOrdenado(lista1,lista2));
			if(val2.compareTo(val1)>0) {
				resultado.add(0,val2);
				resultado.add(0,val1);
			}
			else {
				resultado.add(0,val1);
				resultado.add(0,val2);				
			}
		}
		return resultado;
	}
}
