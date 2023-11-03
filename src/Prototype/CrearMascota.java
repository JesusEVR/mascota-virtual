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
		MascotaVirtual cherkFacil = mascotaAsignarNivel("cherk",120,100,80,40);
		MascotaVirtual ugandianoFacil = mascotaAsignarNivel("ugandiano",90,90,90,50);
		MascotaVirtual floppaFacil = mascotaAsignarNivel("floppa",100,80,90,45);
		
		mascotasNivelFacil.put(cherkFacil.nombre(), cherkFacil);
		mascotasNivelFacil.put(ugandianoFacil.nombre(), ugandianoFacil);
		mascotasNivelFacil.put(floppaFacil.nombre(), floppaFacil);
		
	}
	
	private void crearMascotaNivelDificil(){
		MascotaVirtual cherkDificil = mascotaAsignarNivel("cherk",120,100,80,40);
		MascotaVirtual ugandianoDificil = mascotaAsignarNivel("ugandiano",90,90,90,50);
		MascotaVirtual floppaDificil = mascotaAsignarNivel("floppa",100,80,90,45);
		
		mascotasNivelFacil.put(cherkDificil.nombre(), cherkDificil);
		mascotasNivelFacil.put(ugandianoDificil.nombre(), ugandianoDificil);
		mascotasNivelFacil.put(floppaDificil.nombre(), floppaDificil);
		
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