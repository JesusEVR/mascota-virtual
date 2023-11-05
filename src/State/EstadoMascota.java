package State;

/**
 * Interfaz con los diversos métodos que cambian los estados de la Mascota Virtual.
 *
 * @author Supr-Lilito
 * @author paolasanv
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public interface EstadoMascota{

	/**
	 * Metodo que cambia el estado del Robot a "Suspendido".
	 * Lo unico que puede hacer en dicho estado es activarse.
	 *
	 */
	public void alimentar();
	public void jugar();
	public void dormir();
	public void despertar();

}
