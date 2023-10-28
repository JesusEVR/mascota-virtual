package Composite;

public class Alimento implements Producto{

	private String codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private double puntosHambre;
	private double puntosFelicidad;
	
	public Alimento(String codigo, String nombre, String descripcion, double precio, double puntosHambre, double puntosFelicidad){
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
	
	public double modificaHambre(){
		return puntosHambre;
	}
	
	public double modificaFelicidad(){
		return puntosFelicidad;
	}
	
}