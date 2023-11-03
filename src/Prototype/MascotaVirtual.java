package Prototype;

import Composite.Producto;

public class MascotaVirtual implements Cloneable{

	private double PUNTOS_HAMBRE; //Este es el valor maximo
	private double PUNTOS_ENERGIA;
	private double PUNTOS_FELICIDAD;
	private double puntosHambre;
	private double puntosEnergia;
	private double puntosFelicidad;
	private double saldo;
	private String nombre;
	private String descripcion;
	private String imagenMascota; 
	private String mensajeSuenio;
	private String mensajeHambre;
	private String mensajeAburrido;
	private String mensajeFeliz;
	
	
	
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
	
	public void mensajeFeliz(String m){
		mensajeFeliz = m;
	}
	
	public void mensajeSuenio(String m){
		mensajeSuenio = m;
	}
	
	public void mensajeHambre(String m){
		mensajeHambre = m;
	}
	
	public void mensajeAburrido(String m){
		mensajeAburrido = m;
	}
	
	public void asignarPuntosHambre(double valorMaximo){
		if(puntosHambre!=0) throw new IllegalArgumentException("El valor máximo del atributo 'hambre' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosHambre = valorMaximo;
		PUNTOS_HAMBRE = valorMaximo;
	}
	
	public void asignarPuntosEnergia(double valorMaximo){
		if(puntosEnergia!=0) throw new IllegalArgumentException("El valor máximo del atributo 'energia' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosEnergia = valorMaximo;
		PUNTOS_ENERGIA = valorMaximo;
	}

	public void asignarPuntosFelicidad(double valorMaximo){
		if(puntosFelicidad!=0) throw new IllegalArgumentException("El valor máximo del atributo 'felicidad' ya fue asignado, no lo puedes modificar nuevamente"); //Los puntos ya fueron asignados
		puntosFelicidad = valorMaximo;
		PUNTOS_FELICIDAD = valorMaximo;
	}
	
	public void asignarSaldoInicial(double montoInicial){
		if(saldo!=0) throw new IllegalArgumentException("El saldo inicial ya fue asignado, no puedes regalar pejecoins"); 
		saldo = montoInicial;
	}
	
	public String nombre(){
		return nombre;
	}
	
	public double puntosHambre(){
		return puntosHambre;
	}
	
	public double puntosEnergia(){
		return puntosEnergia;
	}
	
	public double puntosFelicidad(){
		return puntosFelicidad;
	}

	public double saldo(){
		return saldo;
	}
	
	public void comprar(double monto) throws SaldoInsuficienteException{
		if(monto>saldo) throw new SaldoInsuficienteException();
		saldo -= monto;
	}

	public void depositar(double monto){
		saldo += monto;
	}
	
	public Object clone(){
		MascotaVirtual clon = new MascotaVirtual(nombre, descripcion, imagenMascota); 
		return clon;
	}
	
	public boolean estaAburrido(){
		double veintePorciento = PUNTOS_FELICIDAD * 0.2;
		if(puntosFelicidad <= veintePorciento) return true; //la felicidad esta al 20% o menos 
		return false;
	}
	
	public boolean tieneHambre(){
		double veintePorciento = PUNTOS_HAMBRE * 0.2;
		if(puntosHambre <= veintePorciento) return true;
		return false;
	}
	
	public boolean tieneSuenio(){
		double veintePorciento = PUNTOS_ENERGIA * 0.2;
		if(puntosEnergia <= veintePorciento) return true;
		return false;
	}
	
	public String estadoActual(){
		String estado="";
		
		if(puntosHambre<=0 || puntosEnergia<=0 ||puntosFelicidad<=0) return "Fallecido u.u";
		
		if(!tieneSuenio() && !tieneHambre() && !estaAburrido()){
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
	
	public String toString(){
		String mascota = "****************************************************************"+"\n"
			+ imagenMascota + "\n"
			+ "Nombre: " +nombre + "\n"
			+ "Descripcion: " + descripcion + "\n"
			+ "****************************************************************";
		return mascota;
	}
	
	public void jugar(double hambre, double energia, double felicidad)throws MuertePorNoComerException, MuertePorCansancioException{ //puntos que suman o restan a sus estadisticas
		double nuevaHambre = puntosHambre + hambre;
		double nuevaEnergia = puntosEnergia+energia;
		
		if(nuevaHambre<=0) throw new MuertePorNoComerException();
		if(nuevaEnergia<=0) throw new MuertePorCansancioException();
		
		if(nuevaHambre > PUNTOS_HAMBRE){
			puntosHambre = PUNTOS_HAMBRE;
		}else{puntosHambre += hambre;}
		
		if( nuevaEnergia > PUNTOS_ENERGIA){
			puntosEnergia = PUNTOS_ENERGIA;
		}else{puntosEnergia += energia;}
		
		if(puntosFelicidad + felicidad > PUNTOS_FELICIDAD){
			puntosFelicidad = PUNTOS_FELICIDAD;
		}else{puntosFelicidad += felicidad;}
		
	}
	
	public void dormir(double felicidad) throws MuertePorAburrimientoException{
		puntosEnergia = PUNTOS_ENERGIA; //siempre recupera el sueño
		puntosFelicidad -= felicidad; //disminuye su felicidad
		
		if(puntosFelicidad<=0) throw new MuertePorAburrimientoException();
		
	}
	
	public void comer(Producto p)throws MuertePorIntoxicacionException, MuertePorAburrimientoException{
		double nuevaHambre = puntosHambre + p.modificaHambre();
		double nuevaFelicidad = puntosFelicidad + p.modificaFelicidad();
		
		if(nuevaHambre<=0) throw new MuertePorIntoxicacionException();
		if(nuevaFelicidad<=0) throw new MuertePorAburrimientoException();
		
		if(nuevaHambre > PUNTOS_HAMBRE){
			puntosHambre = PUNTOS_HAMBRE;
		}else{ puntosHambre += p.modificaHambre();}
		
		if( nuevaFelicidad > PUNTOS_FELICIDAD){
			puntosFelicidad = PUNTOS_FELICIDAD;
		}else{ puntosFelicidad += p.modificaFelicidad() ; }
	}
}