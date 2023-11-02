package State;

public class ModoDormir implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoDormir(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("Tu mascota está durmiendo, si lo quieres alimentar primero debes despertarlo");
	}
	public void jugar(){
		System.out.println("Tu mascota está durmiendo, si quieres jugar con él primero debes despertarlo");
	}
	public void dormir(){
		System.out.println("Tu mascota ya está durmiendo :/");
		
	}
	public void despertar(){ //aqui va un try catch para el metodo mascota.dormir(); si se lanza la excepcion cambia a modoMorir
		System.out.println("Tu mascota te desea los buenos días, ¿Que harán hoy?");
		hogar.asignarNuevoEstado(hogar.modoDespertar());
		
	}



}