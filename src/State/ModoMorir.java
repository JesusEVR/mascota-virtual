package State;

/**
 * Clase que define el modo morir de la mascota.
 *
 */
public class ModoMorir implements EstadoMascota{
	/**
	 * Objeto de tipo hogar que contiene a la mascota que tendrá diversos estados
	 */
	private Hogar hogar; 

	/**
	 * Constructor por parámetros.
         * @param h El objeto hogar que inicializa el atributo de clase.
	 *
	 */
	public ModoMorir(Hogar h){
		hogar = h;
	}

	/**
	 * Imprime una mensaje donde se dice de forma explicita que la mascota no puede comer en este estado.
	 */
	public void alimentar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_ G A M E   O V E R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, los gusanos se alimentaran de el y no al reves");	
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");	
	}

	/**
	 * Imprime una mensaje donde se dice de forma explicita que la mascota no puede jugar en este estado.
	 */
	public void jugar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_ G A M E   O V E R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, no puedes jugar con el pues seria una falta de respeto");
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
		
	}

	/**
	 * Imprime una mensaje donde se dice de forma explicita que la mascota no puede dormir en este estado.
	 */
	public void dormir(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_ G A M E   O V E R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, asi que ya esta mimido				");
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
	}

	/**
	 * Imprime una mensaje donde se dice de forma explicita que la mascota no puede despertar en este estado.
	 */
	public void despertar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_ G A M E   O V E R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, no puedes despertarlo a menos que seas Dios");	
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
	}

}
