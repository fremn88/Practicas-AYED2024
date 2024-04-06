package tp1.ej2;

public class Inciso1 {
	public static int[] multiplos(int n) {
		int[] vector = new int[n];
		if(n>0) {
			for(int i=1;i<=n;i++) {
				vector[i-1]=n*i;
			}
		}
		return vector;
	}
}
