package Minijuegos;

public class Caso{
    private String texto;
    private double dineroObtenido;
    private double puntosHambre;
    private double puntosFelicidad;
    private double puntosEnergia;

    public Caso(String texto, double dineroObtenido, double puntosHambre, double puntosFelicidad, double puntosEnergia){
        this.texto = texto;
        this.dineroObtenido = dineroObtenido;
        this.puntosHambre = puntosHambre;
        this.puntosFelicidad = puntosFelicidad;
        this.puntosEnergia = puntosEnergia;
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

    public double obtenerDinero(){
        return dineroObtenido;
    }

    public String textoResultado(){
        return texto;
    }

}