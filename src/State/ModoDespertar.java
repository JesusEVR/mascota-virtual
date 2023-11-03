package State;

import Prototype.MuertePorAburrimientoException;

public class ModoDespertar implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoDespertar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("\n"+"				Dormi muy bien, ¿Ya es hora de comer?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoComer());
		hogar.alimentar();
	}
	public void jugar(){
		System.out.println("\n"+"				Dormi muy bien, ¿Ya es hora de jugar?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoJugar());
		hogar.jugar();
	}
	public void dormir(){
		System.out.println("\n"+"				Supongo que no dormí suficiente, toca dormir nuevamente");
		hogar.asignarNuevoEstado(hogar.modoDormir());
		try{
			hogar.dormirMascota(10);
			
		}catch(MuertePorAburrimientoException ex){
			System.out.println(" ");
			System.out.println("			_-_-__-_-_-_-_-_-_-_-_W A R N I N G_-__-_-_-_-_-_-_-_-_");
			System.out.println("						¡Oh no!							");
			System.out.println("		Tu mascota se aburrio por tanto dormir y termino muriendo :(");
			System.out.println("							 					");
			System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-__-_-_-_-_-_-_-_");
			System.out.println(" ");
			hogar.asignarNuevoEstado(hogar.modoMorir());
			hogar.estaVivo(false);
		}

	}
	public void despertar(){
		System.out.println("\n"+"				¡Ya he despertado!, ¿Que haremos hoy?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}



}