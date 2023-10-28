package Prototype;

/**
* Clase que crea una excepcion para la muerte de una mascota causada por jugar sin dejarlo dormir suficiente
* 
* @author paolasanv
* @author Supr-Lilito
* @author JesusEVR
* @version octubre 2023
*
*/

public class MuertePorCansancioException extends Exception{
	
	/**
	* Constructor que recibe como parámetro una cadena
        *
	* @param mensaje
	*/
	public MuertePorCansancioException(String mensaje){
		super(mensaje);
	}
	
	/**
	* Constructor por omisión
	*/
	public MuertePorCansancioException(){
	}

}
