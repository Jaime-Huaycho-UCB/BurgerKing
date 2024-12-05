package proyect.models.Resolucion;

import proyect.models.Excel;

public class UnServidor extends Servidor{

    public UnServidor(Excel excel,double tiempoObservacion){
        super(excel, tiempoObservacion);
    }

    @Override
    public void calcularP() {
        double p = getLambda()/getMiu();
        setP(p);
    }

    @Override
    public void calcularPo() {
        double Po = 1.00-getP();
        setPo(Po);
    }

    @Override
    public double calcularPn(int n) {
        double Pn = Math.pow(getP(), n) * getPo();
        return Pn;
    }

    @Override
    public void calcularLs() {
        double Ls = getLambda()/(getMiu()-getLambda());
        setLs(Ls);
    }

    @Override
    public void calcularLq() {
        double Lq = (Math.pow(getLambda(),2))/(getMiu()*(getMiu()-getLambda()));
        setLq(Lq);
    }

    @Override
    public void calcularWs() {
        double Ws = 1/(getMiu()-getLambda());
        setWs(Ws);
    }

    @Override
    public void calcularWq() {
        double Wq = getLambda()/(getMiu()*(getMiu()-getLambda()));
        setWq(Wq);
    }

    @Override
    public double probabilidadTiempoSistema(double t,String condicion){
        double salida = 0.00;
        if (condicion.equals(">")){
            salida=Math.pow(Math.E, -getMiu()*t*(1-getP()));
        }else{  
            salida=1.00-Math.pow(Math.E, -getMiu()*t*(1-getP()));
        }
        return salida;
    }

    @Override
    public double probabilidadTiempoCola(double t,String condicion){
        double salida = 0.00;
        if (condicion.equals(">")){
            salida=getP()*Math.pow(Math.E,-getMiu()*t);
        }else{  
            salida=1.00-(getP()*Math.pow(Math.E,-getMiu()*t));
        }
        return salida;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
