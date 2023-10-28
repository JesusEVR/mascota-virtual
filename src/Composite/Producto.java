package Composite;

/**
 * Interfaz que define las caracteristicas comunes de los artículos que
 * ofrece la tienda CheemsMart
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version octubre 2023
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
	
	public String informacionConPrecio();
	
	public String codigo();
	
	public double modificaHambre();
	
	public double modificaFelicidad();
}
