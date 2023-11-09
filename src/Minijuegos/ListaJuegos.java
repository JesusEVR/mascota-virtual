package Minijuegos;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;
import Modelo.Iterator.Catalogo;
import Modelo.Iterator.IteradorLista;

public class ListaJuegos implements Catalogo{
    
    protected LinkedList<Object> listaJuegos;

    public ListaJuegos(){
        listaJuegos = new LinkedList<>();
        String texto;
        String resultado;
        

        texto = "Daniel se le ha complicado resolver un problema de Álgebra Superior y está pidiendo ayuda.";
        ConstructorEventos c1 = new ConstructorEventos("1", "Ayuda en Tarea", texto, 1, 2, 5);
        resultado = "Lograste resolver el problema, y Daniel los recompensó con 4 pejecoins.";
        c1.agregarCaso(resultado, 4.0 , 0.0 , -10.0, 5.0, 4);
        resultado = "que noob perdiste.";
        c1.agregarCaso(resultado, 0, 0, -10.0, -5.0, 1);
        agregarEvento((Object) c1);

        
    }

    /**
	 * Método que agrega un producto a la lista
	 */
	public void agregarEvento(Object a){
		listaJuegos.add(a);
	}

	/**
	 * Metodo que crea un iterador para recorrer los elementos del menu
	 *
	 * @return iterador
	 */
	public Iterator creaIterador(){
		return new IteradorLista(listaJuegos);
	}
}