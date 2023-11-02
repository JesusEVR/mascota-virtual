public class CentroAdopcion{
	
	private MascotaVirtual mascota;
	private boolean continuar;
	
	public CentroAdopcion(){
		continuar=true;
	}
	
	public void darBienvenida(){
		System.out.println("Bienvenido"); //Aqui se da contexto de la problematica
	}
	
	public void adoptar(){
		
		System.out.println("Aqui se elige a la mascota");
		
		System.out.println("¿Quieres adoptar una mascota? Si/No"); //En caso de NO aceptar -> continuar=false;
		//mascota = mascota elegida
	}
	
	public void convivir(){
		//if(continuar){
		
		System.out.println("Aqui se usa state");

		System.out.println("1. Jugar");
		System.out.println("2. Alimentar");
		System.out.println("3. Dar las buenas noches"); 
		System.out.println("4. Dar los buenos dias"); //despertar 
		System.out.println("5. Ver mi mascota"); 
		System.out.println("0. Salir");
		
		//}
	}
	
	
	public void darFelicitacion(){ //Si la mascota no muere, lo felicita
		//if(!continuar){
		
		//System.out.println("Lamentamos la decision que tomaste ");
		
		//}else if(continuar && mascota esta viva){
		
		//System.out.println("Felicidades, has cumplido tu mision ");
		
		//}else{ (El usuario acepta la mision pero la mascota muere)
		//System.out.println("¿Como sucedió esto, tenias un solo deber >:/");
		//}
	
		
	}
}