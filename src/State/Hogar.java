package State;

import Iterator.Catalogo;
import Iterator.CatalogoAlimento;
import Iterator.IteradorLista;
import java.util.Iterator;
import Composite.Alimento;
import Composite.Inventario;
import Composite.Producto;
import Composite.Alimento;
import Prototype.MascotaVirtual;
import Prototype.MuertePorAburrimientoException;
import Prototype.MuertePorCansancioException;
import Prototype.MuertePorIntoxicacionException;
import Prototype.MuertePorNoComerException;	

public class Hogar{
	
	private MascotaVirtual mascota;
	private EstadoMascota estadoActual;
	private EstadoMascota modoSuspendido;
	private EstadoMascota modoComer;
	private EstadoMascota modoJugar;
	private EstadoMascota modoDormir;
	private EstadoMascota modoDespertar;
	private EstadoMascota modoMorir;
	private boolean estaDormido = false;
	private boolean estaVivo=true;
	private Catalogo catalogo;
	private Inventario refrigerador;
	
	public Hogar(MascotaVirtual mascota){
		this.mascota = mascota;
		catalogo = new CatalogoAlimento();
		refrigerador = new Inventario();
		modoSuspendido = new ModoSuspender(this);
		modoComer = new ModoComer(this);
		modoJugar = new ModoJugar(this);
		modoDormir = new ModoDormir(this);
		modoDespertar = new ModoDespertar(this);
		modoMorir = new ModoMorir(this);
		estadoActual  = modoSuspendido;
	}
	
	public void infoMascota(){
		mascota.informacion();
	}
	
	public void asignarNuevoEstado(EstadoMascota modo){
		estadoActual = modo;
	}
	
	public void alimentar(){
		estadoActual.alimentar();
	}
	public void jugar(){
		estadoActual.jugar();
	}
	public void dormir(){
		estadoActual.dormir();
	}
	public void despertar(){
		estadoActual.despertar();
	}
	
	public EstadoMascota modoSuspender(){
		return modoSuspendido;
	}

	public EstadoMascota modoMorir(){
		return modoMorir;
	}
	
	public EstadoMascota modoComer(){
		return modoComer;
	}
	
	public EstadoMascota modoJugar(){
		return modoJugar;
	}
	
	public EstadoMascota modoDormir(){
		return modoDormir;
	}
	public EstadoMascota modoDespertar(){
		return modoDespertar;
	}
	
	public void estaDormido(boolean dormir){
		estaDormido = dormir;
	}
	
	public boolean estaDormido(){
		return estaDormido;
	}
	
	public void estaVivo(boolean estado){
		estaVivo = estado;
	}
	
	public boolean estaVivo(){
		return estaVivo;
	}
	
	
	public void jugarConMascota(double hambre, double energia, double felicidad)throws MuertePorNoComerException, MuertePorCansancioException{
		mascota.jugar(hambre, energia, felicidad);
	}
	
	public void dormirMascota(double felicidad) throws MuertePorAburrimientoException{
		mascota.dormir(felicidad);
	}
	
	public void alimentarMascota(Producto p)throws MuertePorIntoxicacionException, MuertePorAburrimientoException{
		mascota.comer(p);
	}
	
	public void verCatalogo(){
		Producto p;
		Iterator i = catalogo.creaIterador();
		System.out.println("***** M E N U   D E  A L I M E N T O S *****");
		while(i.hasNext()){
			p = (Producto) i.next();
			System.out.println(p.informacionConPrecio());
		}	
	}
	
	
	public boolean refrigeradorVacio(){
		return !refrigerador.tieneProductos();
	}
	
	
	public void verRefrigerador(){
		System.out.println("		*-*-*-*-* R E F R I GE R A D O R *-*-*-*-*");
		if(refrigeradorVacio()){
			System.out.println("	Este refrigerador esta vacio o.O");
		}else {
			System.out.println(refrigerador.informacion());
		}
		System.out.println("		*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	}
	
	public Producto buscarEnRefrigerador(String codigo){ 
		Producto p = refrigerador.encontrarProducto(codigo);
		if(p != null){
			refrigerador.eliminarProducto(p);
			return p;
		}
		return null;
	}
	
	public Producto buscarEnCatalogo(String codigo){ //Busca el alimento en el catalogo
		Producto p;
		Iterator i = catalogo.creaIterador();
		
		while(i.hasNext()){
			p = (Producto) i.next();
			if(p.codigo().equals(codigo)) return p;
		}	
		
		return null;
	}

	public void irAlMinisuper(){ //Operaciones para comprar alimentos, verifica que el dinero le alcance
		System.out.println("llendo al minisuper");
		Producto p = new Alimento("11","Hamburguesa", "es mortal", 23.0, -102,-50); 
		refrigerador.agregarProducto(p);
	}
	
	public boolean tieneDinero(){
		return mascota.saldo()>=10;
	}
	
	
}