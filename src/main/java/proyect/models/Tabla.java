package proyect.models;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<Fila> datos = new ArrayList<Fila>();
    public ArrayList<Fila> getDatos() {
        return datos;
    }

    public void agregarDatos(int numero,double tiempoLlegada,double tiempoServicio){
        this.datos.add(new Fila(numero,tiempoLlegada,tiempoServicio));
    }

    @Override
    public String toString(){
        String salida = "";
        for (Fila fila : getDatos()){
            salida+=fila.toString()+"\n";
        }
        return salida;
    }
}
