package tp2.ej1;

import tp1.ej8.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int suma = 0;
		if(this.isLeaf()) {
			suma = 1;
		}
		else {
			if(this.hasLeftChild()) {
				suma+=this.getLeftChild().contarHojas();
			}
			if(this.hasRightChild()) {
				suma+=this.getRightChild().contarHojas();
			}
		}
		return suma;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
	   BinaryTree<T> arbol = new BinaryTree<T>();
	   arbol.setData(this.getData());
	   if(this.isLeaf()) {
		   return arbol;
	   } else {
		   // si no es hoja, llamado recursivo a hijos izq y der (si los tiene) y los asigno invertidos
		   if(this.hasRightChild()) {
			   arbol.addLeftChild(this.getRightChild().espejo());  
		   }
		   if(this.hasLeftChild()) {
			   arbol.addRightChild(this.getLeftChild().espejo());
		   }
	   }
 	   return arbol;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue((BinaryTree<T>) this); 
		cola.enqueue(null);
		int nivel = 1;
		System.out.print("[ ");
		while(!cola.isEmpty()&&nivel<=m) {
			BinaryTree<T> aux = cola.dequeue();
			if(aux!=null) {
				if(nivel>=n) {
					System.out.print(aux.getData()+" ");
				}
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			} else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					if(nivel>=n&&nivel<m) {
						System.out.print("] [ ");
					}
				}
				nivel++;
			}
			
		}
		System.out.print("]");
		
	}

	public void imprimirNiveles() {
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue((BinaryTree<T>) this); //???? por que si es el metodo enqueue de "queue" acepta dato generico T, me alerta al colocar this ???? porque la variable de instancia es generica, no es BT
		cola.enqueue(null);
		System.out.print("[ ");
		while(!cola.isEmpty()) {
			BinaryTree<T> aux = cola.dequeue();
			if(aux!=null) {
				System.out.print(aux.getData()+" ");
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			} else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					System.out.print("] [ ");
					}
				}
			}
		System.out.print("]");
	}
	
	public void imptimirInorder() {
		if(this.hasLeftChild()) {
			this.getLeftChild().imptimirInorder();
		}
		System.out.println(this.getData());
		if(this.hasRightChild()) {
			this.getRightChild().imptimirInorder();
		}
	}
		
}

