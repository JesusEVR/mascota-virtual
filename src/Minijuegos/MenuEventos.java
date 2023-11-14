package Minijuegos;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Menú del minijuego 'Eventos' que se imprime para el usuario a través del objeto Hogar.
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class MenuEventos{
    /**
     * Puntos de hambre que se sumarán o restarán a la mascota virutal al jugar un evento
     */
    private double puntosHambre;
    /**
     * Puntos de energía que se sumaraán o restarán a la mascota al jugar un evento.
     */
    private double puntosEnergia;
    /**
     * Puntos de felicidad que se sumarán o restarán a la mascota al jugar un evento.
     */
    private double puntosFelicidad;
    /**
     * Dinero que obtiene el jugador al jugar un evento y resultar en un final bueno.
     */
    private double dineroObtenido;
    /**
     * Booleano que determina si la mascota ha muerto.
     */
    private boolean muere = false ;
    /**
     * Lista de eventos del minijuego.
     */
    private ListaJuegos listaEventos;
    /**
     * Booleano que determina si e jugador aceptó jugar al minijuego 'Eventos'.
     */
    private boolean decidioJugar = true;
    /**
     * Objeto de tipo scanner para que el usuario pueda escribir respuestas.
     */
    public Scanner sc = new Scanner(System.in);

    /**
     * Constructor por omisión del menú.
     */
    public MenuEventos(){
        
        boolean activo = true;
        
        int opcion = 0;
        
        while(activo){
            System.out.println("\n"+" 				->-> E V E N T O S <-<- " + "\n");
            System.out.println();
            System.out.println("¡Bienvenido a los eventos, donde puedes salir a explorar el");
            System.out.println(" mundo con tu mascota y realizar todo tipo de actividades!");
            System.out.println("Cuando participas un evento, pueden ocurrir diversos escenarios en los que tú y tu mascota");
            System.out.println("puedan ganar monedas por ello, pero también esta la posibilidad de fallar y perder moneditas.");
            System.out.println();
            System.out.println("Tu mascota cambia sus estadisticas dependiendo del evento.");
            System.out.println("A mayor dificultad, es mayor el rango en el que le puede dar hambre, cansarse y");
            System.out.println("modificar su felicidad. Además, también aumenta el riesgo o recompensa por evento.");
            System.out.println();
            System.out.println();
            System.out.println("          -------Dificultad -------");
            System.out.println("			1. Facil");
            System.out.println("			2. Medio");
            System.out.println("			3. Dificil");
            System.out.println("			4. EXTREMO");
            System.out.println("			0. Salir");
            System.out.println("          --------------------------");
            System.out.println();
            System.out.print("Elige una opcion: ");
        
            try {
                String opcionUsuario = sc.nextLine();
                opcion =  Integer.parseInt(opcionUsuario);
                if(opcion == 0){
                    decidioJugar = false;
                    break;
                }
                else if(opcion >-1 && opcion < 5){ 
                    verEventos(opcion);
                    System.out.print("      Escribe el numero del evento: ");
                    String codigoEvento = sc.nextLine();
                    if(seleccionarEvento(codigoEvento, opcion) == true){
                        break;
                    } 
                } else { 
                    System.out.print("		Por favor, elige una opcion valida: ");
                }
            }catch (NumberFormatException ex) {
                System.out.print("		Por favor, elige una opcion valida: "); 
            }

        }
    
    }

     /**
     * Devuelve el atributo decidioJugar
     * @return decidioJugar
     */
    public boolean jugado(){
        return decidioJugar;
    }
    
    /**
     * Devuelve el atributo puntosHambre
     * @return puntosHambre
     */
    public double modificaHambre(){
        return puntosHambre;
    }

    /**
     * Devuelve el atributo puntosEnergia
     * @return puntosEnergia
     */
    public double modificaEnergia(){
        return puntosEnergia;
    }

    /**
     * Devuelve el atributo puntosFelicidad
     * @return puntosFelicidad
     */
    public double modificaFelicidad(){
        return puntosFelicidad;
    }

    /**
     * Devuelve el atributo dineroObtenido.
     * @return dineroObtenido
     */
    public double obtenerDinero(){
        return dineroObtenido;
    }

    /**
     * Devuelve el atributo muere.
     * @return muere Un booleano que determina si la mascota murió.
     */
    public boolean obtenerMuerte(){
        return muere;
    }
    
    /**
     * Método que recorre la lista de eventos e imprime la información necesaria para el usuario, dependiendo la dificultad que haya elegido.
     * @param dificultad La dificultad que eligió el jugador.
     */
    public void verEventos(int dificultad){
            listaEventos = new ListaJuegos();
            ConstructorEventos con;
            Iterator i = listaEventos.creaIterador();
            while(i.hasNext()){
                con = (ConstructorEventos) i.next();
                if(con.obtenerDificultad() == dificultad){
                    System.out.print("Codigo: " + con.obtenerCodigo() + "   Evento: ");
                    System.out.println(con.obtenerTitulo());
                    System.out.println("" + con.obtenerDescripcion());
                    System.out.println();
                }
            }
    }

    /**
     * Método que selecciona un evento de la lista de eventos, a partir de datos dados por el jugador.
     *
     * @param codigo El código único de un evento que el usuario ingresó
     * @param dificultad La dificultad que el jugador escogió.
     * @return 'true' si la eleción de evento correpondió a la dificultad, 'false' en otro caso.
     */
    public boolean seleccionarEvento(String codigo, int dificultad){
        ConstructorEventos con;
        Iterator i = listaEventos.creaIterador();

        while(i.hasNext()){
            con = (ConstructorEventos) i.next();
            if(con.obtenerCodigo().equals(codigo) && con.obtenerDificultad() == dificultad){
                con.obtenerResultado();
                dineroObtenido = con.obtenerDinero();
                puntosHambre = con.modificaHambre();
                puntosEnergia = con.modificaEnergia();
                puntosFelicidad = con.modificaFelicidad();
                muere = con.obtenerMuerte();
                decidioJugar = true;
                System.out.println();
                return true;
            }
        }
        decidioJugar = false;
        System.out.println("El codigo es invalido.");
        return false;
    }
}
