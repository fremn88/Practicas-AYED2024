package tp2.ej9;

import tp2.ej1.BinaryTree;

public class ParcialArbol {
	
	public BinaryTree<Datos> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Datos> res = new BinaryTree<Datos>();
		if(arbol!=null){
			if(arbol.getData()!=null) {
				//inicializo arbol Datos
				Datos aux = new Datos(arbol.getData(),arbol.getData());
				res.setData(aux);
				//si tiene hijos, llamo metodo recursivo, sino no se hace nada y se devuelve el arbol datos.
				if(arbol.hasLeftChild()) {
					res.addLeftChild(sumDif(arbol.getLeftChild(),aux.getSuma(),arbol.getData()));
				}
				if(arbol.hasRightChild()) {
					res.addRightChild(sumDif(arbol.getRightChild(),aux.getSuma(),arbol.getData()));
				}
			}
		}
		return res;
	}
	
	private BinaryTree<Datos> sumDif(BinaryTree<Integer> arbol,Integer sumaPadre, Integer datoPadre){
		BinaryTree<Datos> res = new BinaryTree<Datos>();
		if(arbol!=null){
			if(arbol.getData()!=null) {
				//inicializo arbol Datos
				Datos aux = new Datos(arbol.getData()+sumaPadre,arbol.getData()-datoPadre);
				res.setData(aux);
				//si tiene hijos, llamo metodo recursivo, sino no se hace nada y se devuelve el arbol datos.
				if(arbol.hasLeftChild()) {
					res.addLeftChild(sumDif(arbol.getLeftChild(),aux.getSuma(),arbol.getData()));
				}
				if(arbol.hasRightChild()) {
					res.addRightChild(sumDif(arbol.getRightChild(),aux.getSuma(),arbol.getData()));
				}
			}
		}
		return res;
	}
	
}
