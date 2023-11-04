package Iterator;

import Composite.Producto;
import Composite.Alimento;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase que define la característica del menu de alimentos
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 *
 */
public class CatalogoAlimento implements Catalogo{
	/**
	 * Lista de alimentos del catalogo
	 */
	protected LinkedList<Object> listaAlimento;

	/**
	 * Constructor por omisión que inicializa el menu 
	 */
	public CatalogoAlimento(){
		listaAlimento = new LinkedList<>();
		Producto p1 = new Alimento("00","Manzana", "Si la comes, tendras mucha suerte", 5, 2,2); //Precio, puntosHambre, puntosFelicidad
		agregarProducto((Object) p1);
		Producto p2 = new Alimento("01","Hamburguesa", "Puede subir tus puntos... o disminuirlos", 23.0, -5,3);
		agregarProducto((Object) p2);
	}

	/**
	 * Método que agrega un producto a la lista
	 */
	public void agregarProducto(Object a){
		listaAlimento.add(a);
	}

	/**
	 * Metodo que crea un iterador para recorrer los elementos del menu
	 *
	 * @return iterador
	 */
	public Iterator creaIterador(){
		return new IteradorLista(listaAlimento);
	}

}
