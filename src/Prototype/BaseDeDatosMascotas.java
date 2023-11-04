package Prototype;

import java.util.Hashtable;

/**
 * Clase que define una base de datos donde se guardan las mascotas virtuales disponibles.
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class BaseDeDatosMascotas{
        /*
	 * Hashtable donde se guardan las 3 mascotas virtuales: Ugandiano, Floppa y Cherk
	 */
	private Hashtable<String , MascotaVirtual> mascotas = new Hashtable<>(); 

	/**
	 * Constrcutor por omision de la Base de Datos de Mascotas.
         * Crea a las tres mascotas que serán almacenadas.
	 */
	public BaseDeDatosMascotas(){
		String ugandianoPic =
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⣶⣦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡝⠻⣿⣿⣿⣿⣿⣿⣿⡯⠟⢿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠿⠀⠛⠉⠉⠙⠛⠹⠿⠿⠿⠿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⣤⣤⣤⣄⡀⠀⠀⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣄⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣷⣄⡀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠉⠁⠀⢹⣿⣿⣿⣿⣿⣿⣶⣤⣤⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠉⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣦⡀⠉⠛⠻⠿⠿⠟⠛⠉⣡⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣦⣄⣀⣀⣀⣠⣴⣾⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⣯⠙⠻⠿⣿⣿⣿⡿⠿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
		
		 String cherkPic =
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣦⣠⣾⣿⣿⣿⣦⣠⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣿⣿⣿⣿⣿⣿⣧⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⢀⠴⠃⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⡘⠣⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⣀⡼⣇⠀⢀⡠⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠧⡀⠀⢨⠷⣄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⢀⡄⠛⠻⣗⡤⠛⠁⠀⢸⣿⣿⣿⣿⡟⠙⠘⢿⣿⣿⡟⠀⠈⠙⢧⣚⡿⠓⢤⡀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⣦⠀⠀⠀⠀⠋⠀⠀⠀⠀⢐⠉⠉⠀⠀⠀⠀⠀⠀⠀⠉⡅⠀⠀⠀⠀⠉⠃⠀⠀⠀⣰⠀⠀⠀⠀\n" +
            "⠀⠀⣠⣾⣿⡷⠄⠀⠀⠀⠀⠀⠀⠀⢈⣷⣤⡀⠀⠀⠀⠀⠀⢀⣰⡇⠀⠀⠀⠀⠀⠀⠀⠰⢾⣿⣷⣤⡀⠀\n" +
            "⠰⠾⠛⠉⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣶⣶⣤⣶⣶⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⠈⠙⠻⠆\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡈⠉⠙⠛⠛⠛⠛⠛⠉⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣶⣶⠶⠴⠶⠴⣶⣶⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡿⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⠀⠀⠀⠀⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⠟⠀⠀⠀⠀⠛⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n";
		 String floppaPic =
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣤⡀⠀⠀⠀⠀⠀⠀⡠⠞⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣯⡉⢢⡀⠀⠀⠀⡜⠁⡄⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⣼⣷⡖⣶⢿⣗⣶⡇⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣿⣿⣿⣧⣿⡮⣿⡿⡇⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣯⣉⣷⣽⣠⣇⣴⡿⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⢻⣏⠛⡟⢹⡟⠁⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣷⣤⣏⣉⣀⣽⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⡿⠵⡀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⢿⡃⠀⠀⠀⠀⢺⠂⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣴⣯⠛⠁⣘⣿⣿⣿⣿⣿⣿⣽⡆⠿⢀⡀⠀⢀⡿⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⡿⢺⠃⣾⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⢨⠉⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣙⠀⠀⠘⠿⡿⠟⠛⢿⣿⡟⠂⠀⠀⢀⡀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠐⠶⠙⣗⠀⠀⠀⠀⢨⣇⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠀⠀⠀⠀⠐⠁⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣟⣿⡃⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣀⢀⡀⠰⡇⠀⠀⠀⠀⠀\n" +
            "⠀⠀⢀⣀⣤⣴⣶⣶⣾⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⢿⠀⠀⣶⣿⣿⣿⢹⣿⣿⢧⠀⢥⠶⣶⣶⠄⠀\n" +
            "⠀⠈⠉⠉⠉⠉⠋⠉⠉⠁⠈⠉⠉⠉⠉⠉⠛⠛⠛⠛⠉⠁⠀⠀⠀⠉⠉⠁⠉⠈⠉⠀⠀⠀⠈⠀⠉⠀⠀⠀⠀⠀\n";
		
		String desCherk = "El ogro más conocido modificado genéticamente para que sea de bolsillo! \n Le gustan las chimichangas y da clases de Java los jueves, no cobra mucho";
		String desUgandiano =  "Esta criatura de aspecto curioso aún no se ha extinguido, por alguna \n razón pone a su dueño en la jerarquía 'my queen' y está buscando cómo llegar a 'da wae', \n lo que no sabe es que 'da wae' son los brodas que haces en el camino.";
		String desFloppa = "Este enérgico lince siempre está preparado para las carnitas asadas,\n ha aprendido el idioma loquendo para comunicarse con los humanos \n y le sabe al 1v1 final destination no ítems.";
		
		MascotaVirtual cherk = new MascotaVirtual("CHERK", desCherk , cherkPic);
		MascotaVirtual ugandiano = new MascotaVirtual("UGANDIANO", desUgandiano , ugandianoPic);
		MascotaVirtual floppa = new MascotaVirtual("FLOPPA" ,desFloppa, floppaPic);
	
		mascotas.put(cherk.nombre(), cherk);
		mascotas.put(ugandiano.nombre(), ugandiano);
		mascotas.put(floppa.nombre(), floppa);
	}

	/**
	 * Método que busca una mascota en la base de datos.
	 *
	 * @param nombre El nombre de la mascota, que sirve como llave para buscar al bicho dentro de la Hashtable.
         * @return Un clon de la mascota virtual almacenada en la Hashtable.
	 */
	public MascotaVirtual obtenerMascota(String nombre){
		MascotaVirtual m = mascotas.get(nombre);
		return (MascotaVirtual) m.clone();
	}

	/**
	 * Método que imprime las mascotas disponibles para adoptar, incluyendo toda su información.
	 *
	 */
	public void mascotasDisponibles(){
		System.out.println("		 M A S C O T A S    D I S P O N I B L E S" +"\n");
		for (MascotaVirtual m : mascotas.values()) {
    		System.out.println(m);
			System.out.println("");
		}
	}
	
}
