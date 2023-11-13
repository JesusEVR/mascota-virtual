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
            System.out.println("¡Bienvenido a los eventos, donde puedes salir salir a explorar el mundo con tu mascota");
            System.out.println("y realizar todo tipo de actividades!");
            System.out.println("Cuando realizas un evento, pueden ocurrir diversos escenarios en los que tu y tu mascota");
            System.out.println("lograrán completarlo y podrán ganar dinero, pero también está la posibilidad de fallar, e.");
            System.out.println("Incluso perder pejecoins.");
            System.out.println();
            System.out.println("Tu mascota cambiará sus estadísticas dependiendo del evento, a mayor dificultad,");
            System.out.println("es mayor el rango en que le puede dar hambre, cansarse, modificar su felicidad y también ");
            System.out.println("aumenta el riesgo/recompensa por evento.");
            System.out.println();
            System.out.println();
            System.out.println("          -------Dificultad -------");
            System.out.println("			1. Fácil");
            System.out.println("			2. Medio");
            System.out.println("			3. Difícil");
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
                    System.out.print("      Escribe el número del evento: ");
                    String codigoEvento = sc.nextLine();
                    if(seleccionarEvento(codigoEvento) == true){
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
                    System.out.print(" " + con.obtenerCodigo() + "   ");
                    System.out.println(con.obtenerTitulo());
                    System.out.println("	" + con.obtenerDescripcion());
                    System.out.println();
                }
            }
    }

    public boolean seleccionarEvento(String codigo){
        ConstructorEventos con;
        Iterator i = listaEventos.creaIterador();

        while(i.hasNext()){
            con = (ConstructorEventos) i.next();
            if(con.obtenerCodigo().equals(codigo)){
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
        System.out.println("El código es inválido.");
        return false;
    }
}