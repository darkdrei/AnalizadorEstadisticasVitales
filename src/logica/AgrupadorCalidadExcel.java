/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dark
 */
public class AgrupadorCalidadExcel implements ExportFile {

    private ArrayList<CeldaCalidadExcel> filas_excel;
    private String path;

    public AgrupadorCalidadExcel() {
        this.filas_excel = new ArrayList<>();
    }

    public AgrupadorCalidadExcel(String path) {
        this.path = path;
        this.filas_excel = new ArrayList<>();
    }

    public ArrayList<CeldaCalidadExcel> getFilas_excel() {
        return filas_excel;
    }

    public void setFilas_excel(ArrayList<CeldaCalidadExcel> filas_excel) {
        this.filas_excel = filas_excel;
    }

   @Override
    public void writeFile() {
        System.out.println("Entrando al metodo writeFile");
        try {
            FileCopy c = new FileCopy();
            ManejadorMunicipio m = new ManejadorMunicipio();
            String path = "";
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
            String fechaComoCadena = sdf.format(new Date()); 
            
            String basePath = new File("").getAbsolutePath();
            if (System.getProperty("os.name").contains("Linux")) {
                path = this.getPath() + "/" + "calidad_" + fechaComoCadena + "" + ".xlsx";
                c.fileCopy(basePath + "/data/calidad.xlsx", path);
            } else {
                path = this.getPath() + "\\" + "calidad.xlsx";
                c.fileCopy(basePath + "\\data\\calidad.xlsx", path);
                System.out.println("1. Variable Path: "+path);
                 System.out.println("1. Variable basePathPath: "+basePath);
            }
            System.out.println("2. Variable Path: "+path);
            System.out.println("2. Variable basePathPath: "+basePath);
            File file = new File(path);
            //OPRTUNIDAD
            InputStream excelFile = null;
            excelFile = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            int pos = 4;
            boolean res = true;
            System.out.println("**************   " + sheet.getRow(4).getCell(2).toString().length() + "   *****************");
            do {
                if (sheet.getRow(4).getCell(2).toString().length() == 0) {
                    res = false;
                } else {
                    pos++;
                }
            } while (res);
            for (CeldaCalidadExcel ex : this.getFilas_excel()) {
                sheet.getRow(pos).getCell(3).setCellValue(ex.getEntidad());
                sheet.getRow(pos).getCell(2).setCellValue(ex.getMunicipio());
                sheet.getRow(pos).getCell(7).setCellValue(ex.getOportunidad_vivo());
                sheet.getRow(pos).getCell(8).setCellValue(ex.getOportunidad_defuncion());
                sheet.getRow(pos).getCell(9).setCellValue(ex.getCalidad_vivo());
                sheet.getRow(pos).getCell(10).setCellValue(ex.getCalidad_defunciones());
                pos++;
            }
            FileOutputStream out = new FileOutputStream(path);
            wb.write(out);
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalidadExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalidadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("saliendo al metodo writeFile");
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
