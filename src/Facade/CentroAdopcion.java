package Facade;

import State.Hogar;
import Prototype.MascotaVirtual;
import Prototype.CrearMascota;

import java.util.Scanner;
public class CentroAdopcion{
	
	private MascotaVirtual mascota;
	private boolean continuar;
	private Hogar hogar;
	private Scanner sc = new Scanner(System.in);
	private String nivel="";
	
	public CentroAdopcion(){
		continuar=true;
		hogar = new Hogar();
	}
	
	public void darBienvenida(){
		System.out.println("Bienvenido"); //Aqui se da contexto de la problematica
	}
	
	public void elegirNivel(){
		int opcion=0;
		System.out.println("----- N I V E L    D E   J U E G O ------"); 
		System.out.println("	1. Facil"); 
		System.out.println("	2. Dificil");
		System.out.println("	0. Abandonar juego");
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
					continuar=false;
					System.exit(0);	
					break;
				case 1:
					nivel = "facil";
					break;
				case 2:
					nivel = "dificil";
					break;
			}
		System.out.println("-----------------------------------------"); 
		
	}

	public void adoptar(){
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
				
					if(mascota!=null){ 
						
						mascotaExiste=true;
					}
			
			}
		System.out.println("Has adoptado a " +mascota.nombre()+ ", te deseamos suerte en tu misión");
		
	}
	
	public void convivir(){
		if(continuar){
		boolean seguir=false;
		int opcion=0;
		
		do{
		System.out.println("	------------ M E N U -----------");
		System.out.println("		1. Jugar con mi mascota");
		System.out.println("		2. Alimentar a mi mascota");
		System.out.println("		3. Darle las buenas noches"); 
		System.out.println("		4. Darle los buenos dias"); //despertar 
		System.out.println("		5. Ver mi mascota"); 
		System.out.println("		0. Salir de la app");
		System.out.println("	--------------------------------");

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
						System.exit(0);	
						break;
					case 1:
						System.out.print("");
						hogar.jugar();
						seguir = true;
						break;
					case 2:
						System.out.print("");
						hogar.alimentar();
						seguir = true;

						break;
					case 3:
						System.out.print("");
						hogar.dormir();
						seguir = true;
						break;
					case 4:
						System.out.print("");
						hogar.despertar();
						seguir = true;
						break;
					case 5:
						System.out.print("");
						mascota.informacion();
						seguir = true;
						break;
				}

				if(!hogar.estaVivo()){
					seguir = false;
				}
			
			}while(seguir);
		}
	}
	
	
	public void darFelicitacion(){ 
		if(!continuar){
		
			System.out.println("Lástima que no adoptaste:( ");
		
		}else if(continuar && hogar.estaVivo()){
			System.out.println("Felicidades, has cumplido tu mision ");
		
		}else if(continuar && !hogar.estaVivo()){ //(El usuario acepta la mision pero la mascota muere)
			System.out.println("¿Como sucedió esto, tenias un solo deber >:/");
		}
	
		
	}
}