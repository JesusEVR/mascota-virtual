package Composite;

public class Alimento implements Producto{
	String codigo;
	String nombre;
	String descripcion;
	double precio;
	int puntosHambre;
	int puntosFelicidad;
	
	public Alimento(String codigo, String nombre, String descripcion, double precio, int puntosHambre, int puntosFelicidad){
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion  =descripcion;
		this.precio = precio;
		this.puntosHambre = puntosHambre;
		this.puntosFelicidad = puntosFelicidad;
	}
	
	public double precio(){
		return precio;
	}
	
	public String codigo(){
		return codigo;
	}
	
	public String informacionConPrecio(){
		return "Codigo: "+codigo+ " Alimento: " + nombre +"\n"+"Descripcion: " + descripcion+"\n"+ "		Precio: $" +precio + " pejecoins" ;
	}
	
	public String informacion(){
		return "Codigo: "+codigo+ " Alimento: " + nombre +"\n"+"Descripcion: " + descripcion;
	}
	
	public int modificaHambre(){
		return puntosHambre;
	}
	
	public int modificaFelicidad(){
		return puntosFelicidad;
	}
	
}