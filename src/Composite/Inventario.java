package Composite;

import java.util.LinkedList;

/**
 * Clase que define al inventario donde se guardan los alimentos de la mascota virtual
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class Inventario implements Producto{
	/**
	 * Lista de alimentos que se gaurdan en el inventario
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
	 * @return precio El precio total de los productos dentro del inventario
	 */
	public double precio(){
		double precio = 0;
		for(Producto p : listaDeAlimentos){
			precio += p.precio();
		}
		return precio;
	}

	
	public String informacion(){ //para mostrar al usuario su almacen
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacion()+ "\n";
		}
		return productos;
	}
	
	
	public String informacionConPrecio(){ //para mostrar el menu
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacionConPrecio()+ "\n";
		}
		return productos;
	}
	
	public String codigo(){
		return "0"; //por defecto
	}
	
	public double modificaHambre(){ 
		return 0; //por defecto
	}
	
	public double modificaFelicidad(){
		return 0; //por defecto
	}
	
	public void agregarProducto(Producto a){
		listaDeAlimentos.add(a);
	}
	
	public void vaciarInventario(){
		listaDeAlimentos.clear();
	}

	public boolean tieneProductos(){
		return listaDeAlimentos.size()!=0;
	}

}
