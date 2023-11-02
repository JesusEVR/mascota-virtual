package State;

public class ModoDespertar implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoDespertar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("Dormi muy bien, ¿Ya es hora de comer?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoComer());
	}
	public void jugar(){
		System.out.println("Dormi muy bien, ¿Ya es hora de jugar?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoJugar());
	}
	public void dormir(){
		System.out.println("Supongo que no dormí suficiente, toca dormir nuevamente");
		hogar.asignarNuevoEstado(hogar.modoDormir());

	}
	public void despertar(){
		System.out.println("Ya he despertado, ¿Que haremos hoy?");
		hogar.estaDormido(false);
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}



}