package proyect.models.Resolucion;

import proyect.config;
import proyect.lib.Libreria;
import proyect.models.Excel;
import proyect.models.Fila;

public abstract class Servidor implements config{
    private Libreria lib = new Libreria();

    private Excel excel;
    private double tiempoObservacion;
    
    private double miu;
    private double lambda;
    private double P;
    private double Po;
    private double Ls;
    private double Lq;
    private double Ws;
    private double Wq;

    public Excel getExcel() {
        return excel;
    }
    public double getTiempoObservacion() {
        return tiempoObservacion;
    }
    public double getLambda() {
        return lambda;
    }
    public double getLq() {
        return Lq;
    }
    public double getLs() {
        return Ls;
    }
    public double getMiu() {
        return miu;
    }
    public double getP() {
        return P;
    }
    public double getPo() {
        return Po;
    }
    public double getWq() {
        return Wq;
    }
    public double getWs() {
        return Ws;
    }
    public void setLambda(double lambda) {
        this.lambda = lib.redondear(lambda);
    }
    public void setLq(double lq) {
        Lq = lib.redondear(lq);
    }
    public void setLs(double ls) {
        Ls = lib.redondear(ls);
    }
    public void setMiu(double miu) {
        this.miu = lib.redondear(miu);
    }
    public void setP(double p) {
        P = lib.redondear(p);
    }
    public void setPo(double po) {
        Po = lib.redondear(po);
    }
    public void setWs(double ws) {
        Ws = lib.redondear(ws);
    }
    public void setExcel(Excel excel) {
        this.excel = excel;
    }
    public void setTiempoObservacion(double tiempoObservacion) {
        this.tiempoObservacion = tiempoObservacion;
    }
    public void setWq(double wq) {
        Wq = lib.redondear(wq);
    }

    public Servidor(Excel excel,double tiempoObservacion){
        excel.leerDatos();
        this.excel=excel;
        this.tiempoObservacion=tiempoObservacion;
        this.miu=0.00;
        this.lambda=0.00;
        this.P=0.00;
        this.Po=0.00;
        this.Ls=0.00;
        this.Lq=0.00;
        this.Ws=0.00;
        this.Wq=0.00;
    }

    public void realizarCalculos(){
        calcularMiu();
        calcularLambda();
        calcularP();
        calcularPo();
        calcularLq();
        calcularLs();
        calcularWs();
        calcularWq();
    }

    public void calcularMiu() {
        int totalLlegadas = getExcel().getTabla().getDatos().size();
        double miu = 1.00/(sumaTiemposServicio()/totalLlegadas);
        setMiu(miu);
    }
    
    public void calcularLambda() {
        double lambda = 0.00;
        lambda = (getExcel().getTabla().getDatos().size())/getTiempoObservacion();
        setLambda(lambda);
    }

    private double sumaTiemposServicio(){
        double salida = 0.00;
        for (Fila fila : getExcel().getTabla().getDatos()){
            salida+=fila.getDuracionServicio();
        }
        return salida;
    }
    public void calcularP(){}
    public void calcularPo(){}
    public double calcularPn(int n){return 0.00;}
    public void calcularLs(){}
    public void calcularLq(){}
    public void calcularWs(){}
    public void calcularWq(){}
    public double probabilidadTiempoSistema(double t,String condicion){return 0.00;}
    public double probabilidadTiempoCola(double t,String condicion){return 0.00;}

    @Override
    public String toString() {
        String salida = "";
        salida+="Miu:\t"+getMiu()+"\n";
        salida+="Lambda:\t"+getLambda()+"\n";
        salida+="P:\t"+getP()+"\n";
        salida+="Po:\t"+getPo()+"\n";
        salida+="Ls:\t"+getLs()+"\n";
        salida+="Lq:\t"+getLq()+"\n";
        salida+="Ws:\t"+getWs()+"\n";
        salida+="Wq:\t"+getWq()+"\n";
        return salida;
    }
}
