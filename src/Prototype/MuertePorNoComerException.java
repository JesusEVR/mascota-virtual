package Prototype;

/**
 * Clase que crea una excepcion para la muerte de una mascota causada por jugar demasiado y no darle alimento
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 */
public class MuertePorNoComerException extends Exception{
	
	/**
	 * Constructor que recibe como parámetro una cadena
         *
	 * @param mensaje
	 */
	public MuertePorNoComerException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Constructor por omisión
	 */
	public MuertePorNoComerException(){
	}

}
