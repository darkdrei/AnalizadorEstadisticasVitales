/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobernacion;

import java.io.File;
import logica.*;
import logica.ManejadorMunicipio;
/**
 *
 * @author dark
 */
public class analisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        logica.Analisis a = new logica.Analisis(
//                    new File("/home/dark/aaaaa/GOBERNACIÓN/SOPORTE/gobernacion2.xls"), 
//                    new File("/home/dark/aaaaa/GOBERNACIÓN/SOPORTE/gobernacion2.xls"),
//                    new File("/home/dark/aaaaa/GOBERNACIÓN/Dane.xls"),
//                    new File("/home/dark/aaaaa/GOBERNACIÓN/ESTADISTICA VITAL/defunciones2.xls"),
//                    new File("/home/dark/aaaaa/GOBERNACIÓN/ESTADISTICA VITAL/nacimientos2.xls"));
//        a.generarWorkBook();
//        a.extraerNodos(0);
//        a.report1DeudasDelDane();
//        logica.Analisis a = new logica.Analisis(
//                    new File("/home/dark/aaaaa/SOPORTE/CONTROL DE PAPELERIA 2015-DASALUD.xls"), 
//                    new File("/home/dark/aaaaa/SOPORTE/CONTROL DE PAPELERIA 2015-DASALUD.xls"),
//                    new File("/home/dark/aaaaa/DEUDA-2013-2014-2015-certificados.xls"),
//                    new File("/home/dark/aaaaa/ESTADISTICA VITAL/Revision 20-08-2016/Defunciones/Achi_d.xls"),
//                    new File("/home/dark/aaaaa/ESTADISTICA VITAL/Revision 20-08-2016/Nacimientos/Achi_n.xls"));
//        a.generarWorkBook();
//        a.extraerNodos(0);
//        a.reportActual();
        logica.Analisis a = new logica.Analisis();
        /*File vital_vivos[]=new File[]{new File("C:\\Users\\E7250\\Desktop\\Septiembre\\San Jacinto\\nacimientos.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Marialabaja\\nacimientos.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\San Juan Nepomuceno\\nacimientos.xls")};
        File vital_difuntos[]=new File[]{new File("C:\\Users\\E7250\\Desktop\\Septiembre\\San Jacinto\\defunciones.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Marialabaja\\defunciones.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\San Juan Nepomuceno\\defunciones.xls")};
        File control[]=new File[]{new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Control de certificados\\2104.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Control de certificados\\2015.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Control de certificados\\2016.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Control de certificados\\2017.xls"),
                                        new File("C:\\Users\\E7250\\Desktop\\Septiembre\\Control de certificados\\2013.xls")};*/
        File vital_vivos[]=new File[]{new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Jacinto/nacimientos.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Marialabaja/nacimientos.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Juan Nepomuceno/nacimientos.xls")};
        File vital_difuntos[]=new File[]{new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Jacinto/defunciones.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Marialabaja/defunciones.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/San Juan Nepomuceno/defunciones.xls")};
        File control[]=new File[]{new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Control de certificados/2104.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Control de certificados/2015.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Control de certificados/2016.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Control de certificados/2017.xls"),
                                        new File("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/Control de certificados/2013.xls")};
        int muni[]=new int[]{6,7,8};
        a.extraerMultiplesArchivos( muni,vital_vivos, vital_difuntos,control );
        //a.generarWord("C:\\Users\\E7250\\Documents");
        //System.out.println(a.getInfo());
        a.getAnalizador_calidad().setPath("/home/dark/Documentos");
        a.analizarCalidaDeLaInformacion(2);
//      
//        ArchivoControlPrenatalDefuncion control_prenatal_defuncion = new ArchivoControlPrenatalDefuncion(new File("/home/dark/aaaaa/SOPORTE/CONTROL DE PAPELERIA 2014-DASALUD.xls"));
//        control_prenatal_defuncion.seleccionarMunicipio(0);
//        control_prenatal_defuncion.generarWorkBook();
//        control_prenatal_defuncion.extraerNodos();
        
//        ArchivoControlPrenatalVivo control_prenatal_vivo = new ArchivoControlPrenatalVivo(new File("/home/dark/aaaaa/SOPORTE/CONTROL DE PAPELERIA 2014-DASALUD.xls"));
//        control_prenatal_vivo.generarWorkBook();
//        control_prenatal_vivo.extraerNodos();
        
//        ArchivoDeudaCertificado deuda_certificado = new ArchivoDeudaCertificado(new File("/home/dark/aaaaa/DEUDA-2013-2014-2015-certificados.xls"));
//        deuda_certificado.generarWorkBook();
//        deuda_certificado.extraerNodos();
        
        
//        ArchivoEstadisticaVitalDefunciones estadistica_vital_defunfion = new ArchivoEstadisticaVitalDefunciones(new File("/home/dark/aaaaa/ESTADISTICA VITAL/Revision 20-08-2016/Defunciones/Achi_d.xls"));
//        estadistica_vital_defunfion.generarWorkBook();
//        estadistica_vital_defunfion.extraerNodos();
        
////        
//        ArchivoEstadisticaVitalNacimientos estadistica_vital_nacimientos = new ArchivoEstadisticaVitalNacimientos(new File("/media/dark/EXPRESS/GOBERNACIÓN/ESTADISTICA VITAL/Revision 20-08-2016/Nacimientos/Achi_n.xls"));
//        estadistica_vital_nacimientos.generarWorkBook();
//        estadistica_vital_nacimientos.extraerNodos();
    }
    
}
