package Prototype;

/**
 * Clase que crea una excepcion para la muerte de una mascota causada darle alimentos que le resultaron toxicos
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class MuertePorIntoxicacionException extends Exception{
	
	/**
	 * Constructor que recibe como parámetro una cadena
         *
	 * @param mensaje
	 */
	public MuertePorIntoxicacionException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Constructor por omisión
	 */
	public MuertePorIntoxicacionException(){
	}

}
