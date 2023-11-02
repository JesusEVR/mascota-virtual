package State;

public class ModoJugar implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoJugar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("¿No ibamos a jugar primero?");
	}
	public void jugar(){ 
		jugarMinijuegos();
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}
	public void dormir(){
		System.out.println("¿No ibamos a jugar primero?");
		
	}
	public void despertar(){
		System.out.println("Estoy despierto :/");
		
	}
	
	private void jugarMinijuegos(){//Aqui va el sistema de minijuegos
		System.out.println("Jugando ando :)))");
		System.out.println("(Aqui se imprime el menu de minijuegos y termina el modo jugar)");
	}



}