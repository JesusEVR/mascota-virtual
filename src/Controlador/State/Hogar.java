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

/**
 * Clase que define al objeto Hogar. Esta clase pretende 'dividir' 
 * las características de la Mascota Virtual, y además hacerse cargo 
 * del proceso de compra alimentos y almacenamiento de estos.
 *
 * @author Supr-Lilito
 * @author paolasanv
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class Hogar{
	/**
	 * Mascota virtual que el objeto Hogar necesita para realizar sus procesos generales.
	 */
	private MascotaVirtual mascota;
	/**
	 * Estado actual de la mascota
	 */
	private EstadoMascota estadoActual;
	/**
	 * Modo suspendido de la mascota
	 */
	private EstadoMascota modoSuspendido;
	/**
	 * Modo comer de la mascota
	 */
	private EstadoMascota modoComer;
	/**
	 * Modo jugar de la mascota
	 */
	private EstadoMascota modoJugar;
	/**
	 * Modo dormir de la mascota
	 */
	private EstadoMascota modoDormir;
	/**
	 * Modo despertar de la mascota
	 */
	private EstadoMascota modoDespertar;
	/**
	 * Modo morir de la mascota
	 */
	private EstadoMascota modoMorir;
	/**
	 * Booleano que determina si la mascota está dormida.
	 */
	private boolean estaDormido = false;
	/**
	 * Booleano que determina si la mascota está viva.
	 */
	private boolean estaVivo = true;
	/**
	 * Catalogo de productos del supermercado.
	 */
	private Catalogo catalogo;
	/**
	 * Refrigerador donde se guardan los alimentos para la mascota.
	 */
	private Inventario refrigerador;
	/**
	 *
	 */
	private boolean pudoComprar = false;
	/**
	 * Contador de los días que la mascota ha estado viva.
	 */
	private int diasVivo = 1;

	/**
	 * Constructor por parámetros.
         * 
	 * @param mascota La mascota virtual dentro del hogar del jugador.
	 */
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

	/**
	 * Método que agrega un día más al contador de sobrevivencia de la mascota.
	 */
	public void unDiaMasVivo(){
		diasVivo++;
	}

	/**
	 * Devuelve la cantidad de días que la mascota ha estado viva.
         *
	 * @return diasVivo
	 */
	public int diasVivo(){
		return diasVivo;
	}

	/**
	 * Devuelve el nombre de la mascota.
         *
	 * @return Nombre de la mascota
	 */
	public String nombreMascota(){
		return mascota.nombre();
	}

	/**
	 * Devuelve la información de la mascota.
         *
	 * @return Los atributos de la mascota en forma de cadena.
	 */
	public void infoMascota(){
		mascota.informacion();
	}

	/**
	 * Cambia el estado de la mascota virtual (Hogar).
         *
	 * @param modo El modo que se desse asignar a la mascota
	 */
	public void asignarNuevoEstado(EstadoMascota modo){
		estadoActual = modo;
	}

	/**
	 * Realiza el proceso de alimentación de la mascota virtual, según su estado actual.
	 */
	public void alimentar(){
		estadoActual.alimentar();
	}

	/**
	 * Realiza el proceso que conlleva jugar con la mascota virtual, según su estado actual.
	 */
	public void jugar(){
		estadoActual.jugar();
	}

	/**
	 * Realiza el proceso que conlleva dormir a la mascota virtual, según su estado actual.
	 */
	public void dormir(){
		estadoActual.dormir();
	}

	/**
	 * Realiza el proceso de despertar a la mascota virtual, según su estado actual.
	 */
	public void despertar(){
		estadoActual.despertar();
	}

	/**
	 * Regresa el atributo modo Suspendido.
         * 
	 * @return modoSuspendido
	 */
	public EstadoMascota modoSuspender(){
		return modoSuspendido;
	}

	/**
	 * Regresa el atributo modo Morir.
         * 
	 * @return modoMorir
	 */
	public EstadoMascota modoMorir(){
		return modoMorir;
	}

	/**
	 * Regresa el atributo modo Comer.
         * 
	 * @return modoComer
	 */
	public EstadoMascota modoComer(){
		return modoComer;
	}

	/**
	 * Regresa el atributo modo Jugar.
         * 
	 * @return modoJugar
	 */
	public EstadoMascota modoJugar(){
		return modoJugar;
	}

	/**
	 * Regresa el atributo modo Dormir.
         * 
	 * @return modoDormir
	 */
	public EstadoMascota modoDormir(){
		return modoDormir;
	}

	/**
	 * Regresa el atributo modo Despertar.
         * 
	 * @return modoDespertar
	 */
	public EstadoMascota modoDespertar(){
		return modoDespertar;
	}

	/**
	 * Asigna un valor booleano al atributo estaDormido (setter)
         * 
	 * @return dormir La nueva variable que determina si la mascota duerme o no.
	 */
	public void estaDormido(boolean dormir){
		estaDormido = dormir;
	}

	/**
	 * Regresa el atributo estaDormido.
         * 
	 * @return estaDormido
	 */
	public boolean estaDormido(){
		return estaDormido;
	}

	/**
	 * Asigna un valor booleano al atributo estaVivo (setter).
         * 
	 * @return estado La nueva variable que determina esta viva o no.
	 */
	public void estaVivo(boolean estado){
		estaVivo = estado;
	}

	/**
	 * Regresa el atributo estaVivo.
         * 
	 * @return estaVivo
	 */
	public boolean estaVivo(){
		return estaVivo;
	}
	
	/**
	 * Método que modifica los puntos de hambre, energía y felicidad de la mascota cuando se juega con ella. 
         * Solo manda a llamar el método 'jugar' de la clase MascotaVirtual.
	 *
	 * @param hambre La cantidad de puntos de hambre a sumar (o restar) cuando la mascota juega.
         * @param energia La cantidad de puntos de energia a sumar (o restar) cuando la mascota juega.
         * @param felicidad La cantidad de puntos de felicidad a sumar (o restar) cuando la mascota  juega.
         * @throws MuertePorNoComerException Si la mascota juega demasiado sin detenerse a comer y sus puntos de hambre son menores o iguales a cero.
	 * @throws MuertePorCansancioException Si la mascota juega demasiado y sus puntos de energia son menores o iguales a cero.
	 */
	public void jugarConMascota(double hambre, double energia, double felicidad) throws MuertePorNoComerException, MuertePorCansancioException{
		mascota.jugar(hambre, energia, felicidad);
	}

	/**
	 * Método que modifica los puntos de energía y felicidad de la mascota cuando duerme.
         * Solo manda a llmar al método 'dormir' de la clase MascotaVirtual.
	 *
	 * @param felicidad La cantidad de puntos de felicidad a restar cuando se duerme la mascota.
         * @throws MuertePorAburrimientoException Si la mascota duerme demasiado y sus puntos de felicidad son menores o iguales a cero.
	 */
	public void dormirMascota(double felicidad) throws MuertePorAburrimientoException{
		mascota.dormir(felicidad);
	}
	
	/**
	 * Método que modifica los puntos de hambre y felicidad de la mascota cuando es alimentada.
         * Solo manda a llamar al método 'comer' d ela clase MascotaVirtual.
	 *
	 * @param p El producto con el que se alimentará a la mascota virtual
         * @throws MuertePorIntoxicacionException Si los puntos de hambre de la mascota son iguales o menores a cero debido a lo que comió.
         * @throws MuertePorAburrimientoException Si los puntos de felicidad de la mascota son iguales o menores a cero debido a lo que comió.
	 */
	public void alimentarMascota(Producto p)throws MuertePorIntoxicacionException, MuertePorAburrimientoException{
		mascota.comer(p);
	}

	/**
	 * Imprime la información con precio del catálogo de productos en el supermercado.
	 */
	public void verCatalogo(){
		Producto p;
		Iterator i = catalogo.creaIterador();
		System.out.println(">>>>>>>>> C A T A L O G O   D E   A L I M E N T O S <<<<<<<<");
		while(i.hasNext()){
			p = (Producto) i.next();
			System.out.println(p.informacionConPrecio());
		}	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	/**
	 * Determina si el refrigerador no tiene productos dentro.
         * 
	 * @return 'true' si el refrigerador está vacío, 'false' en otro caso.
	 */
	public boolean refrigeradorVacio(){
		refrigerador.eliminarSubinventarios();
		return !refrigerador.tieneProductos();
	}
	
	/**
	 * Imprime la información de los productos que estén dentro del refigerador del jugador.
	 */
	public void verRefrigerador(){
		System.out.println("		_-_-_-_-_ R E F R I G E R A D O R _-_-_-_-_");
		if(refrigeradorVacio()){
			System.out.println("			Este refrigerador esta vacio o.O");
		}else {
			System.out.println(refrigerador.informacion());
		}
		System.out.println("		_-_-_-_-_-_-_-_-_-_-__-__-_-_-_-_-_-_-_-_-_");
	}

	/**
	 * Busca un producto en el refrigerador del jugador.
         * 
	 * @param codigo El código único del producto a buscar.
	 * @return p El producto requerido.
	 */
	public Producto buscarEnRefrigerador(String codigo){ 
		Producto p = refrigerador.encontrarProducto(codigo);
		return p;
	}

	/**
	 * Busca un producto en el catálogo de la tienda.
         * 
	 * @param codigo El código único del producto a buscar.
	 * @return p El producto requerido.
	 */
	public Producto buscarEnCatalogo(String codigo){ //Busca el alimento en el catalogo
		Producto p;
		Iterator i = catalogo.creaIterador();
		while(i.hasNext()){
			p = (Producto) i.next();
			if(p.codigo().equals(codigo)) return p;
		}	
		return null;
	}

	/**
	 * Despliega un menú del minisuper,
         * 
	 * @param codigo El código único del producto a buscar.
	 * @return p El producto requerido.
	 */
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
			System.out.println("\n"+"			Procederemos con la transaccion...");
			System.out.println("");
			try{
				mascota.comprar(total);
				System.out.println("\n"+"		COMPRA REALIZADA CON EXITO "+"\n");
				refrigerador.agregarProducto(carritoVirtual);
				pudoComprar(true);
			}catch(SaldoInsuficienteException ex){
				System.out.println("\n"+"		_-_-_-_-_-_-_ SALDO INSUFICIENTE _-_-_-_-_-_-_");
				System.out.println("				¡Tu saldo es insuficiente!");
				System.out.println("	Pudes jugar para ganar mas pejecoins o intentar nuevamente comprar algo (para lo que te alcance)");
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
