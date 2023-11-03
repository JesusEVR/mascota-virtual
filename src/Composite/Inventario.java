package Composite;

import java.util.LinkedList;

/**
 * Clase que define las caracteristicas principales de un inventario que guarda productos
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class Inventario implements Producto{
	/**
	 * Lista de alimentos que se gaurdan en un inventario
	 */
	private LinkedList<Producto> listaDeAlimentos = new LinkedList<>();

	/**
	 * Constructor por omision
	 */
	public Inventario(){
	}

	/**
	 * Metodo que devuelve el precio total de los productos de la lista
         *
	 * @return precio El precio total de los productos dentro un inventario
	 */
	public double precio(){
		double precio = 0;
		for(Producto p : listaDeAlimentos){
			precio += p.precio();
		}
		return precio;
	}

	/**
	 * Metodo que devuelve la informacion de todos los productos dentro de un inventario
         *
	 * @return precio Una cadena grande que detalla cada uno de los articulos del inventario
	 */
	public String informacion(){ //para mostrar al usuario su almacen
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacion()+ "\n";
		}
		return productos;
	}
	
	/**
	 * Metodo que devuelve la informacion (incluyendo el precio) de todos los productos dentro de un inventario
         *
	 * @return precio Una cadena grande que detalla cada uno de los articulos del inventario
	 */
	public String informacionConPrecio(){ //para mostrar el menu
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacionConPrecio()+ "\n";
		}
		return productos;
	}

	/**
	 * Regresa un 0 como codigo por defecto 
	 */
	public String codigo(){
		return "0";
	}

	/**
	 * Regresa 0 puntos de hambre por defecto 
	 */
	public double modificaHambre(){ 
		return 0; //por defecto
	}

	/**
	 * Regresa 0 puntos de felicidad por defecto
	 */
	public double modificaFelicidad(){
		return 0; //por defecto
	}

	/**
	 * Metodo que agrega un producto al inventario 
	 */
	public void agregarProducto(Producto a){
		listaDeAlimentos.add(a);
	}
	
	/**
	 * Metodo que vacia el inventario
	 */
	public void vaciarInventario(){
		listaDeAlimentos.clear();
	}

	/**
	 * Metodo que determina si existe un producto dentro del inventario
	 */
	public boolean tieneProductos(){
		return listaDeAlimentos.size()!=0;
	}

}
