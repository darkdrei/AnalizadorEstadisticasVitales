/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobernacion;

import java.io.File;
import logica.FileCopy;

/**
 *
 * @author dark
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*File f = new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Jacinto/nacimientos.xls");
        System.out.println(f.isFile());*/
        System.out.println("CUÁDRUPLE O MÁS");
        FileCopy c = new FileCopy();
        c.fileCopy("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/calidad.xlsx","/home/dark/proyectos/AnalizadorEstadisticasVitales/data/calidad2.xlsx");
    }
    
}
