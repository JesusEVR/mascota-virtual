package State;

public class ModoComer implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoComer(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){ //aqui se alimenta y se va de compras de ser necesario
		System.out.println("(Aqui se verifica si el refrigerador esta vacio, de ser asi se va al minisuper(opcional)");
		System.out.println("o se le alimenta con lo que tiene y termina el modo comer)");
		
		hogar.asignarNuevoEstado(hogar.modoSuspender());
	}
	public void jugar(){
		System.out.println("\n"+"				¿No me ibas a alimentar antes? :(");
		
	}
	public void dormir(){
		System.out.println("\n"+"				¿No me ibas a alimentar antes? :(");
	}
	public void despertar(){
		System.out.println("\n"+"				Estoy despierto :/");
	}



}