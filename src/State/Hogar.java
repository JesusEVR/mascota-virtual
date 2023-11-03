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
	private Inventario almacen;
	
	public Hogar(MascotaVirtual mascota){
		this.mascota = mascota;
		catalogo = new CatalogoAlimento();
		almacen = new Inventario();
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
	
	
	public boolean almacenVacio(){
		return !almacen.tieneProductos();
	}
	
	
	public void verAlmacen(){
		System.out.println("***** A L M A C E N *****");
		almacen.informacion();
	}
	
	
	public Producto buscarEnCatalogo(String codigo){ //Busca el alimento en el catalogo
		return null;
	}

	public void irAlMinisuper(){ //Operaciones para comprar alimentos, verifica que el dinero le alcance
	}
	
	
}