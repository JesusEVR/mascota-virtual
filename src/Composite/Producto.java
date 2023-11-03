package Composite;

/**
 * Interfaz que define los metodos de un producto de la tienda
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public interface Producto{
	/**
	 * Devuelve el precio del artículo
	 */
	public double precio();
	/**
	 * Devuelve una cadena con la información del artículo
	 */
	public String informacion();
	/**
	 * Devuelve una cadena con la información y el precio del artículo
	 */
	public String informacionConPrecio();
	/**
	 * Devuelve el codigo unico del producto
	 */
	public String codigo();
	/**
	 * Devuelve la cantidad de puntos que suma o resta a los puntos de hambre de la mascota
	 */
	public double modificaHambre();
	/**
	 * Devuelve la cantidad de puntos que suma o resta a los puntos de felicidad de la mascota
	 */
	public double modificaFelicidad();
}
