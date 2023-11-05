package State;

import Minijuegos.Tablero;
import Prototype.MuertePorNoComerException;
import Prototype.MuertePorCansancioException;
import java.util.Scanner;

public class ModoJugar implements EstadoMascota{

	private Hogar hogar; 
	private Scanner sc = new Scanner(System.in);
	private boolean decidioJugar=false;
	private double monto=0;
	
	public ModoJugar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("\n"+ hogar.nombreMascota()+ ":				¿No ibamos a jugar primero?");
	}
	public void jugar(){ 
		jugarMinijuegos();
		if(decidioJugar){
			try{
				hogar.jugarConMascota(-15,-20,10);
				hogar.depositar(monto);
				System.out.println("");
				System.out.println("	¡Que bien! ¡Tu mascota está feliz de jugar contigo! :D");
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
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+":				¿No ibamos a jugar primero?");
		
	}
	public void despertar(){
		System.out.println("\n"+hogar.nombreMascota()+":				Estoy despierto :/");
		
	}
	
	private void jugarMinijuegos(){//Aqui va el sistema de minijuegos
		int opcion=0;
		System.out.println("");
		System.out.println("			----------------MINIJUEGOS--------------");
		System.out.println("");
		System.out.println("			1. Tortuga Mecanica");
		System.out.println("			2. Apuestas");
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
				}else{ System.out.print("		Por favor, elige una opción válida: ");}
			}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opción válida: "); }
		}
		
		switch(opcion){
			case 0:
				decidioJugar = false;
				break;
			case 1:
				Tablero t = new Tablero();
				t.jugarTortugaMecanica();
				decidioJugar = true;
				monto = t.monedas();
				break;
			case 2:
				System.out.println("	Opcion por el momento inhabilitada");
				decidioJugar = true;
				monto = 4; //temporal
				break;
		}
		
	}


}