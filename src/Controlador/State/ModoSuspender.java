package Controlador.State;

import Modelo.Prototype.MuertePorAburrimientoException;

/**
 * Clase que define el modo suspendido de la mascota.
 *
 */
public class ModoSuspender implements EstadoMascota{
	/**
	 * Objeto de tipo hogar que contiene a la mascota que tendrá diversos estados
	 */
	private Hogar hogar; 
	/**
	* Numero random entre 15 y 30 
	*/
	private int valorDormir =(int) (Math.random() * ((30 - 15) +1)) + 15;

	/**
	 * Constructor por parámetros.
         * @param h El objeto hogar que inicializa el atributo de clase.
	 *
	 */
	public ModoSuspender(Hogar h){
		hogar = h;
	}

	/**
	 * Método que cambia el estado de la mascota a Comer.
	 * Se inicia el proceso para alimentar a la mascota en el nuevo estado.
	 */
	public void alimentar(){
		System.out.println("\n"+hogar.nombreMascota()+":				¡Ya quiero comer!");
		hogar.asignarNuevoEstado(hogar.modoComer());
		hogar.alimentar();
		
	}

	/**
	 * Método que cambia el estado de la mascota a Jugar.
	 * Se inicia el proceso para jugar con la mascota en el nuevo estado.
	 */
	public void jugar(){
		System.out.println("\n"+hogar.nombreMascota()+":				¡Estoy ansioso por jugar!");
		hogar.asignarNuevoEstado(hogar.modoJugar());
		hogar.jugar();
	}

	/**
	 * Método que cambia el estado de la mascota a Dormir.
	 * Se inicia el proceso para dormir con la mascota en el nuevo estado.
	 */
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+":				A mimir Zzzz..");
		hogar.asignarNuevoEstado(hogar.modoDormir());
		hogar.estaDormido(true);
		
		try{
			hogar.dormirMascota((double) valorDormir);
		}catch(MuertePorAburrimientoException ex){
			System.out.println(" ");
			System.out.println("			_-_-_-_-_-_-_-_-_-_-_ W A R N I N G _-_-_-_-_-_-_-_-_-_");
			System.out.println("						¡Oh no!							");
			System.out.println("		Tu mascota se aburrio por tanto dormir y termino muriendo :(");
			System.out.println("							 					");
			System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-__-__-__-_-_-_-_-_-_-_-_-_-_-_-_");
			System.out.println(" ");
			hogar.asignarNuevoEstado(hogar.modoMorir());
			hogar.estaVivo(false);
		}
	}

	/**
	 * Método que cambia el estado de la mascota a Despertar.
	 * Se inicia el proceso para despertar a la mascota en el nuevo estado.
	 */
	public void despertar(){
		if(hogar.estaDormido()){
			hogar.asignarNuevoEstado(hogar.modoDespertar());
		}else{
		System.out.println("\n"+"				Tu mascota ya esta despierta o.o");
		}
	}

}
