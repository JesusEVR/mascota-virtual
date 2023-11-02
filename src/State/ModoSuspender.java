package State;

public class ModoSuspender implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoSuspender(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("¡Ya quiero comer!");
		hogar.asignarNuevoEstado(hogar.modoComer());
	}
	public void jugar(){
		System.out.println("¡Estoy ansioso por jugar!");
		hogar.asignarNuevoEstado(hogar.modoJugar());
	}
	public void dormir(){
		System.out.println("A mimir Zzzz..");
		hogar.estaDormido(true);
		hogar.asignarNuevoEstado(hogar.modoDormir());
	}
	public void despertar(){
		if(hogar.estaDormido()){
			hogar.asignarNuevoEstado(hogar.modoDespertar());
		}else{
		System.out.println("Tu mascota ya esta despierta o.o");
		}
	}



}