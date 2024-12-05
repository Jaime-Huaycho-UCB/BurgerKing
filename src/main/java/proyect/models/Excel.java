package proyect.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import proyect.config;
import proyect.lib.Libreria;

public class Excel implements config{
    private Libreria lib = new Libreria();
    private String archivo = NOMBRE_ARCHIVO;
    private Tabla tabla;
    private String hoja;

    public String getArchivo() {
        return archivo;
    }
    public Tabla getTabla() {
        return tabla;
    }
    public String getHoja() {
        return hoja;
    }

    public Excel(String hoja){
        this.hoja=hoja;
    }

    public void leerDatos(){
        Tabla tabla = new Tabla();
        int numero=1;
        try  {
            FileInputStream fis = new FileInputStream(new File(getArchivo()));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(getHoja());

            int inicioFila = 3;
            int finalFila = 52;  

            for (int fila = inicioFila; fila <= finalFila; fila++) {
                Row row = sheet.getRow(fila);
                if (row == null) continue;
                double atri1 = lib.redondear(row.getCell(1).getNumericCellValue());
                double atri2 = lib.redondear(row.getCell(2).getNumericCellValue());
                tabla.agregarDatos(numero,atri1, atri2);
                numero+=1;
            }
            workbook.close();
            this.tabla=tabla;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        String salida = "";
        salida+="\tFila1\tFila2\tFila3\n";
        salida+=getTabla().toString();
        return salida;
    }
}
