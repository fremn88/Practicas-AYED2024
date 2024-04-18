package tp3.ej4;

import java.util.List;
import tp1.ej8.Queue;
import tp3.ej1.GeneralTree;

public class AnalizadorArbol {
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		double maxP = 0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		if(arbol!=null) {
			cola.enqueue(arbol);
			cola.enqueue(null);
			double prom = 0;
			int cant = 0;
			while(!cola.isEmpty()) {
				GeneralTree<AreaEmpresa> v = cola.dequeue();
				if(v!=null) {
					// no chequeo si arboll tiene dato null???
					prom += v.getData().getTardanza();
					cant++;
					if(v.hasChildren()) {
						List<GeneralTree<AreaEmpresa>> hijos = v.getChildren();
						for(GeneralTree<AreaEmpresa> i: hijos) {
							cola.enqueue(i);
						}
					}
				} else if(!cola.isEmpty()) {
					prom = prom/cant;
					if(maxP<prom) {
						maxP = prom;
					}
					cant = 0;
					prom = 0;
					cola.enqueue(null);
				}
			}
		}
		return maxP;
	}
}
