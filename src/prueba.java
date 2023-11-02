/*import Composite.Producto;
import Composite.Alimento;
import Composite.Inventario;
import Iterator.Catalogo;
import Iterator.CatalogoAlimento;
import Iterator.IteradorLista;
import java.util.Iterator;
import Prototype.CrearMascota;
import Prototype.BaseDeDatosMascotas;
import Prototype.MascotaVirtual;
import Prototype.MuertePorAburrimientoException;
import Prototype.MuertePorCansancioException;
import Prototype.MuertePorIntoxicacionException;
import Prototype.MuertePorNoComerException;
import State.Hogar;*/
import Facade.CentroAdopcion;

public class prueba{
	public static void main(String[] args){
	//Composite
		/*Producto p = new Alimento("11","Hamburguesa", "es mortal", 23.0, 12,-5); //precio, hambre,felicidad
		Inventario inventario = new Inventario();
		inventario.agregarProducto(p);
		System.out.println("***AÑADIR ALIMENTOS AL REFRIGERADOR *** (prueba composite)");
		System.out.println( "(version para imprimir la info del refrigerador)"+"\n"+ inventario.informacion());
		System.out.println("");
		System.out.println("(version para imprimir la info del menu)" +"\n"+ inventario.informacionConPrecio());
		System.out.println("");*/
		
	//Iterator
		/*Producto pr;
		Catalogo c = new CatalogoAlimento();
		Iterator i = c.creaIterador();
		System.out.println("*** MENU DE ALIMENTOS *** (prueba iterator)");
		while(i.hasNext()){
			pr = (Producto) i.next();
			System.out.println(pr.informacionConPrecio());
		}*/
		
	//Prototype	
		/*MascotaVirtual prueba = new MascotaVirtual("Miguelito" , "Mi gato miguelito es bonito", "aqui va una imagen");
		prueba.asignarPuntosHambre(100);
		prueba.asignarPuntosEnergia(100);
		prueba.asignarPuntosFelicidad(50);
		prueba.asignarSaldoInicial(123);
		System.out.println(prueba);
		prueba.informacion();*/
		//BaseDeDatosMascotas base = new BaseDeDatosMascotas();
		//base.mascotasDisponibles();
		
		
	//State
		/*CrearMascota crear = new CrearMascota();	                  //hambre,energia,felicidad,saldo
		MascotaVirtual miMascota = crear.mascotaAsignarNivel("cherk", 50, 100, 230, 40);
		
		Hogar h = new Hogar();
		
		h.despertar();
		h.dormir();
		h.despertar();
		h.jugar();
		h.alimentar();*/
		
	//Casos de muerte
		/*try{
		miMascota.jugar(9,-14,4); //hambre,energia,felicdidad
		miMascota.informacion();
		}catch(MuertePorNoComerException e){
			System.out.println("Tu mascota murio por falta de alimento");
		}catch(MuertePorCansancioException ex){
			System.out.println("Tu mascota murio por cansancio");
		}
		
		
		try{
		miMascota.dormir(12); //felicidad a disminuir
		miMascota.informacion();
		}catch(MuertePorAburrimientoException e){
			System.out.println("Tu mascota murio por dormir mucho, se aburrió demasiado");
		}
		
	
		Producto p1 = new Alimento("11","Hamburguesa", "es mortal", 23.0, 3,-6); //precio, hambre,felicidad
		try{
		miMascota.comer(p1); 
		miMascota.informacion();
		}catch(MuertePorIntoxicacionException e){
			System.out.println("Tu mascota murio comer algo que lo intoxicó");
		}catch(MuertePorAburrimientoException ex){
			System.out.println("Tu mascota se cansó de comer cosas aburridas y se deprimió, falleció por aburrimiento");
		}*/
		
		CentroAdopcion c = new CentroAdopcion();
		c.convivir();
		
	}
}