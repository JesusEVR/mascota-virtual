package State;
import Prototype.MuertePorNoComerException;
import Prototype.MuertePorCansancioException;

public class ModoJugar implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoJugar(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("\n"+ hogar.nombreMascota()+ ":				¿No ibamos a jugar primero?");
	}
	public void jugar(){ 
		jugarMinijuegos();
		
		try{
			hogar.jugarConMascota(-10,-10,10);
			System.out.println("			¡Tu mascota está feliz de jugar contigo!");
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
	}
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+":				¿No ibamos a jugar primero?");
		
	}
	public void despertar(){
		System.out.println("\n"+hogar.nombreMascota()+":				Estoy despierto :/");
		
	}
	
	private void jugarMinijuegos(){//Aqui va el sistema de minijuegos
		System.out.println("\n"+"				Jugando ando :)))");
		System.out.println("(Aqui se imprime el menu de minijuegos y termina el modo jugar)");
	}


}