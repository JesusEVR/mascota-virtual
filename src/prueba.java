//import Prototype.MascotaVirtual;
//import State.Hogar;
import Composite.Producto;
import Composite.Alimento;
import Composite.Inventario;
/*import Iterator.Catalogo;
import Iterator.CatalogoAlimento;
import Iterator.IteradorLista;
import java.util.Iterator;
import Prototype.CrearMascota;
import Prototype.BaseDeDatosMascotas;

import Prototype.MuertePorAburrimientoException;
import Prototype.MuertePorCansancioException;
import Prototype.MuertePorIntoxicacionException;
import Prototype.MuertePorNoComerException;
import State.Hogar;*/
import Facade.CentroAdopcion;

public class prueba{
	public static void main(String[] args){
	//Composite
	/*	Producto p = new Alimento("00","Hamburguesa", "es mortal", 23.0, 12,-5); 
		Producto p2 = new Alimento("01","manzana", "es verde", 2.0, 12,-5); 
		Inventario carrito = new Inventario();
		carrito.agregarProducto(p);
		
		
		Inventario carrito2 = new Inventario();
		carrito2.agregarProducto(p2);
		Inventario refrigerador = new Inventario();
	
		refrigerador.agregarProducto(carrito);
		refrigerador.agregarProducto(carrito2);
		System.out.println("***"+refrigerador.tieneProductos());
		//System.out.println("refri tiene cosas: "+refrigerador.tieneProductos());
		//System.out.println("carrito tiene cosas: "+carrito.tieneProductos());
		//System.out.println(refrigerador.informacionConPrecio());
		//Producto pr = refrigerador.encontrarProducto("00");
		//Producto pro = refrigerador.encontrarProducto("01");
		
		refrigerador.eliminarSubinventarios();
		System.out.println("***"+refrigerador.tieneProductos());
		System.out.println(refrigerador.informacionConPrecio());*/
		
		
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
		
		c.darBienvenida();
		c.elegirNivel();
		c.adoptar();
		c.convivir();
		c.darFelicitacion();
	
		
	}
}