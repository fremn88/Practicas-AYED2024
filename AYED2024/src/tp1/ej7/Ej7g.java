package tp1.ej7;
import java.util.*;
public class Ej7g {
	public static List<Integer> calcularSucesion (int n) {
		List<Integer> sucesion = new ArrayList<Integer>();
		sucesion.add(n);
		if(n==1) {
			return sucesion;
		} else if(n%2==0) {
			sucesion.addAll(calcularSucesion(n/2));
		} else {
			sucesion.addAll(calcularSucesion(3*n+1));
		}
		return sucesion;
		}
}
