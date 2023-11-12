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
    private boolean muere = false;
    

    public ConstructorEventos(String codigo, String titulo, String descripcion, int dificultad, int numCasos, int rangoProb){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        casos = new Caso[numCasos];
        valorResultado = rangoProb;
        this.rangoProb = new Integer[rangoProb];
    }
/* 
    public ConstructorEventos(String codigo, String titulo, String descripcion, int dificultad, int numCasos, int rangoProb, boolean muere){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        casos = new Caso[numCasos];
        valorResultado = rangoProb;
        this.rangoProb = new Integer[rangoProb];
        this.muere = muere;
    }
    */

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
        int contador = amplitudProb;
        for(int i = 0; i < rangoProb.length; i++){
            if(rangoProb[i] == null && contador > 0){
                rangoProb[i] = contadorCaso;
                contador--;
            }
        }
        contadorCaso++;
    }

    public void asignarMuerte(boolean muere){
        this.muere = muere;
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

    public boolean obtenerMuerte(){
        return muere;
    }

    public double obtenerDinero(){
        return dineroObtenido;
    }

    public String obtenerCodigo(){
        return codigo;
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

    public void agregarCaso(String resultado, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad, int amplitudProb){
        for(int i = 0; i < casos.length; i++){
            if(casos[i] == null){
                if(muere){
                    casos[i] = new Caso(resultado, dineroObtenido, puntosHambre, puntosEnergia, puntosFelicidad, true);
                }else{
                    casos[i] = new Caso(resultado, dineroObtenido, puntosHambre, puntosEnergia, puntosFelicidad);
                }
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
                asignarMuerte(casos[valorCasilla].obtenerMuerte());
                System.out.println("\n       --RESULTADO--");
                System.out.println("\n" + imprimeResultado());
            }
        }
    }



    public String imprimeResultado(){
        return resultadoTexto;
    }
}