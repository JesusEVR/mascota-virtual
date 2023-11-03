package Facade;

import State.Hogar;
import Prototype.MascotaVirtual;
import Prototype.CrearMascota;

import java.util.Scanner;
public class CentroAdopcion{
	
	private MascotaVirtual mascota;
	private boolean continuar=false;
	private Scanner sc = new Scanner(System.in);
	private String nivel="";
	private  Hogar hogar;
	
	public CentroAdopcion(){
		
	}
	
	public void darBienvenida(){
		System.out.println("			¡Bienvenido a (nombre del juego por definir) ");
		System.out.println(" ");
		System.out.println("	En este juego, tu mision es cuidar de la mascota que elijas adoptar.");
		System.out.println("	Puedes jugar con el, alimentarlo, dormirlo y despertarlo.");
		System.out.println("	Para alimentarlo debes elegir un alimento de tu refrigerador.");
		System.out.println("	Si se acaba su comida, puedes comprar mas en la tienda.");
		System.out.println("	Si no tienes monedas Pejecoins, puedes conseguir mas jugando.");
		System.out.println("	Sencillo, ¿no? Lo interesante es averiguar cuantos dias puedes mantenerlo vivo.");
		System.out.println(" ");
		System.out.println("				¿Aceptas la mision? ");
		System.out.println(" ");
	}
	
	public void elegirNivel(){
		int opcion=0;
		System.out.println("		----- N I V E L    D E   J U E G O ------"); 
		System.out.println("			1. Facil"); 
		System.out.println("			2. Dificil");
		System.out.println("			0. Abandonar mision");
		System.out.println(" ");
		System.out.print("Antes de comenzar, selecciona el nivel de dificultad del juego: ");
			while(true){
				try {
					String opcionUsuario = sc.nextLine();
					opcion =  Integer.parseInt(opcionUsuario);
					if(opcion >-1 && opcion < 3){ 
						break;
					}else{ System.out.print("		Por favor, elige una opción válida: ");}
				}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opción válida: "); }
			}
		
			switch(opcion){
				case 0:
					continuar = false;
					break;
				case 1:
					continuar = true;
					nivel = "facil";
					break;
				case 2:
					continuar = true;
					nivel = "dificil";
					break;
			}
		if(continuar){
			System.out.println("	");
			System.out.println("¡Excelente! Procederemos con la adopcion de tu mascota");
		}
		
	}

	public void adoptar(){
		if(continuar){
			
		System.out.println(" ");
		System.out.println("-----------------A D O P C I O N------------------------"); 
		boolean mascotaExiste=false;
		CrearMascota creacion = new CrearMascota();
		creacion.verMascotas();
		
		while(!mascotaExiste){
			System.out.print("Escribe el nombre de la mascota que deseas adoptar: ");
			String opcionUsuario = sc.nextLine();
			switch(nivel){
			case "facil": 
				mascota = creacion.obtenerMascota(opcionUsuario,"facil");
				break;
			case "dificil":
				mascota = creacion.obtenerMascota(opcionUsuario,"dificil");
				break;
			}
				
			if(mascota!=null) mascotaExiste=true;
					
		}
		System.out.println("\n"+ "				Has adoptado a " +mascota.nombre()+ ", te deseamos suerte en tu mision"+"\n");
		System.out.println("	");
		
		}
	}
	
	public void convivir(){
		if(continuar){
			
		hogar = new Hogar(mascota);
		boolean seguir=false;
		int opcion=0;
		System.out.println("********* (Aqui va el nombre del juego) *********");
	
		do{
		System.out.println(" "); 
		System.out.println("			*-*-*-*-* M E N U *-*-*-*-*");
		System.out.println("			1. Jugar con mi mascota");
		System.out.println("			2. Alimentar a mi mascota");
		System.out.println("			3. Darle las buenas noches"); 
		System.out.println("			4. Darle los buenos dias");
		System.out.println("			5. Ver mi mascota"); 
		System.out.println("			0. Salir de la app");
		System.out.println("			*-*-*-*-*-*-*-*-*-*-*-*-*-*");

		System.out.print("Selecciona la opción que deseas ejecutar: ");
	
			while(true){
				try {
					String opcionUsuario = sc.nextLine();
					opcion =  Integer.parseInt(opcionUsuario);
					if(opcion >-1 && opcion < 6){ 
						break;
					}else{ System.out.print("		Por favor, elige una opción válida: ");}
				}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opción válida: ");
				}
			}
			
				switch(opcion){
					case 0:
						seguir = false;
						break;
					case 1:
						System.out.println("");
						hogar.jugar();
						seguir = true;
						break;
					case 2:
						System.out.println("");
						hogar.alimentar();
						seguir = true;

						break;
					case 3:
						System.out.println("");
						hogar.dormir();
						seguir = true;
						break;
					case 4:
						System.out.println("");
						hogar.despertar();
						seguir = true;
						break;
					case 5:
						System.out.println("");
						hogar.infoMascota();
						seguir = true;
						break;
				}

				/*if(!hogar.estaVivo()){
					seguir = false;
				}*/
			
			}while(seguir);
		}
	}
	
	
	public void darFelicitacion(){ 
		if(!continuar){
			System.out.println(" ");
			System.out.println("			Lastima que decidiste rechazar la mision :( ");
			System.out.println("		Todas las mascotas fallecieron de tristeza por tu culpa u.u");
		}else if(hogar.estaVivo()){
			System.out.println(" ");
			System.out.println("		¡Felicidades, cumpliste tu mision. Tu mascota sobrevivio (aqui va la cantidad de dias) ");
		
		}else if(!hogar.estaVivo()){ 
			System.out.println(" ");
			System.out.println("					¡Tu mascota fallecio!");
			System.out.println("			¿Como sucedio esto? Tenias un solo deber >:/");
		}
	
		
	}
}