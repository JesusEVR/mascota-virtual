package State;

public class ModoComer implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoComer(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){ //aqui se alimenta y se va de compras de ser necesario
		System.out.println("Ya comi");
		
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}
	public void jugar(){
		System.out.println("¿No me ibas a alimentar antes? :(");
		
	}
	public void dormir(){
		System.out.println("¿No me ibas a alimentar antes? :(");
	}
	public void despertar(){
		System.out.println("Estoy despierto :/");
	}



}