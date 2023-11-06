package Controlador.State;

import java.util.Scanner;
import java.util.Iterator;

import Modelo.Iterator.Catalogo;
import Modelo.Iterator.CatalogoAlimento;
import Modelo.Iterator.IteradorLista;
import Modelo.Composite.Alimento;
import Modelo.Composite.Inventario;
import Modelo.Composite.Producto;
import Modelo.Composite.Alimento;
import Modelo.Prototype.MascotaVirtual;
import Modelo.Prototype.MuertePorAburrimientoException;
import Modelo.Prototype.MuertePorCansancioException;
import Modelo.Prototype.MuertePorIntoxicacionException;
import Modelo.Prototype.SaldoInsuficienteException;
import Modelo.Prototype.MuertePorNoComerException;	

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
	private boolean pudoComprar=false;
	private int diasVivo=1;
	
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
	
	public void unDiaMasVivo(){
		diasVivo++;
	}
	
	public int diasVivo(){
		return diasVivo;
	}
	
	public String nombreMascota(){
		return mascota.nombre();
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
		System.out.println(">>>>>>>>> C A T A LO G O   D E    A L I M E N T O S <<<<<<<<");
		while(i.hasNext()){
			p = (Producto) i.next();
			System.out.println(p.informacionConPrecio());
		}	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	
	public boolean refrigeradorVacio(){
		refrigerador.eliminarSubinventarios();
		return !refrigerador.tieneProductos();
	}
	
	
	public void verRefrigerador(){
		System.out.println("		_-_-_-_-_ R E F R I GE R A D O R _-_-_-_-_");
		if(refrigeradorVacio()){
			System.out.println("			Este refrigerador esta vacio o.O");
		}else {
			System.out.println(refrigerador.informacion());
		}
		System.out.println("		_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
	}
	
	public Producto buscarEnRefrigerador(String codigo){ 
		Producto p = refrigerador.encontrarProducto(codigo);
		return p;
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
		Scanner sc = new Scanner(System.in);
		Inventario carritoVirtual = new Inventario();
		int opcion = 0;
		boolean seguir = false;
		boolean puedePagar=false;
		Producto producto;
		System.out.println("	");
		System.out.println("	");
		System.out.println("*-*-*-*-*-*-*-*-*-**-*-*-*-*  M I  N I - S U P E R *-*-*-*-*-*-*-*-*-**-*-*-*-*-*");
		System.out.println("");
		System.out.println("A continuacion se muestra el catálogo de los alimentos disponibles que ");
		System.out.println(" puedes comprar para alimentar a tu mascota");
		System.out.println("");
		verCatalogo();
		
		do{
		System.out.println("");
		System.out.println("			-->	1. Agregar alimento al carrito de compras");
		System.out.println("			-->	0. Terminar compra");
		System.out.print("");
		System.out.print("Seleccione la opcion que desee ejecutar: ");
			while(true){
					try {
						String opcionUsuario = sc.nextLine();
						opcion =  Integer.parseInt(opcionUsuario);
						if(opcion == 0 || opcion == 1){ 
							break;
						}else{ System.out.print("		Por favor, elige una opcion valida: ");
						}
					}catch (NumberFormatException ex){
						System.out.print("		Por favor, elige una opcion valida: ");
					}
			}

			switch(opcion){
				case 0:
					
					if(carritoVirtual.tieneProductos()){
						System.out.println("");
						System.out.println("\n"+"	¡Has finalizado tu compra! procederemos con el siguiete paso :)");
						puedePagar = true;
					}else{
						System.out.println("");
						System.out.println("\n"+"		Has cancelado la compra.");
						pudoComprar(false);
					}
					seguir = false;
					break;
				case 1:
					
					System.out.print("\n"+">> Escribe el codigo del producto: ");
					String codigo = sc.nextLine();
					producto = buscarEnCatalogo(codigo);

					if(producto==null){
						System.out.println("		¡Ese codigo es invalido!");
					}else{
						carritoVirtual.agregarProducto(producto);
					}
						seguir = true;
					break;
			}
		}while(seguir);
		
		if(puedePagar){
			double total = carritoVirtual.precio();
			System.out.println("Tu lista de compras es:	");
			System.out.println("________________________T I C K E T__________________________");
			System.out.println(carritoVirtual.informacionConPrecio());
			System.out.println("				Total:	$" +total+" pejecoins " );
			System.out.println("________________________________________________________");
			System.out.println("\n"+"			Procederemos con la transaccion....");
			System.out.println("");
			try{
				mascota.comprar(total);
				System.out.println("\n"+"		COMPRA REALIZADA CON EXITO "+"\n");
				refrigerador.agregarProducto(carritoVirtual);
				pudoComprar(true);
			}catch(SaldoInsuficienteException ex){
				System.out.println("\n"+"		_-_-_-_-_-_-_SALDO INSUFICIENTE _-_-_-_-_-_-_");
				System.out.println("				¡Tu saldo es insuficiente!");
				System.out.println("	Pudes jugar para ganar mas pejecoins o intentar comprar nuevamente algo que te alcance");
				System.out.println("		_-_-_-_-_-_-__-_-_-_-_-_-__-_-_-_-_-_-_"+"\n");
				pudoComprar(false);
			}
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-**-*-*-*-*-*-*-*-*-**-*-*-*-*-*");
	}
	
	public boolean pudoComprar(){
		return pudoComprar;
	}
	
	public void pudoComprar(boolean p){
		pudoComprar=p;
	}
	
	public void depositar(double monto){
		mascota.depositar(monto);
	}
	
}