package Minijuegos;

public class Caso{
    private String texto;
    private double dineroObtenido;
    private double puntosHambre;
    private double puntosFelicidad;
    private double puntosEnergia;
    private boolean muere = false;

    public Caso(String texto, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad){
        this.texto = texto;
        this.dineroObtenido = dineroObtenido;
        this.puntosHambre = puntosHambre;
        this.puntosFelicidad = puntosFelicidad;
        this.puntosEnergia = puntosEnergia;
    }

    public Caso(String texto, double dineroObtenido, double puntosHambre, double puntosEnergia, double puntosFelicidad, boolean muere){
        this.texto = texto;
        this.dineroObtenido = dineroObtenido;
        this.puntosHambre = puntosHambre;
        this.puntosFelicidad = puntosFelicidad;
        this.puntosEnergia = puntosEnergia;
        this.muere = muere;
    }

    public void asignarTexto(String texto){
        this.texto = texto;
    }

    public void asignarDineroObtenido(double dineroObtenido){
        this.dineroObtenido = dineroObtenido;
    }

    public double modificaHambre(){
        return puntosHambre;
    }

    public double modificaFelicidad(){
        return puntosFelicidad;
    }

    public double modificaEnergia(){
        return puntosEnergia;
    }

    public boolean obtenerMuerte(){
        return muere;
    }

    public double obtenerDinero(){
        return dineroObtenido;
    }

    public String textoResultado(){
        return texto;
    }

}