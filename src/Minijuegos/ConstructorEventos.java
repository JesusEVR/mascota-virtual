package Minijuegos;

import java.util.Random;

/**
 * Clase que define un evento con resultados de cantidad y probabilidad variable, la cual puede ser ajustada
 * en su creación.
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class ConstructorEventos{
    /**
     * Código que identifica al evento
     */
    private String codigo;
    /**
     * título del evento
     */
    private String titulo;
    /*
     * Descripción del evento
     */
    private String descripcion;
    /**
     * Dificultad para clasificar los eventos según la probabilidad
     */
    private int dificultad;
    /**
     * Casos posibles que pueden ocurrir en un evento
     */
    public Caso[] casos;
    /**
     * Rango de probabilidad que se va a manejar en el evento,
     * es decir el valor que ocupa el denominador en la probabilidad.
     * 
     * Dentro de este arreglo se puede ajustar la amplitud de la probabilidad de cada caso.
     */
    private Integer[] rangoProb;
    /**
     * Valor de los puntos que se pierde/gana en el atributo hambre de la mascota
     */
    private double puntosHambre;
    /**
     * Valor de los puntos que se pierde/gana en el atributo felicidad de la mascota
     */
    private double puntosFelicidad;
    /**
     * Valor de los puntos que se pierde/gana en el atributo energía de la mascota
     */
    private double puntosEnergia;
    /**
     * Cantidad de dinero que se gana al ocurrir un evento
     */
    private double dineroObtenido;
    /**
     * valor para identificar un caso en el rango de probabilidad
     */
    private int contadorCaso = 0;
    /**
     * valor que define el tamanio del rango de la probabilidad
     */
    private int tamanioProb;
    /**
     * Texto del caso resultante
     */
    private String resultadoTexto;
    /**
     * booleano que define si la mascota muere en el evento
     */
    private boolean muere = false;
    
    /**
     * Constructor por parámetros de un Evento.
     *
     * @param codigo Identificador del evento
     * @param titulo Titulo del evento
     * @param descripcion Descripcion del evento
     * @param dificultad Dificultad del evento
     * @param numCasos Número de casos posibles
     * @param rangoProb Rango de la probabilidad asignable a los casos
     */
    public ConstructorEventos(String codigo, String titulo, String descripcion, int dificultad, int numCasos, int rangoProb){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        casos = new Caso[numCasos];
        tamanioProb = rangoProb; 
        this.rangoProb = new Integer[rangoProb];
    }

    /**
     * Método que asigna los puntos de hambre a modificar en la mascota.
     * @param puntosHambre
     */
    public void asignarPuntosHambre(double puntosHambre){
        this.puntosHambre = puntosHambre;
    }

    /**
     * Método que asigna los puntos de felicidad a modificar en la mascota.
     * @param puntosFelicidad
     */
    public void asignarPuntosFelicidad(double puntosFelicidad){
        this.puntosFelicidad = puntosFelicidad;
    }

    /**
     * Método que asigna los puntos de energía a modificar en la mascota.
     * @param puntosEnergia
     */
    public void asignarPuntosEnergia(double puntosEnergia){
        this.puntosEnergia = puntosEnergia;
    }

    /**
     * Método que asigna el dinero obtenido (pejecoins) de un evento.
     * @param dineroObtenido
     */
    public void asignarDineroObtenido(double dineroObtenido){
        this.dineroObtenido = dineroObtenido;
    }

    /**
     * Método que asigna la probabilidad de un caso dentro del arreglo []rangoProb.
     * ej: 3/15.
     * 3 es la amplitud de probabilidad
     * 15 es el tamaño de []rangoProb
     * @param amplitudProb probabilidad de ocurrencia de un caso
     */
    public void asignarAmplitudProb(int amplitudProb){
        int contador = amplitudProb;
        for(int i = 0; i < rangoProb.length; i++){
            if(rangoProb[i] == null && contador > 0){
                rangoProb[i] = contadorCaso;
                contador--;
            }
        }
        contadorCaso++; //numero de referencia a un caso dentro de rangoProb
    }

    /**
     * Método que asigna si la mascota muere durante un evento o caso.
     * @param muere
     */
    public void asignarMuerte(boolean muere){
        this.muere = muere;
    }

    /**
     * Método que devuelve los puntos de Hambre a modificar en la mascota.
     * @return puntosHambre
     */
    public double modificaHambre(){
        return puntosHambre;
    }

    /**
     * Método que devuelve los puntos de Energía a modificar en la mascota.
     * @return puntosEnergia
     */
    public double modificaEnergia(){
        return puntosEnergia;
    }

    /**
     * Método que devuelve los puntos de Felicidad a modificar en la mascota.
     * @return puntosFelicidad
     */
    public double modificaFelicidad(){
        return puntosFelicidad;
    }

    /**
     * Método que determina si la mascota ha muerto.
     * @return muere - verdadero si la mascota está muerta, falso si está viva.
     */
    public boolean obtenerMuerte(){
        return muere;
    }

    /**
     * Método que devuelve la cantidad de dinero obtenido.
     * @return dineroObtenido
     */
    public double obtenerDinero(){
        return dineroObtenido;
    }

    /**
     * Método que devuelve el código asociado.
     * @return codigo
     */
    public String obtenerCodigo(){
        return codigo;
    }

    /**
     * Método que devuelve el nivel de dificultad.
     * @return dificultad
     */
    public int obtenerDificultad(){
        return dificultad;
    }

    /**
     * Método que devuelve el título correspondiente.
     * @return titulo
     */
    public String obtenerTitulo(){
        return titulo;
    }

    /**
     * Método que devuelve la descripción asociada.
     * @return descripcion
     */
    public String obtenerDescripcion(){
        return descripcion;
    }

    /**
     * Método que agrega un caso al arreglo de casos, con sus valores definidos.
     *
     * @param resultado El texto del resultado del caso
     * @param dineroObtenido El dinero ganado del caso
     * @param puntosHambre Los puntos de Hambre a modificar
     * @param puntosEnergia Los puntos de energia a modificar
     * @param puntosFelicidad Los puntos dse felicidad a modificar
     * @param amplitudProb La probabilidad de ocurrencia del caso dentro del arreglo []rangoProb
     */
    public void agregarCaso(String resultado, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad, int amplitudProb){
        for(int i = 0; i < casos.length; i++){
            if(casos[i] == null){
                if(muere){ //se crea un objeto Caso donde se guarda si la mascota muere
                    casos[i] = new Caso(resultado, dineroObtenido, puntosHambre, puntosEnergia, puntosFelicidad, true);
                }else{
                    casos[i] = new Caso(resultado, dineroObtenido, puntosHambre, puntosEnergia, puntosFelicidad);
                }
                asignarAmplitudProb(amplitudProb);
                return;
            }
        }
    }

    /**
     * Método que obtiene al azar el resultado de un evento, y
     * asigna los valores resultantes del caso ocurrido.
     */
    public void obtenerResultado(){
        Random r = new Random();
        int numGanador = r.nextInt(tamanioProb); //numero que hace referencia a la casilla del arreglo
        int valorCasilla = rangoProb[numGanador];

        for(int i = 0; i < casos.length; i++){
            if(i == valorCasilla){
                asignarDineroObtenido(casos[valorCasilla].obtenerDinero());
                asignarPuntosHambre(casos[valorCasilla].modificaHambre());
                asignarPuntosEnergia(casos[valorCasilla].modificaEnergia());
                asignarPuntosFelicidad(casos[valorCasilla].modificaFelicidad());
                resultadoTexto = casos[valorCasilla].textoResultado();
                asignarMuerte(casos[valorCasilla].obtenerMuerte());
                System.out.println("\n       --RESULTADO--");
                System.out.println("\n" + imprimeResultado());
            }
        }
    }

    /**
     * Método que devuelve un String con el texto del caso resultante
     * @return texto del caso resultante
     */
    public String imprimeResultado(){
        return resultadoTexto;
    }
}
