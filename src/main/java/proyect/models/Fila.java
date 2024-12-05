package proyect.models;

public class Fila {

    private int numero;
    private double tiempoLLegada;
    private double duracionServicio;

    public double getDuracionServicio() {
        return duracionServicio;
    }
    public int getNumero() {
        return numero;
    }
    public double getTiempoLLegada() {
        return tiempoLLegada;
    }
    
    public Fila(int numero, double tiempoLLegada, double duracionServicio) {
        this.numero = numero;
        this.tiempoLLegada = tiempoLLegada;
        this.duracionServicio = duracionServicio;
    }
    @Override
    public String toString(){
        String salida = "";
        salida+=getNumero()+"\t"+getTiempoLLegada()+"\t"+getDuracionServicio();
        return salida;
    }
}
