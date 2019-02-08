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
	public void enqueue(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
