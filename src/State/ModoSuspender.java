package State;

import Prototype.MuertePorAburrimientoException;

public class ModoSuspender implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoSuspender(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("\n"+hogar.nombreMascota()+":				¡Ya quiero comer!");
		hogar.asignarNuevoEstado(hogar.modoComer());
		hogar.alimentar();
		
	}
	public void jugar(){
		System.out.println("\n"+hogar.nombreMascota()+":				¡Estoy ansioso por jugar!");
		hogar.asignarNuevoEstado(hogar.modoJugar());
		hogar.jugar();
	}
	public void dormir(){
		System.out.println("\n"+hogar.nombreMascota()+":				A mimir Zzzz..");
		hogar.asignarNuevoEstado(hogar.modoDormir());
		hogar.estaDormido(true);
		
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
		if(hogar.estaDormido()){
			hogar.asignarNuevoEstado(hogar.modoDespertar());
		}else{
		System.out.println("\n"+"				Tu mascota ya esta despierta o.o");
		}
	}



}