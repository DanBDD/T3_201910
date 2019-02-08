package model.data_structures;

import java.util.Iterator;

public class Pila<T> implements IStack<T> {
	
	private Nodo<T> primerNodo ;
	
	private int numElementos;
	
	@Override
	public Iterator<T> iterator() {

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
		// TODO Auto-generated method stub
		return numElementos;
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}



}
