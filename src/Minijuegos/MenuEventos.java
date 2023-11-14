package Minijuegos;

import java.util.Iterator;
import java.util.Scanner;

public class MenuEventos{

    private double puntosHambre;
    private double puntosEnergia;
    private double puntosFelicidad;
    private double dineroObtenido;
    private boolean muere = false ;
    private ListaJuegos listaEventos;
    private boolean decidioJugar = true;

    Scanner sc = new Scanner(System.in);

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
        
    public boolean jugado(){
        return decidioJugar;
    }
    

    public double modificaHambre(){
        return puntosHambre;
    }

    public double modificaEnergia(){
        return puntosEnergia;
    }

    public double modificaFelicidad(){
        return puntosFelicidad;
    }

    public double obtenerDinero(){
        return dineroObtenido;
    }

    public boolean obtenerMuerte(){
        return muere;
    }

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
