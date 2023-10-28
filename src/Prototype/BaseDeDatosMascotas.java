package Prototype;

import java.util.Hashtable;

public class BaseDeDatosMascotas{
	
	private Hashtable<String , MascotaVirtual> mascotas = new Hashtable<>(); 
	
	public BaseDeDatosMascotas(){
		MascotaVirtual cherk = new MascotaVirtual("CHERK", "aqui va una descripcion", "aqui va una imagen xd");
		MascotaVirtual ugandiano = new MascotaVirtual("UGANDIANO",  "aqui va una descripcion", "aqui va una imagen xd");
		MascotaVirtual floppa = new MascotaVirtual("FLOPPA" ,"aqui va una descripcion", "aqui va una imagen xd");
		mascotas.put(cherk.nombre(), cherk);
		mascotas.put(ugandiano.nombre(), ugandiano);
		mascotas.put(floppa.nombre(), floppa);
	}
	
	public MascotaVirtual obtenerMascota(String nombre){
		MascotaVirtual m = mascotas.get(nombre);
		return (MascotaVirtual) m.clone();
	}
	
	public void mascotasDisponibles(){
		System.out.println("----- M A S C O T A S    D I S P O N I B L E S -----");
		for (MascotaVirtual m : mascotas.values()) {
    		System.out.println(m);
			System.out.println("");
		}
	}
	
	
	
}