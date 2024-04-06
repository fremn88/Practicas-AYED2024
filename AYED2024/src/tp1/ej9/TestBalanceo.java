package tp1.ej9;
import tp1.ej8.Stack;
public class TestBalanceo {

	public static boolean Balanceo(String str) {
		Stack<Character> pila = new Stack<Character>();
		for(int i=0;i<str.length();i++) {
			Character c = str.charAt(i);
			if(!pila.isEmpty()) {
				Character d = pila.top();
				if(d.equals('{')&&c.equals('}')) {
					pila.pop();			
				} else if(d.equals('[')&&c.equals(']')) {
					pila.pop();
				} else if(d.equals('(')&&c.equals(')')) {
					pila.pop();
				}
				else {
					pila.push(c);
				}
				
			} else {
				pila.push(c);
			}
		}
		return pila.isEmpty();
	}
	public static void main(String[] args) {
		String textoBalanceado = "[({})]";
		String textoNoBalanceado = "[(})]";
		System.out.println("Texto balanceado: ");
		System.out.println(Balanceo(textoBalanceado));
		System.out.println("Texto no balanceado: ");
		System.out.println(Balanceo(textoNoBalanceado));
	}

}
