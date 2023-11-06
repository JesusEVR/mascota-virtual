package Modelo.Prototype;

import Modelo.Composite.Producto;

/**
 * Clase que define las caracteristicas principales de una Mascota Virtual
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 *
 */
public class MascotaVirtual implements Cloneable{
	/**
	 * Valor máximo que pueden alcanzar los puntos de hambre
	 */
	private double PUNTOS_HAMBRE;
	/**
	 * Valor máximo que pueden alcanzar los puntos de energia
	 */
	private double PUNTOS_ENERGIA;
	/**
	 * Valor máximo que pueden alcanzar los puntos de felicidad
	 */
	private double PUNTOS_FELICIDAD;
	/**
	 * Puntos de hambre de la mascota
	 */
	private double puntosHambre;
	/**
	 * Puntos de energía de la mascota
	 */
	private double puntosEnergia;
	/**
	 * Puntos de felicidad de la mascota
	 */
	private double puntosFelicidad;
	/**
	 * Saldo inicial que se otorga al jugador cuando elige una mascota
	 */
	private double saldo;
	/**
	 * Nombre de la mascota
	 */
	private String nombre;
	/**
	 * Breve dscripcion de la mascota
	 */
	private String descripcion;
	/**
	 * Imagen de la mascota adaptada a las limitaciones economicas
	 */
	private String imagenMascota; 
	/**
	 * Mensaje que envia la mascota cuando tiene sueño
	 */
	private String mensajeSuenio;
	/**
	 * Mensaje que envia la mascota cuando tiene hambre
	 */
	private String mensajeHambre;
	/**
	 * Mensaje que envia la mascota cuando esta aburrida
	 */
	private String mensajeAburrido;
	/**
	 * Mensaje que envia la mascota cuando esta feliz
	 */
	private String mensajeFeliz;
	
	
	/**
	 * Constructor por parametros de una mascota virtual. Inicializa los puntos y frases de forma automática.
         *
	 * @param nombre El nombre que tendrá la mascota
         * @param descripcion Una breve descripcion de la mascota
         * @param imagenMascota La 'imagen' que representa a la mascota
	 *
	 */
	public MascotaVirtual(String nombre, String descripcion, String imagenMascota){ 
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagenMascota = imagenMascota;
		puntosHambre = 0;
		puntosEnergia = 0;
		puntosFelicidad = 0;
		saldo = 0;
		mensajeSuenio="Tengo sueño :( ";
		mensajeHambre="Tengo hambre >:/ ";
		mensajeAburrido= "Estoy aburrido :/  ";
		mensajeFeliz = "Modo japi:)";
	}

	/**
	 * Metodo que asigna un mensaje de felicidad a la mascota.
         *
	 * @param m El mensaje que enviará las mascota cuando esté feliz.
	 *
	 */
	public void mensajeFeliz(String m){
		mensajeFeliz = m;
	}

	/**
	 * Metodo que asigna un mensaje de fsueño a la mascota.
         *
	 * @param m El mensaje que enviará las mascota cuando tenga sueño.
	 *
	 */
	public void mensajeSuenio(String m){
		mensajeSuenio = m;
	}

	/**
	 * Metodo que asigna un mensaje de hambre a la mascota.
         *
	 * @param m El mensaje que enviará las mascota cuando tenga hambre.
	 *
	 */
	public void mensajeHambre(String m){
		mensajeHambre = m;
	}

	/**
	 * Metodo que asigna un mensaje de aburrimiento a la mascota.
         *
	 * @param m El mensaje que enviará las mascota cuando esté aburrida.
	 *
	 */
	public void mensajeAburrido(String m){
		mensajeAburrido = m;
	}
	
	/**
	 * Metodo que asigna puntos de hambre a una mascota virtual.
	 *
         * @param valorMaximo Los puntos de hambre que serán asignados a la mascota. También serán asignados como el nuevo valor máaximo de los puntos de hambre.
	 * @throws IllegalArgumentException Si los puntos de hambre ya fueron asignados a la mascota con anterioridad.
	 */
	public void asignarPuntosHambre(double valorMaximo){
		if(puntosHambre!=0) throw new IllegalArgumentException("El valor máximo del atributo 'puntosHambre' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosHambre = valorMaximo;
		PUNTOS_HAMBRE = valorMaximo;
	}

	/**
	 * Metodo que asigna puntos de energia a una mascota virtual.
	 *
         * @param valorMaximo Los puntos de energia que serán asignados a la mascota. También serán asignados como el nuevo valor máaximo de los puntos de energia.
	 * @throws IllegalArgumentException Si los puntos de energia ya fueron asignados a la mascota con anterioridad.
	 */
	public void asignarPuntosEnergia(double valorMaximo){
		if(puntosEnergia!=0) throw new IllegalArgumentException("El valor máximo del atributo 'puntosEnergia' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosEnergia = valorMaximo;
		PUNTOS_ENERGIA = valorMaximo;
	}

	/**
	 * Metodo que asigna puntos de felicidad a una mascota virtual.
	 *
         * @param valorMaximo Los puntos de felicidad que serán asignados a la mascota. También serán asignados como el nuevo valor máaximo de los puntos de felicidad.
	 * @throws IllegalArgumentException Si los puntos de felicidad ya fueron asignados a la mascota con anterioridad.
	 */
	public void asignarPuntosFelicidad(double valorMaximo){
		if(puntosFelicidad!=0) throw new IllegalArgumentException("El valor máximo del atributo 'puntosFelicidad' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosFelicidad = valorMaximo;
		PUNTOS_FELICIDAD = valorMaximo;
	}

	/**
	 * Metodo que asigna un nuevo saldo, con el que comprar comida.
	 *
         * @param montoInicial La cantidad de dinero que tendrá el usuario en su saldo.
	 * @throws IllegalArgumentException Si el saldo inicial ya fue asigando
	 */
	public void asignarSaldoInicial(double montoInicial){
		if(saldo!=0) throw new IllegalArgumentException("El saldo inicial ya fue asignado, no puedes regalar pejecoins"); 
		saldo = montoInicial;
	}
	
	/**
	 * Metodo que devuelve el nombre de la mascota
	 *
         * @return nombre
	 */
	public String nombre(){
		return nombre;
	}

	/**
	 * Metodo que devuelve los puntos de hambre de la mascota.
	 *
         * @return puntosHambre
	 */
	public double puntosHambre(){
		return puntosHambre;
	}

	/**
	 * Metodo que devuelve los puntos de energia de la mascota.
	 *
         * @return puntosEnergia
	 */
	public double puntosEnergia(){
		return puntosEnergia;
	}

	/**
	 * Metodo que devuelve los puntos de felicidad de la mascota.
	 *
         * @return puntosFelicidad
	 */
	public double puntosFelicidad(){
		return puntosFelicidad;
	}

	/**
	 * Metodo que devuelve el saldo asigando según la mascota que se eligió.
	 *
         * @return saldo
	 */
	public double saldo(){
		return saldo;
	}

	/**
	 * Metodo que devuelve el nombre de la mascota.
	 *
         * @param monto La cantidad de dinero a pagar por una compra.
	 * @throws SaldoInsuficienteException Si el monto a pagar es superior al saldo con el que cuenta el usuario.
	 */
	public void comprar(double monto) throws SaldoInsuficienteException{
		if(monto>saldo) throw new SaldoInsuficienteException();
		saldo -= monto;
	}

	/**
	 * Método que deposito dinero en el saldo del jugador.
	 *
         * @param monto
	 */
	public void depositar(double monto){
		saldo += monto;
	}

	/**
	 * Metodo que clona un objeto Mascota virtual.
	 *
         * @return clon Un clon de Mascota Virtual.
	 */
	public Object clone(){
		MascotaVirtual clon = new MascotaVirtual(nombre, descripcion, imagenMascota); 
		return clon;
	}

	/**
	 * Metodo que determina si la mascota está aburrida.
	 *
         * @return 'true' si los puntos de felicidad (actuales) de la mascota son menores o iguales al veiente porciento del total, 'false' en el caso contrario.
	 */
	public boolean estaAburrido(){
		double veintePorciento = PUNTOS_FELICIDAD * 0.2;
		if(puntosFelicidad <= veintePorciento) return true; //la felicidad esta al 20% o menos 
		return false;
	}

	/**
	 * Metodo que determina si la mascota tiene hambre.
	 *
         * @return 'true' si los puntos de hambre (actuales) de la mascota son menores o iguales al veiente porciento del total, 'false' en el caso contrario.
	 */
	public boolean tieneHambre(){
		double veintePorciento = PUNTOS_HAMBRE * 0.2;
		if(puntosHambre <= veintePorciento) return true;
		return false;
	}

	/**
	 * Metodo que determina si la mascota tiene sueño / está cansada.
	 *
         * @return 'true' si los puntos de energia (actuales) de la mascota son menores o iguales al veiente porciento del total, 'false' en el caso contrario.
	 */
	public boolean tieneSuenio(){
		double veintePorciento = PUNTOS_ENERGIA * 0.2;
		if(puntosEnergia <= veintePorciento) return true;
		return false;
	}

	/**
	 * Devuelve el estado actual de la mascota, arrojando un mensaje acorde a tal. Se determina a partir de sus estadísticas.
	 *
         * @return Un string correspondiente a su estado actual.
	 */
	public String estadoActual(){
		String estado = "";
		
		if(puntosHambre<=0 || puntosEnergia<=0 ||puntosFelicidad<=0) return "Fallecido u.u"; // Si sus estadisticas son menores o iguales a cero, ha muerto.
		
		if(!tieneSuenio() && !tieneHambre() && !estaAburrido()){ // Si no está aburrido, no tiene hambre ni sueño, entonces está feliz.
			return mensajeFeliz; 
		}
		if(estaAburrido()){              
			estado += mensajeAburrido; 
		}
		
		if(tieneHambre()){
			estado += mensajeHambre; 
		}
		
		if(tieneSuenio()){
			estado += mensajeSuenio; 
		}
		
		return estado;
	}

	/**
	 * Metodo que imprime las caracteríticas de una mascota virtual.
	 *
	 */
	public void informacion(){
		String infoMascota = "****************************************************************" +"\n"
			+ imagenMascota + "\n"
			+ "Nombre: " +nombre + "\n"
			+ "\n"+"Descripcion: " + descripcion + "\n"
			+ "\n"+"Monedero electronico: $" + saldo +" pejecoins "+ "\n"
			+ "Hambre: " + puntosHambre() + "/" + PUNTOS_HAMBRE + "\n"
			+ "Energia: " + puntosEnergia() + "/" + PUNTOS_ENERGIA + "\n"
			+ "Felicidad: " + puntosFelicidad() + "/" + PUNTOS_FELICIDAD + "\n"
			+ "Estado: "+ estadoActual()+"\n"
			+ "****************************************************************";
		System.out.println(infoMascota);
	}

	/**
	 * Método que convierte toda la información de la mascota virutal a una cadena, una muy grande.
	 *
	 * @return mascota La cadena con toda la información de la mascota.
	 */
	public String toString(){
		String mascota = "****************************************************************"+"\n"
			+ imagenMascota + "\n"
			+ "Nombre: " +nombre + "\n"
			+ "Descripcion: " + descripcion + "\n"
			+ "****************************************************************";
		return mascota;
	}

	/**
	 * Método que modifica los puntos de hambre, energía y felicidad de la mascota cuando se juega con ella.
	 *
	 * @param hambre La cantidad de puntos de hambre a sumar (o restar) cuando la mascota juega.
         * @param energia La cantidad de puntos de energia a sumar (o restar) cuando la mascota juega.
         * @param felicidad La cantidad de puntos de felicidad a sumar (o restar) cuando la mascota  juega.
         * @throws MuertePorNoComerException Si la mascota juega demasiado sin detenerse a comer y sus puntos de hambre son menores o iguales a cero.
	 * @throws MuertePorCansancioException Si la mascota juega demasiado y sus puntos de energia son menores o iguales a cero.
	 */
	public void jugar(double hambre, double energia, double felicidad) throws MuertePorNoComerException, MuertePorCansancioException{
		double nuevaHambre = puntosHambre + hambre;
		double nuevaEnergia = puntosEnergia+energia;
		
		if(nuevaHambre > PUNTOS_HAMBRE){
			puntosHambre = PUNTOS_HAMBRE;
		}else{puntosHambre += hambre;}
		
		if( nuevaEnergia > PUNTOS_ENERGIA){
			puntosEnergia = PUNTOS_ENERGIA;
		}else{puntosEnergia += energia;}
		
		if(puntosFelicidad + felicidad > PUNTOS_FELICIDAD){
			puntosFelicidad = PUNTOS_FELICIDAD;
		}else{puntosFelicidad += felicidad;}
		
		
		if(puntosHambre <= 0){
			puntosHambre = 0;
		}
		if(puntosEnergia <= 0){
			puntosEnergia = 0;
		}

		if(puntosHambre==0) throw new MuertePorNoComerException();
		
		if(puntosEnergia==0) throw new MuertePorCansancioException();
		
	}

	/**
	 * Método que modifica los puntos de energía y felicidad de la mascota cuando duerme.
	 *
	 * @param felicidad La cantidad de puntos de felicidad a restar cuando se duerme la mascota.
         * @throws MuertePorAburrimientoException Si la mascota duerme demasiado y sus puntos de felicidad son menores o iguales a cero.
	 */
	public void dormir(double felicidad) throws MuertePorAburrimientoException{
		puntosEnergia = PUNTOS_ENERGIA; //siempre recupera el sueño
		puntosFelicidad -= felicidad; //disminuye su felicidad
		
		if(puntosFelicidad<=0){
			puntosFelicidad = 0;
			throw new MuertePorAburrimientoException();
		}
		
	}

	/**
	 * Método que modifica los puntos de hambre y felicidad de la mascota cuando es alimentada.
	 *
	 * @param p El producto con el que se alimentará a la mascota virtual
         * @throws MuertePorIntoxicacionException Si los puntos de hambre de la mascota son iguales o menores a cero debido a lo que comió.
         * @throws MuertePorAburrimientoException Si los puntos de felicidad de la mascota son iguales o menores a cero debido a lo que comió.
	 */
	public void comer(Producto p) throws MuertePorIntoxicacionException, MuertePorAburrimientoException{
		double nuevaHambre = puntosHambre + p.modificaHambre();
		double nuevaFelicidad = puntosFelicidad + p.modificaFelicidad();
		
		if(nuevaHambre > PUNTOS_HAMBRE){
			puntosHambre = PUNTOS_HAMBRE;
		}else{ puntosHambre += p.modificaHambre();}
		
		if( nuevaFelicidad > PUNTOS_FELICIDAD){
			puntosFelicidad = PUNTOS_FELICIDAD;
		}else{ puntosFelicidad += p.modificaFelicidad();}
		
		
		if(puntosFelicidad <= 0){
			puntosFelicidad = 0;
		}
		if(puntosHambre <= 0){
			puntosHambre = 0;
		}
		
		
		if(puntosHambre==0) throw new MuertePorIntoxicacionException();
		if(puntosFelicidad==0) throw new MuertePorAburrimientoException();
		
	}
}
