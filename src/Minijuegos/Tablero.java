package Minijuegos;

import java.util.Random;
import java.util.Scanner;

/**
* Clase que crea los metodos necesarios para un minijuego.
*
* El objetivo es alcanzar una moneda que se coloca al azar dentro del tablero
* desde una posicion generada al azar representada por una tortuga.
*
* @author paolasanv
* @version noviembre 2023
*
*/
public class Tablero{
	
	/**
	* Tamaño del tablero
	*/
	private final int TAMANIO=15;
	/**
	* Tablero tipo string
	*/
	private String[][] tablero; 
	/**
	* Cadena de la imagen de una tortuga
	*/
	private String codigoTortuga = " \uD83D\uDC22";
	/**
	* Cadena de la imagen de una moneda
	*/
	private String moneda = " \uD83E\uDE99";
	/**
	* Objeto TortugaMecanica
	*/
	private TortugaMecanica tortuga;
	/**
	* Posicion actual de la tortuga en el eje X
	*/
	private int tortugaPosicionX; 
	/**
	* Posicion actual de la tortuga en el eje Y
	*/
	private int tortugaPosicionY;
	/**
	* Posicion actual de la moneda en el eje X
	*/
	private int posicionMonedaX;
	/**
	* Posicion actual de la tortuga en el eje Y
	*/
	private int posicionMonedaY;
	/**
	* Objeto Random
	*/
	private Random random = new Random();
	/**
	* Booleano que indica si el usuario completó el juego adecuadamente
	*/
	private boolean esGanador=false;
	/**
	* Cantidad de monedas que el usuario puede ganar
	*/
	double monedasGanadas=0;
	
	/**
	* Contructor por omision. Inicializa las variables y coloca al azar
	* la posicion de la tortuga y la moneda en el tablero
	*
	*/
	public Tablero(){
		int posicionX = random.nextInt(15); //coordenadas de la tortuga 
		int posicionY = random.nextInt(15);
		posicionMonedaX =  random.nextInt(15);
		posicionMonedaY =  random.nextInt(15);
		
		tortuga = new TortugaMecanica(posicionX , posicionY);
		
		tablero = new String[TAMANIO][TAMANIO]; 
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[i].length; j++){
				tablero[i][j]=" - ";
			}
		} 
		tablero[posicionX][posicionY]=codigoTortuga;
		tortugaPosicionX  = posicionX;
		tortugaPosicionY = posicionY;
		
		tablero[posicionMonedaX][posicionMonedaY] = moneda;
	}
	
	/**
	* Devuelve la cantidad de monedas ganadas
	*/
	public double monedas(){
		return monedasGanadas;
	}
	
	/**
	* Devuelve si el usuario completo el juego adecuadamente
	*
	*@return esGanador
	*/
	public boolean esGanador(){
		return esGanador;
	}
	
	/**
	* Si la posicion de la tortuga es igual a la posicion de la moneda, entonces
	* el usuario ha llegado a la meta y el juego finaliza
	*
	* return true si la posicion de la moneda es igual a la posicion de la tortuga, false en caso contrario
	*/
	public boolean esMeta(){
		if((tortugaPosicionX == posicionMonedaX) && (tortugaPosicionY==posicionMonedaY)){
			esGanador = true;
			return true;
		}
		return false;
	}
	
	/**
	* Imprime el tablero
	*/
	private void imprimeTablero(){
		System.out.println("\n"+"		 T A B  L E R O "+"\n");
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[i].length; j++){
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
	}

	/**
	* Metodo que verifica que la cantidad de casillas que el usuario 
	* se quiere desplazar en el tablero sea menor al ancho de este
	*
	*@param numCasillas el numero de casillas a moverse
	*@throws ArrayIndexOutOfBoundsException si la cantidad de casillas a moverse es mayor que el ancho del tablero
	*/
	private void verificarMovimiento(int numCasillas){
		if(numCasillas>TAMANIO || numCasillas<0) throw new ArrayIndexOutOfBoundsException();
	}
	
	/**
	* Imprime un mensaje notificando que el juego ha sido completado
	* si el usuario ha llegado a la meta
	*/
	private void mensajeGanador(){
		System.out.println("	-----------------------------------------------");
		System.out.println("¡Felicidades! La tortuga alcanzo la moneda y logro hacer amigos");
		System.out.println("	-----------------------------------------------");
		imprimeTablero();
		System.out.println("\n"+"			Gracias por ayudar a la tortuga :3");
	}

	/**
	* Metodo para deplazarse en el tablero según la elección del usuario
	*
	*@param movimiento direccion del desplazamiento
	*@param n numero de casillas a desplazarse
	*/
	private void desplazar(String movimiento, int n){
		int posicionX=0;
		int posicionY=0;
		int nuevaX;
		int nuevaY;
		
		switch(movimiento){
		case "arriba": //Desplazarse hacia arriba
			posicionX = tortuga.getX();
			posicionY = tortuga.getY();
			nuevaX = posicionX -n; 
				
			try{
				verificarMovimiento(nuevaX);
				tortuga.setX(nuevaX);
				
				tablero[tortugaPosicionX][tortugaPosicionY]=" * ";
					
				for(int i=nuevaX; i<posicionX+1; i++){ 
					for(int j=0; j<TAMANIO; j++){
					//	tablero[i][posicionY]=" * ";
						if(i==nuevaX){
							tablero[i][posicionY]=codigoTortuga;
							tortugaPosicionX = i;
							tortugaPosicionY = posicionY;
						}else{
							tablero[i][posicionY]=" * ";
						}
					}
				}
				System.out.println("\n"+"		¡Movimiento realizado con exito!");
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("\n"+"		No puedes hacer este movimiento. ¡Sales del tablero!"+"\n");
			}

			break;
			
		case "abajo": //Desplazarse hacia abajo
			posicionX = tortuga.getX();
			posicionY = tortuga.getY();
			nuevaX = posicionX +n; 
				
			try{
				verificarMovimiento(nuevaX);
				tortuga.setX(nuevaX); 
				
				tablero[tortugaPosicionX][tortugaPosicionY]=" * ";
					
				for(int i=posicionX; i<nuevaX+1; i++){
					for(int j=0; j<TAMANIO; j++){
						//tablero[i][posicionY]=" * ";
						if(i==nuevaX){
							tablero[i][posicionY]=codigoTortuga;
							tortugaPosicionX = i;
							tortugaPosicionY = posicionY;
						}else{
							tablero[i][posicionY]=" * ";
						}
					}
				}
				System.out.println("\n"+"		¡Movimiento realizado con exito!");
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("\n"+"	No puedes hacer este movimiento. ¡Sales del tablero!");
			}
						
				
			break;

		case "izquierda": //Desplazarse a la izquierda
			posicionX = tortuga.getX();
			posicionY = tortuga.getY();
			nuevaY = posicionY -n; 
			try{
				verificarMovimiento(nuevaY);
				tortuga.setY(nuevaY);
				
				tablero[tortugaPosicionX][tortugaPosicionY]=" * ";
				
				for(int i=0; i<TAMANIO; i++){
					for(int j=nuevaY; j<posicionY; j++){
						//tablero[posicionX][j]=" * ";
						if(j==nuevaY){
							tablero[posicionX][j]=codigoTortuga;
							tortugaPosicionX = posicionX;
							tortugaPosicionY = j;
						}else{
							tablero[posicionX][j]=" * ";
						}
					}
				}
				System.out.println("\n"+"		¡Movimiento realizado con exito!");
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("\n"+"	No puedes hacer este movimiento. ¡Sales del tablero!");
			}
			
			break;

		case "derecha": //Desplazarse a la derecha
			posicionX = tortuga.getX();
			posicionY = tortuga.getY();
			nuevaY = posicionY +n; 
			try{
				verificarMovimiento(nuevaY);
				tortuga.setY(nuevaY);	
				
				tablero[tortugaPosicionX][tortugaPosicionY]=" * ";
				
				for(int i=0; i<TAMANIO; i++){
					for(int j=posicionY; j<nuevaY+1; j++){
						//tablero[posicionX][j]=" * ";
						if(j==nuevaY){
							tablero[posicionX][j]=codigoTortuga;
							tortugaPosicionX = posicionX;
							tortugaPosicionY = j;
						}else{
							tablero[posicionX][j]=" * ";
						}
					}
				}
				System.out.println("\n"+"		¡Movimiento realizado con exito!");
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("\n"+"	No puedes hacer este movimiento. ¡Sales del tablero!");
			}
			break;
			default: 
				System.out.println("\n"+"	¡Ese movimiento no existe!");
		}
	}
	
	/**
	* Metodo principal que ejecuta el juego
	*/
	public void jugarTortugaMecanica(){
		Scanner sc = new Scanner(System.in);
		Tablero t = new Tablero();
		
		int opcion=0;
		int op=0;
		int seleccion=0;
		int numero=0;
		boolean repetir=true;
		String movimiento="";
		
		System.out.println("\n"+" 				->-> MINIJUEGO DE LA TORTUGA MECÁNICA <-<- " + "\n");
		System.out.println("");
		System.out.println("¡Bienvenido! En este minijuego, debes ayudar a una tortuga mecanica que esta en busca");
		System.out.println("de una moneda dorada que le ayudara a funcionar sin baterias, ya que las tortugas terrestres");
		System.out.println("y acuaticas no lo quieren cerca U.U (dicen que es poco eco-friendly).");
		System.out.println("");
		System.out.println("Como la tortuga esta hecha de un metal muy pesado, debes recoger la moneda en el punto exacto.");
		System.out.println("(Es decir, en el tablero debes colocar a la tortuga JUSTO encima de la moneda, ni mas, ni menos)");
		System.out.println("Ya que sus patas de metal puden aplastar la moneda, perdiendo su oprtunidad de hacer amigos :(");
		System.out.println("(aunque tu solo perderas una partida)");
		System.out.println("");
		System.out.println("					¡Mucha suerte!");
						   
		do{
		System.out.println("\n"+"		------ Acciones disponibles ------");
		System.out.println("		1.	Ver tablero");
		System.out.println("		2.	Moverse en el tablero");
		System.out.println("		0.	Terminar partida");
		System.out.println("		---------------------------------");
		System.out.print("");	
		System.out.print("\n"+" Seleccione un numero correspondiente a la accion que deseas realizar: ");
		
		while(true){
			try {
				String opcionUsuario = sc.nextLine();
				opcion =  Integer.parseInt(opcionUsuario);
				if(opcion >-1 && opcion < 3){ 
				break;
				}else{ System.out.print("		Por favor, elige una opción válida: ");}
			}catch (NumberFormatException ex){
					System.out.print("		Por favor, elige una opción válida: "); }
		}

		switch(opcion){
			case 0:
				monedasGanadas = 5;
				System.out.println("\n"+"			Bueno, se intento.");
				System.out.println("\n"+"	La tortuga tendra que buscar otro tipo de amigos o.O");	
				repetir=false;
			break;				
			case 1:
				t.imprimeTablero();
			break;
			case 2: 
				System.out.println("\n"+"		>>>>>>>> MOVERSE EN EL TABLERO <<<<<<<");
				System.out.println("		Desplazarse hacia...");
				System.out.println("			 (1) arriba");
				System.out.println("			 (2) abajo");
				System.out.println("			 (3) izquierda");
				System.out.println("			 (4) derecha");	
				System.out.println("		>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
				System.out.print("\n"+"-->Para moverte en el tablero, escribe el numero correspondiente a la accion: ");
				
				while(true){
					try {
						String opcionUsuario = sc.nextLine();
						op =  Integer.parseInt(opcionUsuario);	
						if(op >0 && op < 5){ break;
						}else{ System.out.print("		Por favor, escribe un numero valido: ");}
					}catch (NumberFormatException ex){
						System.out.print("		Por favor, escribe un numero: "); 
						}
					}			
					
				System.out.print("\n"+"-->¿Cuantas casillas deseas desplazarte? ");
					while(true){
						try{
							String opcionUsuario = sc.nextLine();
							numero =  Integer.parseInt(opcionUsuario);	
							if(numero>=0){break;
							}else{System.out.print("		Por favor, escribe un numero positivo: "); }
						}catch (NumberFormatException ex){
							System.out.print("		Por favor, escribe un numero: "); 
						}
					}		
				if(op==1){
					t.desplazar("arriba", numero);
					if(t.esMeta()){
						t.mensajeGanador();
						monedasGanadas = 30;
						repetir = false;
					}
				}else if(op==2){
					t.desplazar("abajo", numero);
					if(t.esMeta()){	
						t.mensajeGanador();
						monedasGanadas = 30;
						repetir = false;
					}
				}else if(op==3){
					t.desplazar("izquierda", numero);
					if(t.esMeta()){
						t.mensajeGanador();
						monedasGanadas = 30;
						repetir = false;
					}
				}else if(op==4){
					t.desplazar("derecha", numero);
					if(t.esMeta()){
						t.mensajeGanador();
						monedasGanadas = 30;
						repetir = false;
					}
				}	
					break;	
			}
		}while(repetir);
		}
	
	/**
	* Clase que guarda las coordenadas del desplazamiento de una tortuga mecanica
	*
	* @author paolasanv
	* @version noviembre 2023
	*
	*/
	private class TortugaMecanica{
		
	/**
	* Posicion en el eje x
	*/
	private int x;
	/**
	* Posicion en el eje y
	*/
	private int y;

	/**
	* Contructor que recibe como parametro la posicion inicial de la tortuga
	* @param posicionX
	* @param posicionY
	*/
	public TortugaMecanica(int posicionX, int posicionY){
		x = posicionX;
		y = posicionY;
	}

	/**
	* Modifica la posicion con respecto al eje x
	*/
	public void setX(int posicion){
		x = posicion;
	}

	/**
	* Modifica la posicion con respecto al eje y
	*/
	public void setY(int posicion){
		y = posicion;
	}
	
	/**
	* Devuelve la posicion del eje x
	*
	*return x
	*/
	public int getX(){
		return x;
	}

	/**
	* Devuelve la posicion del eje y
	*
	*@return y
	*/
	public int getY(){
		return y;
	}
	
	/**
	* Devuelve las coordenadas de la tortuga
	*
	*@return cadena con la informacion
	*/
	public String toString(){
		return "Posicion x:" + x + "Posicion Y:" + y;
	}
		
	}//End TortugaMecanica
}