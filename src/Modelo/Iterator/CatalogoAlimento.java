package Modelo.Iterator;

import Modelo.Composite.Producto;
import Modelo.Composite.Alimento;

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
         * Los numeros tiene el orden: precio, puntosHambre, puntosFelicidad.
	 */
	public CatalogoAlimento(){
		listaAlimento = new LinkedList<>();
		Producto p1 = new Alimento("00","Manzana dorada", "Si la comes, tendras mucha suerte", 7, 2,-6); 
		agregarProducto((Object) p1);
		Producto p2 = new Alimento("01","Hamburguesa", "Para salir de la rutina ¿no?", 13.0, -15,3);
		agregarProducto((Object) p2);
		Producto p3 = new Alimento("02","Salmon", "Fino señores", 15, 8,8);
		agregarProducto((Object) p3);
		Producto p4 = new Alimento("03","Galletas premium", "Unas simples galletas no te van a matar", 7.0, -18,-18);
		agregarProducto((Object) p4);
		Producto p5 = new Alimento("04","Cebollas", "Pa' llorar a gusto", 10, -19,13);
		agregarProducto((Object) p5);
		Producto p6 = new Alimento("05","Papas fritas", "¿A quien no le gustan?", 11.0, 5,3);
		agregarProducto((Object) p6);
		Producto p7 = new Alimento("06","Liquido misterioso", "Claramente es una trampa", 20, 15,3);
		agregarProducto((Object) p7);
		Producto p8 = new Alimento("07","Pizza", "Mmm.. pizza", 13.0, -20,14);
		agregarProducto((Object) p8);
		Producto p9 = new Alimento("08","Objeto misterioso", "No sabes lo que te pude tocar...¿Quieres arriesgarte?", 5, -20,-14); 
		agregarProducto((Object) p9);
		Producto p10 = new Alimento("09","Tocino", "Algo crujiente", 5.0, 5,8);
		agregarProducto((Object) p10);
		Producto p11 = new Alimento("10","Tacos", "¿A quien no le gustan? x2", 15, -12,8);
		agregarProducto((Object) p11);
		Producto p12 = new Alimento("11","Sandwich recuperador", "Alguna estadistica aumenta para bien", 8.0, -20,7);
		agregarProducto((Object) p12);
		Producto p13 = new Alimento("12","Agua...", "pasa por mi casa, cate de mi corazon el que no me la adivine es un burro cabezon", 5, -12,-12);
		agregarProducto((Object) p13);
		Producto p14 = new Alimento("13","Oro...", "parece, plata no es; el que no la adivine bien tonto es", 10.0, 10,-17);
		agregarProducto((Object) p14);
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
