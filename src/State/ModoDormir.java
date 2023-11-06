package State;

/**
 * Clase que define el modo dormir de la mascota.
 *
 */
public class ModoDormir implements EstadoMascota{
	/**
	 * Objeto de tipo hogar que contiene a la mascota que tendrá diversos estados
	 */
	private Hogar hogar; 

	/**
	 * Constructor por parámetros.
         * @param h El objeto hogar que inicializa el atributo de clase.
	 *
	 */
	public ModoDormir(Hogar h){
		hogar = h;
	}

	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede comer en este estado.
	 */
	public void alimentar(){
		System.out.println("\n"+"				Tu mascota esta durmiendo, si lo quieres alimentar primero debes despertarlo");
	}

	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede jugar en este estado.
	 */
	public void jugar(){
		System.out.println("\n"+"				Tu mascota esta durmiendo, si quieres jugar con él primero debes despertarlo");
	}

	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede dormir (de nuevo) en este estado.
	 */
	public void dormir(){
		System.out.println("\n"+"				Tu mascota ya esta durmiendo :/");
		
	}

	/**
	 * Método que despierta a la mascota y cambia su estado a "Depertear"
	 */
	public void despertar(){
		hogar.unDiaMasVivo();
		System.out.println("\n"+"				Tu mascota te desea los buenos días. ¿Que haran hoy?");
		hogar.asignarNuevoEstado(hogar.modoDespertar());
		
	}

}
