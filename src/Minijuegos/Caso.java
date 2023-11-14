package Minijuegos;

/**
 * Clase que define un caso de ocurrencia dentro de un evento.
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class Caso{
    /**
     * texto a imprimir cuando ocurre un caso.
     */
    private String texto;
    /**
     * Cantidad de dinero que se gana al ocurrir un evento
     */
    private double dineroObtenido;
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
     * Booleano que define por defecto que la mascota no muere
     */
    private boolean muere = false;

    /**
     * Constructor por parámetros de un caso
     *
     * @param texto Resultado del caso
     * @param dineroObtenido La cantidad de dinero ganado en el caso
     * @param puntosHambre Los puntos de hambre a modificar en la mascota
     * @param puntosEnergia Los puntos de energia a modificar en la mascota
     * @param puntosFelicidad Los puntos de felicidad a modificar en la mascota
     */
    public Caso(String texto, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad){
        this.texto = texto;
        this.dineroObtenido = dineroObtenido;
        this.puntosHambre = puntosHambre;
        this.puntosFelicidad = puntosFelicidad;
        this.puntosEnergia = puntosEnergia;
    }

    /**
     * Constrcutor por parámetros de un caso donde la mascota muere. 
     *
     * @param texto Resultado del caso
     * @param dineroObtenido La cantidad de dinero ganado en el caso
     * @param puntosHambre Los puntos de hambre a modificar en la mascota
     * @param puntosEnergia Los puntos de energia a modificar en la mascota
     * @param puntosFelicidad Los puntos de felicidad a modificar en la mascota
     * @param muere Valor booleano que determina si la mascota muere
     */
    public Caso(String texto, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad, boolean muere){
        this.texto = texto;
        this.dineroObtenido = dineroObtenido;
        this.puntosHambre = puntosHambre;
        this.puntosFelicidad = puntosFelicidad;
        this.puntosEnergia = puntosEnergia;
        this.muere = muere;
    }

    /**
     * Método que asigna el texto de un caso.
     * @param texto
     */
    public void asignarTexto(String texto){
        this.texto = texto;
    }

    /**
     * Método que asigna el dinero obtenido de un caso.
     * @param dineroObtenido
     */
    public void asignarDineroObtenido(double dineroObtenido){
        this.dineroObtenido = dineroObtenido;
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
     * Método que devuelve un string con el texto del resultado.
     * @return texto
     */
    public String textoResultado(){
        return texto;
    }

}
