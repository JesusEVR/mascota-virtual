package Facade;

import State.Hogar;
import Prototype.MascotaVirtual;
import Prototype.CrearMascota;

import java.util.Scanner;

/**
 * Clase fundamental de Facade. Divide el proceso principal del juego en 5 pasos / métodos.
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class CentroAdopcion{
	/**
	 * Mascota virtual vital en el juego.
	 */
	private MascotaVirtual mascota;
	/**
	 * Booleano auxiliar en los bucles del juego.
	 */
	private boolean continuar = false;
	/**
	 * Objeto de tipo Scanner que sirve para que el usuario pueda ingresar respuestas.
	 */
	private Scanner sc = new Scanner(System.in);
	/**
	 * Cadena auxiliar para cuando se elija el nivel de dificultad del juego.
	 */
	private String nivel = "";
	/**
	 * Objeto hogar que es pieza clave para diversas funciones de la mascota.
	 */
	private  Hogar hogar;

	/**
	 * Constructor por omision
	 */
	public CentroAdopcion(){
	}

	/**
	 * Método que saluda al jugador y lo pone en contexto.
	 */
	public void darBienvenida(){
		System.out.println("			¡Bienvenido a Eso Brad Pets! ");
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

	/**
	 * Método que le permite al jugador elegir la dificultad del juego.
	 */
	public void elegirNivel(){
		int opcion=0;
		System.out.println("		----- N I V E L    D E   J U E G O -----"); 
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
					}else{ System.out.print("		Por favor, elige una opcion valida: ");}
				}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opcion valida: "); }
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

	/**
	 * Método que permite al jugador elegir cuál mascota desea cuidar.
	 */
	public void adoptar(){
		if(continuar){
			
		System.out.println(" ");
		System.out.println("----------------- A D O P C I O N ------------------------"); 
		boolean mascotaExiste = false;
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
				
			if(mascota!=null) mascotaExiste = true;
					
		}
		System.out.println("\n"+ "				Has adoptado a " +mascota.nombre()+ ", te deseamos suerte en tu mision"+"\n");
		System.out.println("	");
		
		}
	}

	/**
	 * Método que desliega el menú principal con las acciones que el jugador puede hacer con la mascota.
	 */
	public void convivir(){
		if(continuar){
			
		hogar = new Hogar(mascota);
		boolean seguir = false;
		int opcion = 0;
		System.out.println("********* E S O    B R A D    P E T S *********");
	
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

		System.out.print("Selecciona la opcion que deseas ejecutar: ");
	
			while(true){
				try {
					String opcionUsuario = sc.nextLine();
					opcion =  Integer.parseInt(opcionUsuario);
					if(opcion >-1 && opcion < 6){ 
						break;
					}else{ System.out.print("		Por favor, elige una opcion valida: ");}
				}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opcion valida: ");
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
	
	/**
	 * Método que da un mensaje de despedida al jugador, dependiendo del desenlace de su aventura.
	 */
	public void darFelicitacion(){ 
		if(!continuar){
			System.out.println(" ");
			System.out.println("			Lastima que decidiste rechazar la mision :( ");
			System.out.println("		Todas las mascotas fallecieron de tristeza por tu culpa u.u");
		}else if(hogar.estaVivo()){
			System.out.println(" ");
			System.out.println("		¡Felicidades!, cumpliste tu mision. Tu mascota sobrevivio " +hogar.diasVivo()+" dias" );
		
		}else if(!hogar.estaVivo()){ 
			System.out.println(" ");
			System.out.println("					¡Tu mascota fallecio!");
			System.out.println("			¿Como sucedio esto? Tenias un solo deber >:/");
		}
	
		
	}
}
