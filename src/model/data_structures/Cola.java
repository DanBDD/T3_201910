package model.data_structures;

import java.util.Iterator;

public class Cola<T> implements IQueue<T>{
	
	private Nodo<T> primerNodo;
	
	private int numElementos;
	
	@Override
	public Iterator iterator() {
		
		return new Iterador<T>(primerNodo);
	}

	@Override
	public boolean isEmpty() {
		
		if(numElementos == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {

		return numElementos;
	}

	@Override
	public void enqueue(T t) {
		// TODO Auto-generated method stub
		Nodo<T> ultimo = new Nodo<T>(t);
		Nodo<T> actual=primerNodo;
		while(actual.darSiguiente()==null)
		{
			actual=actual.darSiguiente();
		}
		actual.cambiarSiguiente(ultimo);
	}

	@Override
	public T dequeue() {
		T elem = primerNodo.darElem();
		primerNodo=primerNodo.darSiguiente();
		return elem;
	}
}
