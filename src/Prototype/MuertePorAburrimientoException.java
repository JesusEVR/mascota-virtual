package Prototype;

/**
 * Clase que crea una excepcion para la muerte de una mascota causada por dormir demasiado 
 * o alimentarlo con productos que le resulten aburridos.
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class MuertePorAburrimientoException extends Exception{
	
	/**
	 * Constructor que recibe como parámetro una cadena
         *
	 * @param mensaje
	 */
	public MuertePorAburrimientoException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Constructor por omisión
	 */
	public MuertePorAburrimientoException(){
	}

}
