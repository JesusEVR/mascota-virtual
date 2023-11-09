package Controlador.State;

import Minijuegos.*;
import Modelo.Prototype.MuertePorNoComerException;
import Modelo.Prototype.MuertePorCansancioException;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase que define el modo jugar de la mascota.
 *
 */
public class ModoJugar implements EstadoMascota{
	/**
	 * Objeto de tipo hogar que contiene a la mascota que tendrá diversos estados
	 */
	private Hogar hogar;
	/**
	 * Objeto de tipo scanner para que el usuario introduzca respuestas.
	 */
	private Scanner sc = new Scanner(System.in);
	/**
	 * Valor booleano que indica el jugador decicdió jugar a los miniuegos para conseguir Pejecoins.
	 */
	private boolean decidioJugar = false;
	/**
	 * Cantidad de monedas (Pejecoins) que el usuario gana por jugar un minijuego.
	 */
	private double monto = 0;
	/**
	* Numero random entre 10 y 20
	*/
	private double valorHambre = 0;
	/**
	* Numero random entre 10 y 20
	*/
	private double valorEnergia = 0;
	/**
	* Numero random entre 5 y 15
	*/
	private double valorFelicidad = 0;


	/**
	 * Constructor por parámetros.
         * @param h El objeto hogar que inicializa el atributo de clase.
	 *
	 */
	public ModoJugar(Hogar h){
		hogar = h;
	}
	
	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede comer en este estado.
	 */
	public void alimentar(){
		System.out.println("\n"+ hogar.nombreMascota()+ ":				¿No ibamos a jugar primero?");
	}

	/**
	 * Método que despliega el proceso de los minijuegos, incluyendo los casos donde se intente farmear monedas.
	 */
	public void jugar(){ 
		jugarMinijuegos();
		if(decidioJugar){
			try{
				hogar.jugarConMascota(valorHambre, valorEnergia, valorFelicidad);
				hogar.depositar(monto);
				System.out.println("");
				System.out.println("	¡Que bien! ¡Tu mascota esta feliz de jugar contigo! :D");
				hogar.asignarNuevoEstado(hogar.modoSuspender());
			}catch(MuertePorNoComerException e){
				System.out.println(" ");
				System.out.println("			_-_-__-_-_-_-_-_-_-_-_W A R N I N G_-__-_-_-_-_-_-_-_-_");
				System.out.println("						¡Oh no!							");
				System.out.println("		A tu mascota le dio hambre de tanto jugar y fallecio por falta de alimentos");
				System.out.println("							 					");
				System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-__-_-_-_-_-_-_-_");
				System.out.println(" ");
				hogar.asignarNuevoEstado(hogar.modoMorir());
				hogar.estaVivo(false);
			}catch(MuertePorCansancioException ex){
				System.out.println(" ");
				System.out.println("			_-_-__-_-_-_-_-_-_-_-_W A R N I N G_-__-_-_-_-_-_-_-_-_");
				System.out.println("						¡Oh no!							");
				System.out.println("		Olvidaste dejar dormir a tu mascota por tanto jugar que fallecio por cansancio");
				System.out.println("							 					");
				System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-__-_-_-_-_-_-_-_");
				System.out.println(" ");
				hogar.asignarNuevoEstado(hogar.modoMorir());
				hogar.estaVivo(false);					
			}
		}else{
			System.out.println("\n"+"		Evita ilusionar a tu mascota asi por favor, no jugaste con el :( ");
			hogar.asignarNuevoEstado(hogar.modoSuspender());
		}
	}
	
	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede dormir en este estado.
	 */
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+":				¿No ibamos a jugar primero?");
		
	}

	/**
	 * Imprime una mensaje donde se dice de forma implicita que la mascota no puede despertar en este estado.
	 */
	public void despertar(){
		System.out.println("\n"+hogar.nombreMascota()+":				Estoy despierto :/");
		
	}

	/**
	 * Método auxiliar que despliega el menú de minijuegos.
	 */
	private void jugarMinijuegos(){//Aqui va el sistema de minijuegos
		int opcion=0;
		System.out.println("");
		System.out.println("			--------------- MINIJUEGOS -------------");
		System.out.println("");
		System.out.println("			1. Tortuga Mecanica");
		System.out.println("			2. Eventos");
		System.out.println("			0.Salir");
		System.out.println("			----------------------------------------");
		System.out.println("");
		System.out.print("Elige una opcion: ");
		
		while(true){
			try {
				String opcionUsuario = sc.nextLine();
				opcion =  Integer.parseInt(opcionUsuario);
				if(opcion >-1 && opcion < 3){ 
				break;
				}else{ System.out.print("		Por favor, elige una opcion valida: ");}
			}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opcion valida: "); }
		}
		
		
		switch(opcion){
			case 0:
				decidioJugar = false;
				break;
			case 1:
				Tablero t = new Tablero();
				t.jugarTortugaMecanica();
				monto = t.monedas();
				int hambreRandom = (int) (Math.random() * ((20 - 10) +1)) + 10;
				valorHambre = (double) -hambreRandom;
				int energiaRandom = (int) (Math.random() * ((20 - 10) +1)) + 10;
				valorEnergia = (double) -energiaRandom;
				int felicidadRandom = (int) (Math.random() * ((15 - 5) +1)) + 5;
				valorFelicidad = (double) -felicidadRandom;
				decidioJugar = true;
				break;
			case 2:
				MenuEventos m = new MenuEventos();
				monto = m.obtenerDinero();
				valorHambre = m.modificaHambre();
				valorEnergia = m.modificaEnergia();
				valorFelicidad = m.modificaFelicidad();
				decidioJugar = m.jugado();
				break;
		}
		
	}



}
