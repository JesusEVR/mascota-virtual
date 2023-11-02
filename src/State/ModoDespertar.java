package State;

public class ModoDespertar implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoDespertar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("Dormi muy bien, ¿Ya es hora de comer?");
		hogar.asignarNuevoEstado(hogar.modoComer());
	}
	public void jugar(){
		System.out.println("Dormi muy bien, ¿Ya es hora de jugar?");
		hogar.asignarNuevoEstado(hogar.modoJugar());
	}
	public void dormir(){
		System.out.println("Supongo que no dormí suficiente, toca dormir nuevamente");
		hogar.asignarNuevoEstado(hogar.modoDormir());

	}
	public void despertar(){
		System.out.println("¡Buenos dias! ¿Que haremos hoy?");
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}



}