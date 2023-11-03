package Composite;

/**
 * Clase que define las caracteristicas de un alimento
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class Alimento implements Producto{
	/**
	 * Codigo unico del alimento
	 */
	private String codigo;
	/**
	 * Nombre del prodcuto
	 */
	private String nombre;
	/**
	 * Descripcion del alimento
	 */
	private String descripcion;
	/**
	 * Precio del alimento
	 */
	private double precio;
	/**
	 * Puntos de hambre que agrega o resta a la mascota virtual
	 */
	private double puntosHambre;
	/**
	 * Puntos de felicidad que agrega o resta a la mascota virtual
	 */
	private double puntosFelicidad;

	/**
	 * Constructor por parametros de un alimento
         *
	 * @param codigo El codigo unico de cada alimento
         * @param nombre El nombre del alimento
         * @param descripcion Una breve cadena donde se detallan las caracteristicas del alimento
         * @param precio Cuanto cuesta el alimento
         * @param puntosHambre La cantidad de puntos de hambre que suma o resta a la mascota
         * @param puntosFelicidad La cantidad de puntos de felicidad que suma o resta a la mascota
         *
	 */
	public Alimento(String codigo, String nombre, String descripcion, double precio, double puntosHambre, double puntosFelicidad){
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion  =descripcion;
		this.precio = precio;
		this.puntosHambre = puntosHambre;
		this.puntosFelicidad = puntosFelicidad;
	}

	/**
	* Devuelve el nombre del alimento
	*/
	public String nombre(){
		return nombre;
	}

	/**
	 * Devuelve el precio del artículo
         *
	 * @return precio
	 */
	public double precio(){
		return precio;
	}

	/**
	 * Devuelve el codigo unico del artículo
         *
	 * @return codigo
	 */
	public String codigo(){
		return codigo;
	}
	
	/**
	 * Devuelve uuna cadena con la información y el precio del artículo
	 */
	public String informacionConPrecio(){
		return "Codigo: "+codigo+ " Alimento: " + nombre +"\n"+"Descripcion: " + descripcion+"\n"+ "		Precio: $" +precio + " pejecoins" ;
	}
	
	/**
	 * Devuelve una cadena con la información del artículo
	 */
	public String informacion(){
		return "Codigo: "+codigo+ " Alimento: " + nombre +"\n"+"	Descripcion: " + descripcion;
	}

	/**
	 * Devuelve la cantidad de puntos que suma o resta a los puntos de hambre de la mascota
         *
	 * return puntosHambre
	 */
	public double modificaHambre(){
		return puntosHambre;
	}
	
	/**
	 * Devuelve la cantidad de puntos que suma o resta a los puntos de felicidad de la mascota
         *
	 * return puntosFelicidad
	 */
	public double modificaFelicidad(){
		return puntosFelicidad;
	}
	
}
