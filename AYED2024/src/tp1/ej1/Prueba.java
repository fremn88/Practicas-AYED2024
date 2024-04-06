package tp1.ej1;

public class Prueba {
	public static void incisoA(int a, int b) {
		if(a>b) {
			for(int i=a; i>=b; i--) {
				System.out.println(i);
			}
		} else {
			for(int i=b; i>=a; i--) {
				System.out.println(i);
			}
		}
	}
	
	public static void incisoB(int a, int b) {
		if(a>b) {
			while(a>=b) {
				System.out.println(a);
				a--;
			}
		} else {
			while(b>=a) {
				System.out.println(b);
				b--;
				}
			}
		}	
	
	public static void incisoC(int a, int b) {
		if(a==b) {
			System.out.println(a);
		} else if (a>b) {
			incisoC(a-1,b);
			System.out.println(a);
		} else {
			incisoC(a,b-1);
			System.out.println(b);
		}
	}
}
