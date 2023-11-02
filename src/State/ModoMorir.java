package State;

public class ModoMorir implements EstadoMascota{

	private Hogar hogar; 
	
	public ModoMorir(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){
		System.out.println("Tu mascota falleció, los gusanos se alimentarán de él y no al revés");
	}
	public void jugar(){
		System.out.println("Tu mascota falleció, no puedes jugar con el pues sería una falta de respeto");
		
	}
	public void dormir(){
		System.out.println("Tu mascota falleció, así que ya está mimido");
		
	}
	public void despertar(){
		System.out.println("Tu mascota falleció, no puedes despertarlo a menos que seas Dios");	
	}

}