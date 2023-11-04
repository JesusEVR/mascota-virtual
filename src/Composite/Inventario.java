package Composite;

import java.util.LinkedList;
import java.util.Stack;

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
	 * Devuelve nombre '0' por defecto 
	 */
	public String nombre(){
		return "0";
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
	public String informacion(){ 
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacion();
		}
		return productos;
	}
	
	/**
	 * Metodo que devuelve la informacion (incluyendo el precio) de todos los productos dentro de un inventario
         *
	 * @return precio Una cadena grande que detalla cada uno de los articulos del inventario
	 */
	public String informacionConPrecio(){ 
		String productos = "";
		for(Producto p : listaDeAlimentos){
			productos += p.informacionConPrecio();
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
		return 0; 
	}

	/**
	 * Regresa 0 puntos de felicidad por defecto
	 */
	public double modificaFelicidad(){
		return 0; 
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
         *
	 * @return 'true' en caso de que haya un elemento en el inventario, 'false' en el caso contrario
	 */
	public boolean tieneProductos(){
		return listaDeAlimentos.size()!=0;
	}

	/**
	 * Metodo que elimina un producto en específico del inventario
         *
	 * @param a El producto que se busca eliminar
	 */
	public void eliminarProducto(Producto a){
		listaDeAlimentos.remove(a);
	}
	
	/**
	 * Metodo que busca un producto por su codigo. Si el inventario
	 * tiene mas objetos inventarios dentro, busca tambien en ellos.
	 *
	 * @param codigo Codigo del producto a buscar
	 * @return p Producto que coincide con el codigo
	 *
	 */
	public Producto encontrarProducto(String codigo){
		Inventario inventario;
		Producto producto;
		for(Producto p : listaDeAlimentos){
			if(codigo.equals(p.codigo())){
				producto = p;
				listaDeAlimentos.remove(p);
				return producto;
			}else if(p.codigo().equals("0")){
				inventario = (Inventario) p;
				return inventario.encontrarProducto(codigo);
			}
		}
		return null;
	}
	
	/**
	 * Metodo auxiliar que elimina objetos <Inventario> que esten vacios 
	 * y se encuentren dentro de la listaDeAlimentos del objeto Inventario actual
	 *
	 */
	public void eliminarSubinventarios(){
		Stack<Producto> auxiliar = new Stack<>();
		Inventario inventario;
		for(Producto p : listaDeAlimentos){
			if(p.codigo().equals("0")){
				inventario = (Inventario) p;
				if(!inventario.tieneProductos()){
					auxiliar.add(p);
				}
			}
		}
		
		for(Producto pro : auxiliar){
			this.eliminarProducto(pro);
		}
	}
}
