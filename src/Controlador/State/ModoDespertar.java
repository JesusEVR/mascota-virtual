package Controlador.State;

import Modelo.Prototype.MuertePorAburrimientoException;

/**
 * Clase que define el modo despertar de la mascota. Bastante parecido al modo Suspender.
 *
 */
public class ModoDespertar implements EstadoMascota{
	/**
	 * Objeto de tipo hogar que contiene a la mascota que tendrá diversos estados
	 */
	private Hogar hogar; 

	/**
	 * Constructor por parámetros.
         * @param h El objeto hogar que inicializa el atributo de clase.
	 *
	 */
	public ModoDespertar(Hogar h){
		hogar = h;
	}
	
	/**
	 * Método que cambia el estado de la mascota a Comer.
	 * Se inicia el proceso para alimentar a la mascota en el nuevo estado.
	 */
	public void alimentar(){
		System.out.println("\n"+hogar.nombreMascota()+":				Dormi muy bien. ¿Ya es hora de comer?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoComer());
		hogar.alimentar();
	}

	/**
	 * Método que cambia el estado de la mascota a Jugar.
	 * Se inicia el proceso para jugar con la mascota en el nuevo estado.
	 */
	public void jugar(){
		System.out.println("\n"+hogar.nombreMascota()+":				Dormi muy bien. ¿Ya es hora de jugar?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoJugar());
		hogar.jugar();
	}

	/**
	 * Método que cambia el estado de la mascota a Dormir.
	 * Se inicia el proceso para dormir con la mascota en el nuevo estado.
	 */
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+"				Supongo que no dormi suficiente, toca dormir nuevamente");
		hogar.asignarNuevoEstado(hogar.modoDormir());
		try{
			hogar.dormirMascota(10);
			
		}catch(MuertePorAburrimientoException ex){
			System.out.println(" ");
			System.out.println("			_-_-_-_-_-_-_-_-_-_-_ W A R N I N G _-_-_-_-_-_-_-_-_-_");
			System.out.println("						¡Oh no!							");
			System.out.println("		Tu mascota se aburrio por tanto dormir y termino muriendo :(");
			System.out.println("							 					");
			System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-__-_-__-_-_-_-_-__-_-_-_-_-_-_-_");
			System.out.println(" ");
			hogar.asignarNuevoEstado(hogar.modoMorir());
			hogar.estaVivo(false);
		}

	}
	
	/**
	 * Método que imprime un mensaje indicando que la mascota virtual no puede despertar de nuevo.
	 */
	public void despertar(){
		System.out.println("\n"+hogar.nombreMascota()+":				¡Ya he despertado! ¿Que haremos hoy?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}

}
