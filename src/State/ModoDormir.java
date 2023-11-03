package State;

public class ModoDormir implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoDormir(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("\n"+"				Tu mascota está durmiendo, si lo quieres alimentar primero debes despertarlo");
	}
	public void jugar(){
		System.out.println("\n"+"				Tu mascota está durmiendo, si quieres jugar con él primero debes despertarlo");
	}
	public void dormir(){
		System.out.println("\n"+"				Tu mascota ya está durmiendo :/");
		
	}
	public void despertar(){
		System.out.println("\n"+"				Tu mascota te desea los buenos días, ¿Que harán hoy?");
		hogar.asignarNuevoEstado(hogar.modoDespertar());
		
	}



}