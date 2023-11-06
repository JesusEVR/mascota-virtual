package Controlador.State;

/**
 * Interfaz con los diversos métodos que cambian los estados/modos de la Mascota Virtual.
 *
 * @author Supr-Lilito
 * @author paolasanv
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public interface EstadoMascota{

	/**
	 * Metodo que cambia el estado de la mascota (Hogar) a "Comer".
	 *
	 */
	public void alimentar();
	/**
	 * Metodo que cambia el estado de la mascota (Hogar) a "Jugar".
	 *
	 */
	public void jugar();
	/**
	 * Metodo que cambia el estado de la mascota (Hogar) a "Dormir".
	 *
	 */
	public void dormir();
	/**
	 * Metodo que cambia el estado de la mascota (Hogar) a "Despertar".
	 *
	 */
	public void despertar();

}
