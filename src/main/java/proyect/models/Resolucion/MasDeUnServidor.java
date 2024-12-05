package proyect.models.Resolucion;

import proyect.models.Excel;

public class MasDeUnServidor extends Servidor{

    private int s;
    public int getS() {
        return s;
    }

    public MasDeUnServidor(Excel excel,double tiempoObservacion,int servidores){
        super(excel, tiempoObservacion);
        this.s=servidores;
    }
    
    @Override
    public void calcularP() {
        double P = getLambda()/(getS()*getMiu());
        setP(P);
    }

    @Override
    public void calcularPo() {
        double sumatoria = sumatoriaPo(getS(), getLambda(), getMiu());
        double param1 = (Math.pow(getLambda()/getMiu(), getS()))/factorial(getS());
        double param2 = 1.00/(1.00-(getLambda()/(getS()*getMiu())));
        double salida = 1.00/(sumatoria+(param1*param2));
        setPo(salida);
    }

    @Override
    public double calcularPn(int n) {
        double Pn = 0.00;
        if (n>=0 && n<=getS()){
            Pn=(getPo()*Math.pow(getLambda()/getMiu(),n))/factorial(n);
        }else if (n>getS()){
            Pn=(getPo()*Math.pow(getLambda()/getMiu(),n))/(factorial(getS())*Math.pow(getS(), n-getS()));
        }
        return Pn;
    }

    private double sumatoriaPo(int s,double lambda,double miu){
        double salida = 0.00;
        for (int n=0;n<s;n++){
            salida+=(Math.pow(getLambda()/getMiu(),n))/factorial(n);
        }
        return salida;
    }

    private int factorial(int n){
        if (n==1 || n==0){
            return 1;
        }
        return n *factorial(n-1);
    }

    @Override
    public void calcularLq() {
        double Lq = (getPo()*Math.pow(getLambda()/getMiu(),getS()))/(factorial(getS())*Math.pow(1-getP(),2));
        setLq(Lq);
    }

    @Override
    public void calcularLs() {
        double Ls = getLq()+(getLambda()/getMiu());
        setLs(Ls);
    }

    @Override
    public void calcularWs() {
        double Ws = (getLq()/getLambda())+(1/getMiu());
        setWs(Ws);
    }

    @Override
    public void calcularWq() {
        double Wq = getLq()/getLambda();
        setWq(Wq);
    }

    @Override
    public double probabilidadTiempoSistema(double t,String condicion){
        double salida = 0.00;
        double param1 = ((1+(getPo()*Math.pow(getLambda()/getMiu(), getS())))/(factorial(getS())*(1-getP())));
        double param2 = ((1-Math.pow(Math.E, -getMiu()*t*(getS()-1-(getLambda()/getMiu()))))/(getS()-1-(getLambda()/getMiu())));
        if (condicion.equals(">")){
            salida=Math.pow(Math.E,-getMiu()*t)*param1*param2;
        }else{
            salida=1.00-Math.pow(Math.E,-getMiu()*t)*param1*param2;
        }
        return salida;
    }

    @Override
    public double probabilidadTiempoCola(double t,String condicion){
        double salida = 0.00;
        if (condicion.equals(">")){
            salida=(1.00-getPo())*Math.pow(Math.E,-getS()*getMiu()*(1-getP())*t);
        }else{
            salida=1.00-(1.00-getPo())*Math.pow(Math.E,-getS()*getMiu()*(1-getP())*t);
        }
        return salida;
    }

    @Override
    public String toString() {
        String salida = "";
        salida+="s:\t"+getS()+"\n";
        salida+=super.toString();
        return salida;
    }
}
