package Prototype;

public class CrearMascota{
	
	private BaseDeDatosMascotas baseDatos;
	
	public CrearMascota(){
		baseDatos = new BaseDeDatosMascotas();
	}

	public MascotaVirtual mascotaAsignarNivel(String nombre, double puntosHambre, double puntosEnergia, double puntosFelicidad, double saldo){
		MascotaVirtual mascota = baseDatos.obtenerMascota(nombre.toUpperCase());
		
		if(mascota==null) throw new NullPointerException("No existe una mascota con el nombre ingresado"); 
		
		mascota.asignarPuntosHambre(puntosHambre);
		mascota.asignarPuntosEnergia(puntosEnergia);
		mascota.asignarPuntosFelicidad(puntosFelicidad);
		mascota.asignarSaldoInicial(saldo);
		return mascota;
	}
	
	public void verMascotas(){
		baseDatos.mascotasDisponibles();
	}
	
	
}