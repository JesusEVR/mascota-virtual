package Minijuegos;

import java.util.Random;

public class ConstructorEventos{
    private String codigo;
    private String titulo;
    private String descripcion;
    private int dificultad;
    public Caso[] casos;
    private Integer[] rangoProb;
    private double puntosHambre;
    private double puntosFelicidad;
    private double puntosEnergia;
    private double dineroObtenido;
    private int contadorCaso = 0;
    private int valorResultado;
    private String resultadoTexto;

    public ConstructorEventos(String codigo, String titulo, String descripcion, int dificultad, int numCasos, int rangoProb){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        casos = new Caso[numCasos];
        valorResultado = rangoProb;
        this.rangoProb = new Integer[rangoProb];
    }

    public ConstructorEventos(){
    }

    public void asignarPuntosHambre(double puntosHambre){
        this.puntosHambre = puntosHambre;
    }

    public void asignarPuntosFelicidad(double puntosFelicidad){
        this.puntosFelicidad = puntosFelicidad;
    }

    public void asignarPuntosEnergia(double puntosEnergia){
        this.puntosEnergia = puntosEnergia;
    }

    public void asignarDineroObtenido(double dineroObtenido){
        this.dineroObtenido = dineroObtenido;
    }

    public void asignarAmplitudProb(int amplitudProb){
        for(int i = 0; i < amplitudProb; i++){
            if(rangoProb[i] == null){
                rangoProb[i] = contadorCaso;
            }
        }
        contadorCaso++;
    }

    public String obtenerCodigo(){
        return codigo;
    }

    public double obtenerDinero(){
        return dineroObtenido;
    }

    public int obtenerDificultad(){
        return dificultad;
    }

    public String obtenerTitulo(){
        return titulo;
    }

    public String obtenerDescripcion(){
        return descripcion;
    }

    public void agregarCaso(String resultado, double dineroObtenido, double puntosHambre, double puntosFelicidad, double puntosEnergia, int amplitudProb){
        for(int i = 0; i < casos.length; i++){
            if(casos[i] == null){
                casos[i] = new Caso(resultado, dineroObtenido, puntosHambre, puntosFelicidad, puntosEnergia);
                asignarAmplitudProb(amplitudProb);
                return;
            }
        }
    }

    public void obtenerResultado(){
        Random r = new Random();
        int numGanador = r.nextInt(valorResultado);
        int valorCasilla = rangoProb[numGanador];

        for(int i = 0; i < casos.length; i++){
            if(i == valorCasilla){
                asignarDineroObtenido(casos[valorCasilla].obtenerDinero());
                asignarPuntosHambre(casos[valorCasilla].modificaHambre());
                asignarPuntosEnergia(casos[valorCasilla].modificaEnergia());
                asignarPuntosFelicidad(casos[valorCasilla].modificaFelicidad());
                resultadoTexto = casos[valorCasilla].textoResultado();
            }
        }
    }

    public String imprimeResultado(){
        return resultadoTexto;
    }
}