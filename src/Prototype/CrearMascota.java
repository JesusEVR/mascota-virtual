package Prototype;


import java.util.Hashtable;

public class CrearMascota{
	
	private BaseDeDatosMascotas baseDatos;	
	private Hashtable<String , MascotaVirtual> mascotasNivelFacil; 
	private Hashtable<String , MascotaVirtual> mascotasNivelDificil; 

	public CrearMascota(){
		baseDatos = new BaseDeDatosMascotas();
		mascotasNivelFacil = new Hashtable<>(); 
		mascotasNivelDificil = new Hashtable<>();
		crearMascotaNivelFacil();
		crearMascotaNivelDificil();
	}
	
	public void verMascotas(){
		baseDatos.mascotasDisponibles();
	}

	private MascotaVirtual mascotaAsignarNivel(String nombre, double puntosHambre, double puntosEnergia, double puntosFelicidad, double saldo){
		MascotaVirtual mascota = baseDatos.obtenerMascota(nombre.toUpperCase());
		if(mascota==null) throw new NullPointerException("No existe una mascota con el nombre ingresado"); 
		mascota.asignarPuntosHambre(puntosHambre);
		mascota.asignarPuntosEnergia(puntosEnergia);
		mascota.asignarPuntosFelicidad(puntosFelicidad);
		mascota.asignarSaldoInicial(saldo);
		return mascota;
	}
	
	private void crearMascotaNivelFacil(){
		MascotaVirtual cherk = mascotaAsignarNivel("cherk",120,100,80,40);
		cherk.mensajeFeliz("La felicidad es como una cebolla, ¡tiene capas! ");
		cherk.mensajeSuenio("Soy un ogro, no un corderito. ¡Déjame dormir! ");
		cherk.mensajeHambre("¿Dónde está mi comida, Burro? ");
		cherk.mensajeAburrido("Este aburrimiento es peor que un pantano sin lodo, ¡y eso ya es decir algo! ");
		
		MascotaVirtual ugandiano = mascotaAsignarNivel("ugandiano",90,90,90,50);
		ugandiano.mensajeFeliz("Felicidad aumentada, te sigo my queen. ");
		ugandiano.mensajeSuenio("Estoy cansado, ya no puedo seguirte my queen. ");
		ugandiano.mensajeHambre("Necesito comida my queen. ");
		ugandiano.mensajeAburrido("El aburrimiento está pudiendo conmigo, my queen. ");
		
		MascotaVirtual floppa = mascotaAsignarNivel("floppa",100,80,90,45);
		floppa.mensajeFeliz("Prrrr… buenos momos equisdedede *procede a correr sin sentido. ");
		floppa.mensajeSuenio(" Humano, estoy... cansado...grr. ");
		floppa.mensajeHambre("Grrr, dame alimento, humano. ");
		floppa.mensajeAburrido("Grr, aaaaa saca algo para hacer, humano. ");
		
		mascotasNivelFacil.put(cherk.nombre(), cherk);
		mascotasNivelFacil.put(ugandiano.nombre(), ugandiano);
		mascotasNivelFacil.put(floppa.nombre(), floppa);
		
	}
	
	private void crearMascotaNivelDificil(){
		MascotaVirtual cherk = mascotaAsignarNivel("cherk",120,100,80,40);
		cherk.mensajeFeliz("Hoy es un buen día para disfrutar de la tranquilidad del pantano, amigo. ");
		cherk.mensajeSuenio("Soy un ogro, no un corderito. ¡Déjame dormir! ");
		cherk.mensajeHambre("¿Dónde está mi comida, Burro? ");
		cherk.mensajeAburrido("Este aburrimiento es peor que un pantano sin lodo, ¡y eso ya es decir algo! ");
		
		MascotaVirtual ugandiano = mascotaAsignarNivel("ugandiano",90,90,90,50);
		ugandiano.mensajeFeliz("Ello my queen, muéstrame 'da wae' ");
		ugandiano.mensajeSuenio("Estoy cansado, ya no puedo seguirte my queen. ");
		ugandiano.mensajeHambre("Necesito comida my queen. ");
		ugandiano.mensajeAburrido("El aburrimiento está pudiendo conmigo, my queen. ");
		
		MascotaVirtual floppa = mascotaAsignarNivel("floppa",100,80,90,45);
		floppa.mensajeFeliz("Grr hola humano equisde. ");
		floppa.mensajeSuenio(" Humano, estoy... cansado...grr. ");
		floppa.mensajeHambre("Grrr, dame alimento, humano. ");
		floppa.mensajeAburrido("Grr, aaaaa saca algo para hacer, humano. ");
		
		mascotasNivelDificil.put(cherk.nombre(), cherk);
		mascotasNivelDificil.put(ugandiano.nombre(), ugandiano);
		mascotasNivelDificil.put(floppa.nombre(), floppa);
		
	}
	
	
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