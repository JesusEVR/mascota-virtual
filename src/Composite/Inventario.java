package Composite;

import java.util.LinkedList;

public class Inventario implements Producto{

	private LinkedList<Producto> listaDeAlimentos = new LinkedList<>();

	public Inventario(){
	}
	
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
	
	public int modificaHambre(){ 
		return 0; //por defecto
	}
	
	public int modificaFelicidad(){
		return 0; //por defecto
	}
	
	public void agregarProducto(Producto a){
		listaDeAlimentos.add(a);
	}
	
	public void vaciarRefrigerador(){
		listaDeAlimentos.clear();
	}

	public boolean tieneProductos(){
		return listaDeAlimentos.size()!=0;
	}

}