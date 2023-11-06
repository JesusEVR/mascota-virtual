package Modelo.Prototype;

import java.util.Hashtable;

/**
 * Clase que define la creación de mascotas virtual, incluyendo de las dos dificultades disponibles
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class CrearMascota{
	/**
	 * Hastable con las tres mascotas guardadas
	 */
	private BaseDeDatosMascotas baseDatos;	
	/**
	 * Hastable correspondiente a la dificultad fácil
	 */
	private Hashtable<String , MascotaVirtual> mascotasNivelFacil; 
	/**
	 * Hastable correspondiente a la dificultad diícil
	 */
	private Hashtable<String , MascotaVirtual> mascotasNivelDificil; 

	/**
	 * Constructor por omisión
	 */
	public CrearMascota(){
		baseDatos = new BaseDeDatosMascotas();
		mascotasNivelFacil = new Hashtable<>(); 
		mascotasNivelDificil = new Hashtable<>();
		crearMascotaNivelFacil();
		crearMascotaNivelDificil();
	}

	/**
	 * Imprime la información de las mascotas virtuales del hashtable
	 */
	public void verMascotas(){
		baseDatos.mascotasDisponibles();
	}

	/**
	 * Método auxiliar que inicializa los atributos de las mascotas copia.
         *
         * @param nombre El nombre que funge como clave para buscar a una mascota en la Hashtable, y copiar su nombre, descripcion e imagen.
         * @param puntosHambre Los puntos de hambre que se asiganarán a ls mascota
         * @param puntosEnergia Los puntos de energía que se asignarán a la mascota
         * @param puntosFelicidad Los puntos de felicidad que se asiganrán a la mascota
         * @param saldo La cantidad de monedas que contará el usuario con esta mascota
         *
         * @return mascota La mascota virtual 'copia'
	 * @throws NullPointerException Si no existe una mascota en la Hashtable dada la clave (nombre) proporcionada.
	 */
	private MascotaVirtual mascotaAsignarNivel(String nombre, double puntosHambre, double puntosEnergia, double puntosFelicidad, double saldo){
		MascotaVirtual mascota = baseDatos.obtenerMascota(nombre.toUpperCase());
		if(mascota==null) throw new NullPointerException("No existe una mascota con el nombre ingresado"); 
		mascota.asignarPuntosHambre(puntosHambre);
		mascota.asignarPuntosEnergia(puntosEnergia);
		mascota.asignarPuntosFelicidad(puntosFelicidad);
		mascota.asignarSaldoInicial(saldo);
		return mascota;
	}
	
	/**
	 * Método auxiliar que crea tres mascotas virtuales correspondientes a la
         * dificultad fácil, y después las agrega a la Hashtable de la misma.
	 */
	private void crearMascotaNivelFacil(){
		MascotaVirtual cherk = mascotaAsignarNivel("cherk",120,100,80,40);
		cherk.mensajeFeliz("La felicidad es como una cebolla, ¡tiene capas! ");
		cherk.mensajeSuenio("Soy un ogro, no un corderito. ¡Déjame dormir! ");
		cherk.mensajeHambre("¿Dónde está mi comida, Burro? ");
		cherk.mensajeAburrido("Este aburrimiento es peor que un pantano sin lodo, ¡y eso ya es decir algo! ");
		
		MascotaVirtual ugandiano = mascotaAsignarNivel("ugandiano",100,100,100,50);
		ugandiano.mensajeFeliz("Felicidad aumentada, te sigo my queen. ");
		ugandiano.mensajeSuenio("Estoy cansado, ya no puedo seguirte my queen. ");
		ugandiano.mensajeHambre("Necesito comida my queen. ");
		ugandiano.mensajeAburrido("El aburrimiento está pudiendo conmigo, my queen. ");
		
		MascotaVirtual floppa = mascotaAsignarNivel("floppa",110,80,90,45);
		floppa.mensajeFeliz("Prrrr… buenos momos equisdedede *procede a correr sin sentido. ");
		floppa.mensajeSuenio(" Humano, estoy... cansado...grr. ");
		floppa.mensajeHambre("Grrr, dame alimento, humano. ");
		floppa.mensajeAburrido("Grr, aaaaa saca algo para hacer, humano. ");
		
		mascotasNivelFacil.put(cherk.nombre(), cherk);
		mascotasNivelFacil.put(ugandiano.nombre(), ugandiano);
		mascotasNivelFacil.put(floppa.nombre(), floppa);
	}

	/**
	 * Método auxiliar que crea tres mascotas virtuales correspondientes a la
         * dificultad difícil, y después las agrega a la Hashtable de la misma.
	 */
	private void crearMascotaNivelDificil(){
		MascotaVirtual cherk = mascotaAsignarNivel("cherk",70,80,80,40);
		cherk.mensajeFeliz("Hoy es un buen día para disfrutar de la tranquilidad del pantano, amigo. ");
		cherk.mensajeSuenio("Soy un ogro, no un corderito. ¡Déjame dormir! ");
		cherk.mensajeHambre("¿Dónde está mi comida, Burro? ");
		cherk.mensajeAburrido("Este aburrimiento es peor que un pantano sin lodo, ¡y eso ya es decir algo! ");
		
		MascotaVirtual ugandiano = mascotaAsignarNivel("ugandiano",70,70,70,50);
		ugandiano.mensajeFeliz("Ello my queen, muéstrame 'da wae' ");
		ugandiano.mensajeSuenio("Estoy cansado, ya no puedo seguirte my queen. ");
		ugandiano.mensajeHambre("Necesito comida my queen. ");
		ugandiano.mensajeAburrido("El aburrimiento está pudiendo conmigo, my queen. ");
		
		MascotaVirtual floppa = mascotaAsignarNivel("floppa",60,80,90,45);
		floppa.mensajeFeliz("Grr hola humano equisde. ");
		floppa.mensajeSuenio(" Humano, estoy... cansado...grr. ");
		floppa.mensajeHambre("Grrr, dame alimento, humano. ");
		floppa.mensajeAburrido("Grr, aaaaa saca algo para hacer, humano. ");
		
		mascotasNivelDificil.put(cherk.nombre(), cherk);
		mascotasNivelDificil.put(ugandiano.nombre(), ugandiano);
		mascotasNivelDificil.put(floppa.nombre(), floppa);
	}
	
	/**
	 * Método que busca una mascota virtual dependiendo de la dificultad que haya elegido el usuario.
         *
	 * @param nombre El nombre de la mascota virtual que sirve como clave para poder buscarla en la Hashtable.
         * @param nivelDificultad La dificultad que eligió el jugador.
	 * @return La mascota que se busca. Devuelve 'null' en caso de no haber encontrado alguna mascota con la clave dada.
	 */
	public MascotaVirtual obtenerMascota(String nombre, String nivelDificultad){
		if(nivelDificultad.toLowerCase().equals("facil")){

			for (MascotaVirtual m : mascotasNivelFacil.values()) {
    			if(nombre.toUpperCase().equals(m.nombre())) return m;
			}
			
		}else if(nivelDificultad.toLowerCase().equals("dificil")){
			for (MascotaVirtual m2 : mascotasNivelDificil.values()) {
    			if(nombre.toUpperCase().equals(m2.nombre())) return m2;
			}
		}
		
		return null;
	}
}
