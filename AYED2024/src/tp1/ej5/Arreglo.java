package tp1.ej5;

public class Arreglo {
	private static int min;
	private static int max;
	private static int prom;
	
	// Inciso a: devuelve lo pedido por mecanismo return
	public static Valores calculo1(int[] arr) {
		Valores obj = new Valores();
		int min=9999;
		int max=0;
		int prom=0;
		int suma=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
			suma+=arr[i];
		}
		obj.setMax(max);
		obj.setMin(min);
		prom=suma/arr.length;
		obj.setProm(prom);
		return obj;
	}
	
	// Inciso b: devuelve lo pedido interactuando con algun parametro 
	public static void calculo2(int[] arr, Valores obj) {
		int min=9999;
		int max=0;
		int prom=0;
		int suma=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
			suma+=arr[i];
		}
		obj.setMax(max);
		obj.setMin(min);
		prom=suma/arr.length;
		obj.setProm(prom);
	}
	
	// Inciso c: devuelve sin retorno ni parametro
	public static void calculo3(int[] arr) {
		int min=9999;
		int max=0;
		int prom=0;
		int suma=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
			suma+=arr[i];
		}
		prom=suma/arr.length;
		Arreglo.max = max;
		Arreglo.min = min;
		Arreglo.prom = prom;		
	}
}
