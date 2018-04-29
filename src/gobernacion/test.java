/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobernacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.FileCopy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dark
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Date fecha = new Date();
        System.out.println(fecha);
//        System.out.println(20*100/80);
//        String so = System.getProperty("os.name"); 
//        System.out.println(so);
//            String basePath = new File("").getAbsolutePath();
//            System.out.println(basePath);
//        InputStream excelFile = null;
//        try {
//            // TODO code application logic here
//            /*File f = new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Jacinto/nacimientos.xls");
//            System.out.println(f.isFile());*/
//            String ruta = "/home/dark/proyectos/AnalizadorEstadisticasVitales/data/calidad.xlsx";
//            System.out.println("CUÁDRUPLE O MÁS");
//            FileCopy c = new FileCopy();
//            c.fileCopy("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/calidad.xlsx", "/home/dark/proyectos/AnalizadorEstadisticasVitales/data/calidad2.xlsx");
//            excelFile = new FileInputStream(ruta);
//            XSSFWorkbook wb = new XSSFWorkbook(excelFile);
//            XSSFSheet sheet = wb.getSheetAt(0);
//            XSSFRow row;
//            XSSFCell cell;
//            sheet.getRow(1).getCell(2).setCellValue("VIRGILIO");
//            FileOutputStream out = new FileOutputStream(ruta);
//            wb.write(out);
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                excelFile.close();
//            } catch (IOException ex) {
//                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

}
