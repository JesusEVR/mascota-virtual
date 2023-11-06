package Modelo.Iterator;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase que implementa un iterador para lista de artículos del catálogo.
 * 
 * @author Supr-Lilito
 * @author paolasanv
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class IteradorLista implements Iterator{
	/**
	 * Lista  de productos
	 */
	private LinkedList<Object> lista;
	/**
	 * Iterador de la lista
	 */
	private Iterator it;
	
	/**
         * Constructor de la clase IteradorLista.
         * 
         * @param lista Lista de productos 
	 */
	public IteradorLista(LinkedList<Object> lista){
		this.lista = lista;
		it = lista.iterator();
	}

	@Override
	public boolean hasNext(){
		return it.hasNext();
	}

	@Override 
	public Object next(){
		return it.next();
	}

	@Override
	public void remove(){
		it.remove();
	}
}
