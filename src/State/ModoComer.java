package State;
import java.util.Scanner;
import Prototype.MuertePorIntoxicacionException;
import Prototype.MuertePorAburrimientoException;
import Composite.Producto;
import Composite.Alimento;

public class ModoComer implements EstadoMascota{

	private Hogar hogar; 
	private boolean puedeComer = false;
	private Scanner sc = new Scanner(System.in);
	private boolean alimentar = false;
	
	public ModoComer(Hogar h){
		hogar = h;
	}
	
	public void alimentar(){ 
		verificarRefrigerador(); //-> verifica que el refri no este vacio
		
		if(puedeComer){
		System.out.print("Ya tienes provisiones, ¿Quieres alimentar a tu mascota? Escribe si/no : ");
			
			while(true){
				String opcionUsuario = sc.nextLine();
					if(opcionUsuario.equalsIgnoreCase("si")){ 
						alimentar=true;
						break;
					}else if(opcionUsuario.equalsIgnoreCase("no")){
						alimentar = false;
						System.out.println("\n"+"	No hay problema, pero recuerda cuidar bien a tu mascota");
						hogar.asignarNuevoEstado(hogar.modoSuspender());
						break;
					}else{ 
						System.out.print("		Por favor, elige una opción válida: ");
					}
			}
		}
		puedeComer=false;
		
		if(alimentar){ 
		boolean seguir =false;
		Producto alimento=null;
		int opcion=0;
		System.out.println("\n"+"\n A continuacion se muestran los alimentos que tienes en tu refrigerador:	");
		hogar.verRefrigerador();
			do{
			System.out.println("");
			System.out.println("		1. Elegir alimento");
			System.out.println("		2. Dar alimento a mi mascota");
			System.out.println("		3. Ver mi refrigerador");	
			System.out.println("		0. Terminar");	
			System.out.print("");
			System.out.print("Selecciona la accion que deseas realizar: ");
				while(true){
						try {
							String opcionUsuario = sc.nextLine();
							opcion =  Integer.parseInt(opcionUsuario);
							if(opcion >-1 && opcion < 4){ 
								break;
							}else{ System.out.print("		Por favor, elige una opcion valida: ");
							}
						}catch (NumberFormatException ex){
							System.out.print("		Por favor, elige una opcion valida: ");
						}
				}

				switch(opcion){
					case 0:
						if(alimento!=null){
							System.out.println("\n"+"	Elegiste un alimento, debes darselo a tu mascota antes de terminar");
							System.out.println("		o tu mascota podria ponerse triste :(");
							seguir = true;
						}else{
						hogar.asignarNuevoEstado(hogar.modoSuspender());
						seguir=false;
						}
					break;
					case 1:
						if(alimento!=null){
							System.out.println("\n"+"	Ya elegiste un alimento, solo hace falta que se lo des a tu mascota");
							seguir = true;
							break;
						}
							
						if(hogar.refrigeradorVacio()){
							System.out.println("\n"+"	Te has quedado sin comida, vuelve mas tarde para comprar algo");
							puedeComer = false;
							seguir = false;
							hogar.asignarNuevoEstado(hogar.modoSuspender());
						}else {
							System.out.print("\n	--> Escribe el codigo del alimento: ");
							String codigo = sc.nextLine();
							alimento = hogar.buscarEnRefrigerador(codigo);

							if(alimento==null ){
								System.out.println("\n"+"	Ese alimento no existe en tu refrigerador, elige otro");
							}
							seguir=true;
						}
						
					break;
					case 2:
						if(alimento==null) {
							System.out.println("\n"+"	¡Aun no eliges un alimento de tu refrigerador!");
							seguir =true;
						}else{
							try{
								System.out.println("\n"+"	Tu mascota esta comiendo "+ alimento.nombre() +" muy alegremente :3");
								hogar.alimentarMascota(alimento);
								
								seguir=true;
								
							}catch(MuertePorIntoxicacionException e){
								System.out.println(" ");
								System.out.println("			_-_-__-_-_-_-_-_-_-_-_W A R N I N G_-__-_-_-_-_-_-_-_-_");
								System.out.println("						¡Oh no!							");
								System.out.println("		A tu mascota le cayo mal el alimento " +alimento.nombre()+ " y fallecio por intoxicacion");
								System.out.println("							 					");
								System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-__-_-_-_-_-_-_-_");
								System.out.println(" ");
								hogar.asignarNuevoEstado(hogar.modoMorir());
								hogar.estaVivo(false);
								seguir=false;
							}catch(MuertePorAburrimientoException ex){
								System.out.println(" ");
								System.out.println("			_-_-__-_-_-_-_-_-_-_-_W A R N I N G_-__-_-_-_-_-_-_-_-_");
								System.out.println("						¡Oh no!							");
								System.out.println("			Tu mascota por comer tanto se aburrio y fallecio");
								System.out.println("							 					");
								System.out.println("			_-_-_-_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-__-_-_-_-_-_-_-_");
								System.out.println(" ");
								hogar.asignarNuevoEstado(hogar.modoMorir());
								hogar.estaVivo(false);
								seguir=false;
							}
							alimento=null;
						}
					break;
					case 3:
						hogar.verRefrigerador();
						break;
				}//end switch

			}while(seguir); //end while
		
		}//enf if
		
		alimentar =false;
		
	}
	
	
	
	private void verificarRefrigerador(){
		if(hogar.refrigeradorVacio()){
			System.out.println("	");
			System.out.println("	¡Tu refrigerador esta vacio! No tienes comida para tu mascota");
			System.out.println("	");
			System.out.print("¿Quieres comprar algo en el minisuper? Escribe si/no: ");
			
			
			while(true){	
					String opcionUsuario = sc.nextLine();
					if(opcionUsuario.equalsIgnoreCase("si")){ 
						hogar.irAlMinisuper(); 
						if(hogar.pudoComprar()){
							puedeComer=true;
						}else{
						 hogar.asignarNuevoEstado(hogar.modoSuspender());
						}
						break;
					}else if(opcionUsuario.equalsIgnoreCase("no")){
						System.out.println("\n"+"	No hay problema, pero recuerda cuidar bien a tu mascota");
						hogar.asignarNuevoEstado(hogar.modoSuspender());
						break;
					}else{ 
						System.out.print("		Por favor, elige una opción válida: ");
					}
			}
		}else{
			puedeComer = true;
		}
		hogar.pudoComprar(false);
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
