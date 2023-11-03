package State;

public class ModoMorir implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoMorir(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_G A M E   O VE R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, los gusanos se alimentaran de el y no al reves");	
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");	
	}
	
	public void jugar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_G A M E   O VE R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota fallecio, no puedes jugar con el pues seria una falta de respeto");
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
		
	}
	public void dormir(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_G A M E   O VE R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota falleció, así que ya está mimido				");
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
	}
	public void despertar(){
		System.out.println(" ");
		System.out.println("	-_-_-_-_-_-_-__-_-_-_-_G A M E   O VE R _-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println(" ");
		System.out.println("	Tu mascota falleció, no puedes	despertarlo a menos que seas Dios");	
		System.out.println(" ");
		System.out.println("	_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-_-_-_-_-_-_-_-_-__-_-_-_-_-_-");
		System.out.println(" ");
	}

}