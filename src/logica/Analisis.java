/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import jxl.read.biff.BiffException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author dark
 */
public class Analisis implements OperacionesLibro, OperacionesCalidad {

    private boolean semaforo;
    private File file;
    private ArchivoControlPrenatalDefuncion control_prenatal_defuncion;
    private ArchivoControlPrenatalVivo control_prenatal_vivo;
    private ArchivoDeudaCertificado deuda_certificado;
    private ArchivoEstadisticaVitalDefunciones estadistica_vital_defunfion;
    private ArchivoEstadisticaVitalNacimientos estadistica_vital_nacimientos;
    private ArchivoEstadisticaVitalDefunciones estadistica_vital_defunfion_todos;
    private ArchivoEstadisticaVitalNacimientos estadistica_vital_nacimientos_todos;
    private Vector<String> municipios = new Vector<>();
    private ArrayList<String> pendientes_generales_dane_vivos = new ArrayList<>();
    private ArrayList<String> pendientes_generales_dane_difuntos = new ArrayList<>();
    private boolean primera_instancia = false;
    private String respuesta = "";
    private String info = "";
    private ArrayList<TemporalInfo> reporte = new ArrayList<>();
    private AnalizadorCalidad analizador_calidad;

    public ArrayList<TemporalInfo> getReporte() {
        return reporte;
    }

    public void setReporte(ArrayList<TemporalInfo> reporte) {
        this.reporte = reporte;
    }
    

    public Analisis(File control_prenatal_defuncion, File control_prenatal_vivo, File deuda_certificado, File estadistica_vital_defunfion, File estadistica_vital_nacimientos) {
        this.file = estadistica_vital_defunfion;
        this.control_prenatal_defuncion = new ArchivoControlPrenatalDefuncion(control_prenatal_defuncion);
        this.control_prenatal_vivo = new ArchivoControlPrenatalVivo(control_prenatal_vivo);
        this.deuda_certificado = new ArchivoDeudaCertificado(deuda_certificado);
        this.estadistica_vital_defunfion = new ArchivoEstadisticaVitalDefunciones(estadistica_vital_defunfion);
        this.estadistica_vital_nacimientos = new ArchivoEstadisticaVitalNacimientos(estadistica_vital_nacimientos);
        this.analizador_calidad = new AnalizadorCalidad();
    }

    public Analisis() {
        this.file = file;
        this.control_prenatal_defuncion = new ArchivoControlPrenatalDefuncion();
        this.control_prenatal_vivo = new ArchivoControlPrenatalVivo();
        this.deuda_certificado = new ArchivoDeudaCertificado();
        this.estadistica_vital_defunfion = new ArchivoEstadisticaVitalDefunciones();
        this.estadistica_vital_nacimientos = new ArchivoEstadisticaVitalNacimientos();
        this.estadistica_vital_defunfion_todos = new ArchivoEstadisticaVitalDefunciones();
        this.estadistica_vital_nacimientos_todos = new ArchivoEstadisticaVitalNacimientos();
        this.analizador_calidad = new AnalizadorCalidad();
    }

    public AnalizadorCalidad getAnalizador_calidad() {
        return analizador_calidad;
    }

    public void setAnalizador_calidad(AnalizadorCalidad analizador_calidad) {
        this.analizador_calidad = analizador_calidad;
    }

    @Override
    public void generarWorkBook() {
        this.control_prenatal_defuncion.generarWorkBook();
        this.control_prenatal_vivo.generarWorkBook();
        this.deuda_certificado.generarWorkBook();
        this.estadistica_vital_defunfion.generarWorkBook();
        this.estadistica_vital_nacimientos.generarWorkBook();
    }

    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public ArchivoEstadisticaVitalDefunciones getEstadistica_vital_defunfion_todos() {
        return estadistica_vital_defunfion_todos;
    }

    public void setEstadistica_vital_defunfion_todos(ArchivoEstadisticaVitalDefunciones estadistica_vital_defunfion_todos) {
        this.estadistica_vital_defunfion_todos = estadistica_vital_defunfion_todos;
    }

    public ArchivoEstadisticaVitalNacimientos getEstadistica_vital_nacimientos_todos() {
        return estadistica_vital_nacimientos_todos;
    }

    public void setEstadistica_vital_nacimientos_todos(ArchivoEstadisticaVitalNacimientos estadistica_vital_nacimientos_todos) {
        this.estadistica_vital_nacimientos_todos = estadistica_vital_nacimientos_todos;
    }

    public ArrayList<String> getPendientes_generales_dane_vivos() {
        return pendientes_generales_dane_vivos;
    }

    public void setPendientes_generales_dane_vivos(ArrayList<String> pendientes_generales_dane_vivos) {
        this.pendientes_generales_dane_vivos = pendientes_generales_dane_vivos;
    }

    public ArrayList<String> getPendientes_generales_dane_difuntos() {
        return pendientes_generales_dane_difuntos;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPendientes_generales_dane_difuntos(ArrayList<String> pendientes_generales_dane_difuntos) {
        this.pendientes_generales_dane_difuntos = pendientes_generales_dane_difuntos;
    }

    public boolean isPrimera_instancia() {
        return primera_instancia;
    }

    public void setPrimera_instancia(boolean primera_instancia) {
        this.primera_instancia = primera_instancia;
    }

    public void extraerMultiplesArchivos(int muni[], File vital_vivos[], File vital_difuntos[], File control[]) {
        /**
         * Extraer informacion archivos del dane*
         */
        ManejadorMunicipio m = new ManejadorMunicipio();
        semaforo = false;
        for (int n : muni) {
            System.out.println("Analizando " + m.getMunicipio(n) + "***********************");
            respuesta += "Analizando " + m.getMunicipio(n) + "***********************";
            for (File vital_viv : vital_vivos) {
                this.getEstadistica_vital_nacimientos().setArchivo(vital_viv);
                this.getEstadistica_vital_nacimientos().generarWorkBook();
                this.getEstadistica_vital_nacimientos().seleccionarMunicipio(n);
                this.getEstadistica_vital_nacimientos().extraerNodos();
            }
//            for(FilaEstadisticaVitalNacimientos est : this.getEstadistica_vital_nacimientos().getNacimientos()){
//                System.out.println(est.toString());
//            }
            for (File vital_dif : vital_difuntos) {
                this.getEstadistica_vital_defunfion().setArchivo(vital_dif);
                this.getEstadistica_vital_defunfion().generarWorkBook();
                this.getEstadistica_vital_defunfion().seleccionarMunicipio(n);
                this.getEstadistica_vital_defunfion().extraerNodos();
            }
//            for(EstadisticaVital_defuncion est : estadistica_vital_defunfion.getDefunciones()){
//                System.out.println(est.toString());
//            }
            for (File contro : control) {
                this.getControl_prenatal_vivo().setArchivo(contro);
                this.getControl_prenatal_vivo().generarWorkBook();
                this.getControl_prenatal_vivo().seleccionarMunicipio(n);
                this.getControl_prenatal_vivo().extraerNodos();
                this.getControl_prenatal_defuncion().setArchivo(contro);
                this.getControl_prenatal_defuncion().generarWorkBook();
                this.getControl_prenatal_defuncion().seleccionarMunicipio(n);
                this.getControl_prenatal_defuncion().extraerNodos();
            }
//            for (ControlPapeleriaNacimientos defuncione : this.getControl_prenatal_vivo().getNacimientos()) {
//                System.out.println(defuncione.toString());
//            }
            /**
             * **************************************************************
             */
            this.getEstadistica_vital_nacimientos().getColumna(n);
            this.getEstadistica_vital_defunfion().getColumna(n);
            this.getControl_prenatal_defuncion().getColumna(n);
            this.getControl_prenatal_vivo().getColumna(n);
            /**
             * **************************************************************
             */
            hacerExtraccion();
            actualizarInfo(m.getMunicipio(n));
            actualizarDefunciones(info);
            TemporalInfo tem_info = new TemporalInfo();
            tem_info.setMunicipio(m.getMunicipio(n));
            tem_info.setVivos(this.getControl_prenatal_vivo().extraerNodos(this.getControl_prenatal_vivo().getColumna()));
            tem_info.setDifuntos(this.getControl_prenatal_defuncion().extraerNodos(this.getControl_prenatal_defuncion().getColumna()));
            tem_info.setAnios_vivos(this.getControl_prenatal_vivo().getAnios());
            tem_info.setAnios_difuntos(this.getControl_prenatal_defuncion().getAnios());
            this.reporte.add(tem_info);
            this.analizador_calidad.addRegistro(new RegistrosMunicipio(this.getEstadistica_vital_defunfion().getDefunciones(), this.getEstadistica_vital_nacimientos().getNacimientos(), n));
            /**
             * **************************************************************
             */
//            reportActual();
            this.getEstadistica_vital_nacimientos().setNacimientos(new ArrayList<FilaEstadisticaVitalNacimientos>());
            this.getEstadistica_vital_defunfion().setDefunciones(new ArrayList<EstadisticaVital_defuncion>());
            this.getControl_prenatal_defuncion().setDefunciones(new ArrayList<ControlPapeleriaDefunciones>());
            this.getControl_prenatal_vivo().setNacimientos(new ArrayList<ControlPapeleriaNacimientos>());
            /**
             * **************************************************************
             */
        }
    }

    public void hacerExtraccion() {
//        System.out.println("***********************************************************************************");
//        System.out.println(this.getEstadistica_vital_defunfion().getDefunciones().size()+"   "+this.getEstadistica_vital_defunfion().getColumna().size());
//        System.out.println(this.getControl_prenatal_defuncion().getColumna().size()+"   "+this.getControl_prenatal_defuncion().getDefunciones().size());
        this.getControl_prenatal_vivo().getColumna().removeAll(this.getEstadistica_vital_nacimientos().getColumna());
        this.getControl_prenatal_defuncion().getColumna().removeAll(this.getEstadistica_vital_defunfion().getColumna());
//        System.out.println(this.getControl_prenatal_vivo().getColumna());
//        System.out.println(this.getControl_prenatal_defuncion().getColumna());
    }

    @Override
    public void analizarCalidaDeLaInformacion(int n) {
        if(n ==  1){
            this.analizador_calidad.analizarCalidaDeLaInformacion();
        }else if (n==2){
            this.analizador_calidad.analizarCalidaDeLaInformacion(null);
        }
        
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void analizarCalidaDeLaInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class TemporalInfo {

        private String municipio = "";
        private ArrayList<Object> vivos = new ArrayList<>();
        private ArrayList<Object> difuntos = new ArrayList<>();
        private ArrayList<Integer> anios_vivos = new ArrayList<>();
        private ArrayList<Integer> anios_difuntos = new ArrayList<>();

        public ArrayList<Integer> getAnios_vivos() {
            return anios_vivos;
        }

        public void setAnios_vivos(ArrayList<Integer> anios_vivos) {
            this.anios_vivos = anios_vivos;
        }

        public ArrayList<Integer> getAnios_difuntos() {
            return anios_difuntos;
        }

        public void setAnios_difuntos(ArrayList<Integer> anios_difuntos) {
            this.anios_difuntos = anios_difuntos;
        }

        
        public TemporalInfo() {
        }

        public TemporalInfo(String municipio) {
            this.municipio = municipio;
        }

        public String getMunicipio() {
            return municipio;
        }

        public void setMunicipio(String municipio) {
            this.municipio = municipio;
        }

        public ArrayList<Object> getVivos() {
            return vivos;
        }

        public void setVivos(ArrayList<Object> vivos) {
            this.vivos = vivos;
        }

        public ArrayList<Object> getDifuntos() {
            return difuntos;
        }

        public void setDifuntos(ArrayList<Object> difuntos) {
            this.difuntos = difuntos;
        }

    }

    public void generarWord(String ruta) {
        for (TemporalInfo t : this.getReporte()) {
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(t.getMunicipio());
            run.setFontSize(25);
            run.setFontFamily("Arial Black");
            run.setBold(true);
            run.addBreak();
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.setText("Descripcion");
            run2.addBreak();

            paragraph.setAlignment(ParagraphAlignment.CENTER);
            ArrayList<Object> vivos = t.getVivos();
            run2.setText("Total registros nacimientos pendientes : " + vivos.size());
            for (int i = 0; i < vivos.size(); i++) {
                int pos = i;
                for (int j = i + 1; j < vivos.size(); j++) {
                    if (((ControlPapeleriaNacimientos) vivos.get(i)).getValor() > ((ControlPapeleriaNacimientos) vivos.get(j)).getValor()) {
                        pos = j;
                    }
                }
                if (pos != i) {
                    Object tem = vivos.get(i);
                    vivos.set(i, vivos.get(pos));
                    vivos.set(pos, tem);
                }
            }
            for (int i = 0; i < t.getAnios_vivos().size(); i++) {
                int pos = i;
                for (int j = i + 1; j < t.getAnios_vivos().size(); j++) {
                    if (t.getAnios_vivos().get(i) > t.getAnios_vivos().get(j)) {
                        pos = j;
                    }
                }
                if (pos != i) {
                    int tem = t.getAnios_vivos().get(i);
                    t.getAnios_vivos().set(i, t.getAnios_vivos().get(pos));
                    t.getAnios_vivos().set(pos, tem);
                }
            }
            int con = 0;
            int no_con_sopor = 0;
            String tem_info_vivos = "";
            String tem_info_vivos_no_claro = "";
            for (int valor : t.getAnios_vivos()) {
                con = 0;
                XWPFTable table = document.createTable();
                table.setInsideHBorder(XWPFTable.XWPFBorderType.THICK, 3, 2, "9965F3");
                table.setCellMargins(10, 10, 0, 0);
                XWPFTableRow row0 = table.getRow(0);
                XWPFTableCell cell0 = row0.getCell(0);
                XWPFParagraph par = cell0.addParagraph();
                XWPFRun par_run = par.createRun();
                par_run.setFontFamily("Arial Black");
                par_run.setFontSize(13);
                cell0.setColor("9965F3");
                par_run.setText("Codigo del registro Nacimiento");
                par_run.setBold(true);

                XWPFTableCell cell1 = row0.createCell();
                XWPFParagraph par1 = cell1.addParagraph();
                XWPFRun par_run1 = par1.createRun();
                par_run1.setFontFamily("Arial Black");
                par_run1.setFontSize(13);
                cell1.setColor("9965F3");
                par_run1.setText("Fecha de entrega 20"+valor);
                par_run.setBold(true);
                for (Object vivo : vivos) {
                    ControlPapeleriaNacimientos nacimiento = (ControlPapeleriaNacimientos) vivo;
                    String entrega = nacimiento.getFecha_entrega_dane();
                    if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)) {
                        String res[] = entrega.split("/");
                        res[2] = Pattern.matches("\\d{1,2}", res[2]) ? res[2] : res[2].substring(2, res[2].length());
                        if (valor == (Integer.parseInt(res[2]))) {
                            XWPFTableRow row1 = table.createRow();
                            XWPFTableCell cell11 = row1.getCell(0);
                            cell11.setText(nacimiento.getCert_nac_entregado());
                            XWPFTableCell cell12 = row1.getCell(1);
                            cell12.setText(nacimiento.getFecha_entrega_dane());
                            tem_info_vivos += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                            con++;
                        }

                    } else {
                        tem_info_vivos_no_claro += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                        no_con_sopor++;
                    }
                }
                info += "\n\tAnio : 20" + valor + "  son " + con + " registros.";
                info += tem_info_vivos;
                tem_info_vivos = "";
                con = 0;
            }
            if (no_con_sopor > 0) {
                info += "\n\tAnio no numerico  son " + con + " registros.";
                info += tem_info_vivos_no_claro;
            }
            /*************************DEFUNCIONES***********************************/
            run2.addBreak();

            paragraph.setAlignment(ParagraphAlignment.CENTER);
             vivos = t.getDifuntos();
            run2.setText("Total registros defunciones pendientes : " + vivos.size());
            for (int i = 0; i < vivos.size(); i++) {
                int pos = i;
                for (int j = i + 1; j < vivos.size(); j++) {
                    if (((ControlPapeleriaDefunciones) vivos.get(i)).getValor() > ((ControlPapeleriaDefunciones) vivos.get(j)).getValor()) {
                        pos = j;
                    }
                }
                if (pos != i) {
                    Object tem = vivos.get(i);
                    vivos.set(i, vivos.get(pos));
                    vivos.set(pos, tem);
                }
            }
            for (int i = 0; i < t.getAnios_difuntos().size(); i++) {
                int pos = i;
                for (int j = i + 1; j < t.getAnios_difuntos().size(); j++) {
                    if (t.getAnios_difuntos().get(i) > t.getAnios_difuntos().get(j)) {
                        pos = j;
                    }
                }
                if (pos != i) {
                    int tem = t.getAnios_difuntos().get(i);
                    t.getAnios_difuntos().set(i, t.getAnios_difuntos().get(pos));
                    t.getAnios_difuntos().set(pos, tem);
                }
            }
            int con2 = 0;
            int no_con_sopor2 = 0;
            String tem_info_vivos2 = "";
            String tem_info_vivos_no_claro2 = "";
            for (int valor : t.getAnios_difuntos()) {
                con2 = 0;
                XWPFTable table = document.createTable();
                table.setInsideHBorder(XWPFTable.XWPFBorderType.THICK, 3, 2, "9965F3");
                table.setCellMargins(10, 10, 0, 0);
                XWPFTableRow row0 = table.getRow(0);
                XWPFTableCell cell0 = row0.getCell(0);
                XWPFParagraph par = cell0.addParagraph();
                XWPFRun par_run = par.createRun();
                par_run.setFontFamily("Arial Black");
                par_run.setFontSize(13);
                cell0.setColor("9965F3");
                par_run.setText("Codigo del registro Defunciones");
                par_run.setBold(true);

                XWPFTableCell cell1 = row0.createCell();
                XWPFParagraph par1 = cell1.addParagraph();
                XWPFRun par_run1 = par1.createRun();
                par_run1.setFontFamily("Arial Black");
                par_run1.setFontSize(13);
                cell1.setColor("9965F3");
                par_run1.setText("Fecha de entrega 20"+valor);
                par_run.setBold(true);
                for (Object vivo : vivos) {
                    ControlPapeleriaDefunciones nacimiento = (ControlPapeleriaDefunciones) vivo;
                    String entrega = nacimiento.getFecha_entrega_dane();
                    if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)) {
                        String res[] = entrega.split("/");
                        res[2] = Pattern.matches("\\d{1,2}", res[2]) ? res[2] : res[2].substring(2, res[2].length());
                        if (valor == (Integer.parseInt(res[2]))) {
                            XWPFTableRow row1 = table.createRow();
                            XWPFTableCell cell11 = row1.getCell(0);
                            cell11.setText(nacimiento.getCert_nac_entregado());
                            XWPFTableCell cell12 = row1.getCell(1);
                            cell12.setText(nacimiento.getFecha_entrega_dane());
                            tem_info_vivos += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                            con2++;
                        }

                    } else {
                        tem_info_vivos_no_claro += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                        no_con_sopor2++;
                    }
                }
                info += "\n\tAnio : 20" + valor + "  son " + con2 + " registros.";
                info += tem_info_vivos;
                tem_info_vivos = "";
                con2 = 0;
            }
            if (no_con_sopor > 0) {
                info += "\n\tAnio no numerico  son " + con + " registros.";
                info += tem_info_vivos_no_claro;
            }
            try {
                FileOutputStream output = new FileOutputStream(ruta+"\\"+t.getMunicipio()+".docx");
                document.write(output);
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void actualizarInfo(String municipio) {
        info += "\n\n\t======= Municipio ========== " + municipio;
        info += "\n\n\t_____  NACIMIENTOS  ________ ";
        info += "\n\t Total registros nacimientos pendientes : " + this.getControl_prenatal_vivo().getColumna().size();
        ArrayList<Object> vivos = this.getControl_prenatal_vivo().extraerNodos(this.getControl_prenatal_vivo().getColumna());
        for (int i = 0; i < vivos.size(); i++) {
            int pos = i;
            for (int j = i + 1; j < vivos.size(); j++) {
                if (((ControlPapeleriaNacimientos) vivos.get(i)).getValor() > ((ControlPapeleriaNacimientos) vivos.get(j)).getValor()) {
                    pos = j;
                }
            }
            if (pos != i) {
                Object tem = vivos.get(i);
                vivos.set(i, vivos.get(pos));
                vivos.set(pos, tem);
            }
        }
        for (int i = 0; i < this.getControl_prenatal_vivo().getAnios().size(); i++) {
            int pos = i;
            for (int j = i + 1; j < this.getControl_prenatal_vivo().getAnios().size(); j++) {
                if (this.getControl_prenatal_vivo().getAnios().get(i) > this.getControl_prenatal_vivo().getAnios().get(j)) {
                    pos = j;
                }
            }
            if (pos != i) {
                int tem = this.getControl_prenatal_vivo().getAnios().get(i);
                this.getControl_prenatal_vivo().getAnios().set(i, this.getControl_prenatal_vivo().getAnios().get(pos));
                this.getControl_prenatal_vivo().getAnios().set(pos, tem);
            }
        }
        int con = 0;
        int no_con_sopor = 0;
        String tem_info_vivos = "";
        String tem_info_vivos_no_claro = "";
        for (int valor : this.getControl_prenatal_vivo().getAnios()) {
            con = 0;
            for (Object vivo : vivos) {
                ControlPapeleriaNacimientos nacimiento = (ControlPapeleriaNacimientos) vivo;
                String entrega = nacimiento.getFecha_entrega_dane();
                if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)) {
                    String res[] = entrega.split("/");
                    res[2] = Pattern.matches("\\d{1,2}", res[2]) ? res[2] : res[2].substring(2, res[2].length());
                    if (valor == (Integer.parseInt(res[2]))) {
                        tem_info_vivos += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                        con++;
                    }

                } else {
                    tem_info_vivos_no_claro += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                    no_con_sopor++;
                }
            }
            info += "\n\tAnio : 20" + valor + "  son " + con + " registros.";
            info += tem_info_vivos;
            tem_info_vivos = "";
            con = 0;
        }
        if (no_con_sopor > 0) {
            info += "\n\tAnio no numerico  son " + con + " registros.";
            info += tem_info_vivos_no_claro;
        }
    }

    public void actualizarDefunciones(String municipio) {
        info += "\n\n\t_____  DEFUNCIONES  ________ ";
        info += "\n\t Total registros  defunciones : " + this.getControl_prenatal_defuncion().getColumna().size();
        ArrayList<Object> vivos = this.getControl_prenatal_defuncion().extraerNodos(this.getControl_prenatal_defuncion().getColumna());
        for (int i = 0; i < vivos.size(); i++) {
            int pos = i;
            for (int j = i + 1; j < vivos.size(); j++) {
                if (((ControlPapeleriaDefunciones) vivos.get(i)).getValor() > ((ControlPapeleriaDefunciones) vivos.get(j)).getValor()) {
                    pos = j;
                }
            }
            if (pos != i) {
                Object tem = vivos.get(i);
                vivos.set(i, vivos.get(pos));
                vivos.set(pos, tem);
            }
        }
        for (int i = 0; i < this.getControl_prenatal_defuncion().getAnios().size(); i++) {
            int pos = i;
            for (int j = i + 1; j < this.getControl_prenatal_defuncion().getAnios().size(); j++) {
                if (this.getControl_prenatal_defuncion().getAnios().get(i) > this.getControl_prenatal_defuncion().getAnios().get(j)) {
                    pos = j;
                }
            }
            if (pos != i) {
                int tem = this.getControl_prenatal_defuncion().getAnios().get(i);
                this.getControl_prenatal_defuncion().getAnios().set(i, this.getControl_prenatal_defuncion().getAnios().get(pos));
                this.getControl_prenatal_defuncion().getAnios().set(pos, tem);
            }
        }
        int con = 0;
        int no_con_sopor = 0;
        String tem_info_vivos = "";
        String tem_info_vivos_no_claro = "";
        for (int valor : this.getControl_prenatal_defuncion().getAnios()) {
            con = 0;
            for (Object vivo : vivos) {
                ControlPapeleriaDefunciones nacimiento = (ControlPapeleriaDefunciones) vivo;
                String entrega = nacimiento.getFecha_entrega_dane();
                if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)) {
                    String res[] = entrega.split("/");
                    res[2] = Pattern.matches("\\d{1,2}", res[2]) ? res[2] : res[2].substring(2, res[2].length());
                    if (valor == (Integer.parseInt(res[2]))) {
                        tem_info_vivos += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                        con++;
                    }

                } else {
                    tem_info_vivos_no_claro += "\n\t\t\t" + nacimiento.getCert_nac_entregado() + " -- " + nacimiento.getFecha_entrega_dane();
                    no_con_sopor++;
                }
            }
            info += "\n\tAnio : 20" + valor + "  son " + con + " registros.";
            info += tem_info_vivos;
            tem_info_vivos = "";
            con = 0;
        }
        if (no_con_sopor > 0) {
            info += "\n\tAnio no numerico  son " + con + " registros.";
            info += tem_info_vivos_no_claro;
        }

    }

    public void extraerMultiplesArchivos(File dane[], File vital_vivos[], File vital_difuntos[], int muni[]) {
        /**
         * Extraer informacion archivos del dane*
         */
        ManejadorMunicipio m = new ManejadorMunicipio();
        semaforo = false;
        for (int n : muni) {
            System.out.println("Analizando " + m.getMunicipio(n) + "***********************");
            respuesta += "Analizando " + m.getMunicipio(n) + "***********************";
            this.getDeuda_certificado().setVivos(new ArrayList<DeudasCertificado>());
            this.getDeuda_certificado().setMuertos(new ArrayList<DeudasCertificado>());
            for (File dane1 : dane) {
                this.getDeuda_certificado().setArchivo(dane1);
                this.getDeuda_certificado().generarWorkBook();
                this.getDeuda_certificado().seleccionarMunicipio(n);
                this.getDeuda_certificado().extraerNodos();
            }
            this.getEstadistica_vital_nacimientos().setNacimientos(new ArrayList<FilaEstadisticaVitalNacimientos>());
            for (File vital_viv : vital_vivos) {

                this.getEstadistica_vital_nacimientos().setArchivo(vital_viv);
                this.getEstadistica_vital_nacimientos().generarWorkBook();
                this.getEstadistica_vital_nacimientos().seleccionarMunicipio(n);
                this.getEstadistica_vital_nacimientos().extraerNodos();
                if (!semaforo) {
                    this.getEstadistica_vital_nacimientos_todos().setArchivo(vital_viv);
                    this.getEstadistica_vital_nacimientos_todos().generarWorkBook();
                    this.getEstadistica_vital_nacimientos_todos().seleccionarMunicipio(-1);
                    this.getEstadistica_vital_nacimientos_todos().extraerCualquierNodos();
                }
            }
            for (File vital_dif : vital_difuntos) {
                this.getEstadistica_vital_defunfion().setDefunciones(new ArrayList<EstadisticaVital_defuncion>());
                this.getEstadistica_vital_defunfion().setArchivo(vital_dif);
                this.getEstadistica_vital_defunfion().generarWorkBook();
                this.getEstadistica_vital_defunfion().seleccionarMunicipio(n);
                this.getEstadistica_vital_defunfion().extraerNodos();
                if (!semaforo) {
                    this.getEstadistica_vital_defunfion_todos().setArchivo(vital_dif);
                    this.getEstadistica_vital_defunfion_todos().generarWorkBook();
                    this.getEstadistica_vital_defunfion_todos().seleccionarMunicipio(-1);
                    System.out.println(this.getEstadistica_vital_defunfion_todos().getMunicipios());
                    this.getEstadistica_vital_defunfion_todos().extraerCualquieraNodos();
                    System.out.println(this.getEstadistica_vital_defunfion_todos().getDefunciones().size());
                }
            }
            if (!semaforo) {
                this.getEstadistica_vital_defunfion_todos().getColumna(1);
                this.getEstadistica_vital_nacimientos_todos().getColumna(1);
            }
            semaforo = true;
            /**
             * **************************************************************
             */
            reportActual();
            this.getEstadistica_vital_nacimientos().setNacimientos(new ArrayList<FilaEstadisticaVitalNacimientos>());
            this.getEstadistica_vital_defunfion().setDefunciones(new ArrayList<EstadisticaVital_defuncion>());
            /**
             * **************************************************************
             */
        }
    }

    @Override
    public void extraerNodos() {
        this.control_prenatal_defuncion.extraerNodos();
        this.control_prenatal_vivo.extraerNodos();
        this.deuda_certificado.extraerNodos();
        this.estadistica_vital_defunfion.extraerNodos();
        this.estadistica_vital_nacimientos.extraerNodos();
    }

    @Override
    public void extraerNodos(int op) {
        this.control_prenatal_defuncion.seleccionarMunicipio(op);
        this.control_prenatal_defuncion.extraerNodos();
        this.control_prenatal_vivo.seleccionarMunicipio(op);
        this.control_prenatal_vivo.extraerNodos();
        this.deuda_certificado.seleccionarMunicipio(op);
        this.deuda_certificado.extraerNodos();
        this.estadistica_vital_defunfion.seleccionarMunicipio(op);
        this.estadistica_vital_defunfion.extraerNodos();
        this.estadistica_vital_nacimientos.seleccionarMunicipio(op);
        this.estadistica_vital_nacimientos.extraerNodos();
    }

    public void reporte1VivosDaneNOEntrego() {
        this.getControl_prenatal_vivo().getColumna(1);
        //System.out.println("control prenatal vivo "+this.getControl_prenatal_vivo().getColumna().size());
        this.getEstadistica_vital_nacimientos().getColumna(1);
        //System.out.println("Estadistica prenatal vivos : "+this.getEstadistica_vital_nacimientos().getColumna().size());
        //System.out.println("tamaño inicial: "+this.getEstadistica_vital_nacimientos().getColumna().size());
        this.getEstadistica_vital_nacimientos().getColumna().retainAll(this.getControl_prenatal_vivo().getColumna());
        //System.out.println("tamaño final: "+this.getEstadistica_vital_nacimientos().getColumna().size());
        ArrayList<String> no_reportados_por_dane = new ArrayList<>();
        for (String resul_filtro : this.getEstadistica_vital_nacimientos().getColumna()) {
            no_reportados_por_dane.add(new String(resul_filtro));
        }
        reportActual();
    }

    public void reportActual() {
        //se estraen los registros del dane
        this.getDeuda_certificado().getColumna(1);
//        System.out.println(this.getDeuda_certificado().getColumna());
//        System.out.println(this.getDeuda_certificado().getColumna_difuntos());
        System.out.println("_______________");
        respuesta += "_______________";
        //Se estrae la estadistica vital vivos y fallecidos
        this.getEstadistica_vital_defunfion().getColumna(1);
        this.getEstadistica_vital_nacimientos().getColumna(1);
        //Se filtran los q estan en ambos
        /*System.out.println(this.getEstadistica_vital_nacimientos().getColumna());
        System.out.println(this.getEstadistica_vital_defunfion().getColumna());*/
        this.getDeuda_certificado().getColumna().retainAll(this.getEstadistica_vital_nacimientos().getColumna());
        this.getDeuda_certificado().getColumna_difuntos().retainAll(this.getEstadistica_vital_defunfion().getColumna());
        /*ontenedores temporales para los archivos q se encuentran en ambos*/
        ArrayList<String> temporal_vivos_intersecta = new ArrayList<>();
        for (String temporal_vivos_intersecta1 : this.getDeuda_certificado().getColumna()) {
            temporal_vivos_intersecta.add(new String(temporal_vivos_intersecta1));
        }
        ArrayList<String> temporal_difuntos_intersecta = new ArrayList<>();
        for (String temporal_difunto_intersecta : this.getDeuda_certificado().getColumna_difuntos()) {
            temporal_difuntos_intersecta.add(new String(temporal_difunto_intersecta));
        }
        System.out.println();
        respuesta += "Esta en ambos archivos";
        System.out.println("Esta en ambos archivos");
        respuesta += "Vivos " + temporal_vivos_intersecta;
        System.out.println("Vivos " + temporal_vivos_intersecta);
        respuesta += "Difuntos " + temporal_difuntos_intersecta;
        System.out.println("Difuntos " + temporal_difuntos_intersecta);
        this.getDeuda_certificado().getColumna(1);
        this.getDeuda_certificado().getColumna().removeAll(temporal_vivos_intersecta);
        this.getDeuda_certificado().getColumna_difuntos().removeAll(temporal_difuntos_intersecta);
        respuesta += "_____Analisis en todos los q debe el municipio________";
        System.out.println("_____Analisis en todos los q debe el municipio________");
        respuesta += "Vivos  \n" + this.getDeuda_certificado().getColumna();
        System.out.println("Vivos  \n" + this.getDeuda_certificado().getColumna());
        respuesta += "Difuntos  \n" + this.getDeuda_certificado().getColumna_difuntos();
        System.out.println("Difuntos  \n" + this.getDeuda_certificado().getColumna_difuntos());
        // TEMPORAL DE LOS Q DEBE EL MUNICIPIO
        ArrayList<String> temporal_vivos_debe = new ArrayList<>();
        for (String temporal_vivos_intersecta1 : this.getDeuda_certificado().getColumna()) {
            temporal_vivos_intersecta.add(new String(temporal_vivos_intersecta1));
        }
        ArrayList<String> temporal_difuntos_debe = new ArrayList<>();
        for (String temporal_difunto_intersecta : this.getDeuda_certificado().getColumna_difuntos()) {
            temporal_difuntos_intersecta.add(new String(temporal_difunto_intersecta));
        }
        // SE inicia los valores para todos verificar q no este en todos
        temporal_vivos_debe.retainAll(this.getEstadistica_vital_nacimientos_todos().getColumna());
        temporal_difuntos_debe.retainAll(this.getEstadistica_vital_defunfion_todos().getColumna());
        respuesta += "\n_____debe el municipio pero esta en otro año a municipio________";
        System.out.println("_____debe el municipio pero esta en otro año a municipio________");
        respuesta += "\nVivos  \n" + temporal_vivos_debe;
        System.out.println("Vivos  \n" + temporal_vivos_debe);
        respuesta += "\nDifuntos  \n" + temporal_difuntos_debe;
        System.out.println("Difuntos  \n" + temporal_difuntos_debe);
        respuesta += "\n_____Los que debe el municipio por q no se encuentra________";
        System.out.println("_____Los que debe el municipio por q no se encuentra________");
        this.getDeuda_certificado().getColumna().removeAll(temporal_vivos_debe);
        this.getDeuda_certificado().getColumna_difuntos().removeAll(temporal_difuntos_debe);
        respuesta += "\nVivos  \n" + this.getDeuda_certificado().getColumna();
        System.out.println("Vivos  \n" + this.getDeuda_certificado().getColumna());
        respuesta += "\nDifuntos  \n" + this.getDeuda_certificado().getColumna_difuntos();
        System.out.println("Difuntos  \n" + this.getDeuda_certificado().getColumna_difuntos());
        respuesta += "\n=======================================";

    }

    public void report1DeudasDelDane() {
        this.getDeuda_certificado().getColumna(1);
        //System.out.println("certificados vivos "+this.getDeuda_certificado().getColumna());
        //System.out.println("certificados difuntos "+this.getDeuda_certificado().getColumna_difuntos());
        this.getControl_prenatal_vivo().getColumna(1);
        //System.out.println("soporte de vivos : "+this.getControl_prenatal_vivo().getColumna());
        this.getControl_prenatal_defuncion().getColumna(1);
        //System.out.println("soporte de difuntos : "+this.getControl_prenatal_defuncion().getColumna());
        //Deudas del dane con la alcaldia VIVOS
        this.getDeuda_certificado().getColumna().retainAll(this.getControl_prenatal_vivo().getColumna());
        ////Deudas del dane con la alcaldia difuntos
        this.getDeuda_certificado().getColumna_difuntos().retainAll(this.getControl_prenatal_defuncion().getColumna());
        /* Temporales de la insercion de deuda certificado a soporte */
        ArrayList<String> temporal_deuda_interseccion_soporte_defunciones = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna_difuntos()) {
            temporal_deuda_interseccion_soporte_defunciones.add(temporal_deuda_interseccion_soporte1);
        }
        ArrayList<String> temporal_deuda_interseccion_soporte_vivos = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna()) {
            temporal_deuda_interseccion_soporte_vivos.add(temporal_deuda_interseccion_soporte1);
        }
        this.getDeuda_certificado().getColumna(1);
        this.getDeuda_certificado().getColumna_difuntos().removeAll(temporal_deuda_interseccion_soporte_defunciones);
        this.getDeuda_certificado().getColumna().removeAll(temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("certificados temporal vivos resultante entregados "+temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("certificados temporal difuntos resultante entregados "+temporal_deuda_interseccion_soporte_defunciones);
        //System.out.println("certificados vivos resultante faltantes "+this.getDeuda_certificado().getColumna());
        //System.out.println("certificados difuntos resultante faltantes "+this.getDeuda_certificado().getColumna_difuntos());
        //System.out.println(file.getName().split("_")[0]);
        String respuesta = "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
        respuesta += "\n\t*****Reporte del municipio " + file.getName().split("_")[0] + "***";
        respuesta += "\n  Faltantes por entregar por parte del dane : \n\t***Defunciones***";
        /**
         * ALMACENADORES DE LOS REGISTRO QUE DEBE EL DANE*
         */
        ArrayList<String> faltantes_soporte_defunciones = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna_difuntos()) {
            faltantes_soporte_defunciones.add(temporal_deuda_interseccion_soporte1);
            respuesta += "\n " + temporal_deuda_interseccion_soporte1;
        }
        respuesta += "\n\n\t***Nacimientos***";
        ArrayList<String> faltante_soporte_vivos = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna()) {
            faltante_soporte_vivos.add(temporal_deuda_interseccion_soporte1);
            respuesta += "\n  " + temporal_deuda_interseccion_soporte1;
        }
        respuesta += "\n_________________________________________________";
        respuesta += "\n\t---Entregas pendientes por parte del municipio";
        //System.out.println("certificados vivos resultante faltantes "+faltante_soporte_vivos);
        //System.out.println("certificados difuntos resultante faltantes "+faltantes_soporte_defunciones);
        // ******** LOS SERTIFICADOS que hacen falta por parte del municipio
        this.getEstadistica_vital_nacimientos().getColumna(1);
        this.getEstadistica_vital_defunfion().getColumna(1);
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //System.out.println(temporal_deuda_interseccion_soporte_vivos);
        //System.out.println(temporal_deuda_interseccion_soporte_defunciones);
        respuesta += "\n\n\t***Nacimientos***";
        ArrayList<String> tiene_municipio_vivos = new ArrayList<>();
        for (String tiene_municipio_vivo : temporal_deuda_interseccion_soporte_vivos) {
            tiene_municipio_vivos.add(tiene_municipio_vivo);
        }
        ArrayList<String> tiene_municipio_difuntos = new ArrayList<>();
        for (String tiene_municipio_vivo : temporal_deuda_interseccion_soporte_defunciones) {
            tiene_municipio_difuntos.add(tiene_municipio_vivo);
        }
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //System.out.println("Valores para el municipio nacimientos "+this.getEstadistica_vital_nacimientos().getColumna().size());
        //System.out.println("Valores para el municipio difuntos"+this.getEstadistica_vital_defunfion().getColumna().size());
        temporal_deuda_interseccion_soporte_vivos.removeAll(this.getEstadistica_vital_nacimientos().getColumna());
        temporal_deuda_interseccion_soporte_defunciones.removeAll(this.getEstadistica_vital_defunfion().getColumna());
        //System.out.println("Lo que debe el municipios de vivo "+temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("Lo que debe el municipios de difuntos "+temporal_deuda_interseccion_soporte_defunciones);
        for (String tiene_municipio_viv : temporal_deuda_interseccion_soporte_vivos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        respuesta += "\n\n\t***Difuntos***";
        for (String tiene_municipio_difunt : temporal_deuda_interseccion_soporte_defunciones) {
            respuesta += "\n" + tiene_municipio_difunt;
        }
        //System.out.println("_________________________________________________");
        tiene_municipio_vivos.removeAll(temporal_deuda_interseccion_soporte_vivos);
        tiene_municipio_difuntos.removeAll(temporal_deuda_interseccion_soporte_defunciones);
        //System.out.println("Tiene municipio vivos "+tiene_municipio_vivos);
        //System.out.println("Tiene municipio  difuntos "+tiene_municipio_difuntos);
        respuesta += "\n_________________________________________________";
        respuesta += "\n\t---Entregas por parte del municipio";
        respuesta += "\n\n\t***Vivos***";
        for (String tiene_municipio_viv : tiene_municipio_vivos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        respuesta += "\n\n\t***Difuntos***";
        for (String tiene_municipio_viv : tiene_municipio_difuntos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        System.out.println(respuesta);
    }

    public void report1DeudasDelDane(String m) {
        this.getDeuda_certificado().getColumna(1);
        //System.out.println("certificados vivos "+this.getDeuda_certificado().getColumna());
        //System.out.println("certificados difuntos "+this.getDeuda_certificado().getColumna_difuntos());
        this.getControl_prenatal_vivo().getColumna(1);
        //System.out.println("soporte de vivos : "+this.getControl_prenatal_vivo().getColumna());
        this.getControl_prenatal_defuncion().getColumna(1);
        //System.out.println("soporte de difuntos : "+this.getControl_prenatal_defuncion().getColumna());
        //Deudas del dane con la alcaldia VIVOS
        this.getDeuda_certificado().getColumna().retainAll(this.getControl_prenatal_vivo().getColumna());
        ////Deudas del dane con la alcaldia difuntos
        this.getDeuda_certificado().getColumna_difuntos().retainAll(this.getControl_prenatal_defuncion().getColumna());
        /* Temporales de la insercion de deuda certificado a soporte */
        ArrayList<String> temporal_deuda_interseccion_soporte_defunciones = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna_difuntos()) {
            temporal_deuda_interseccion_soporte_defunciones.add(temporal_deuda_interseccion_soporte1);
        }
        ArrayList<String> temporal_deuda_interseccion_soporte_vivos = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna()) {
            temporal_deuda_interseccion_soporte_vivos.add(temporal_deuda_interseccion_soporte1);
        }
        this.getDeuda_certificado().getColumna(1);
        this.getDeuda_certificado().getColumna_difuntos().removeAll(temporal_deuda_interseccion_soporte_defunciones);
        this.getDeuda_certificado().getColumna().removeAll(temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("certificados temporal vivos resultante entregados "+temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("certificados temporal difuntos resultante entregados "+temporal_deuda_interseccion_soporte_defunciones);
        //System.out.println("certificados vivos resultante faltantes "+this.getDeuda_certificado().getColumna());
        //System.out.println("certificados difuntos resultante faltantes "+this.getDeuda_certificado().getColumna_difuntos());
        //System.out.println(file.getName().split("_")[0]);
        String respuesta = "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
        respuesta += "\n\t*****Reporte del municipio " + municipios + "***";
        respuesta += "\n  Faltantes por entregar por parte del dane : \n\t***Defunciones***";
        /**
         * ALMACENADORES DE LOS REGISTRO QUE DEBE EL DANE*
         */
        ArrayList<String> faltantes_soporte_defunciones = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna_difuntos()) {
            faltantes_soporte_defunciones.add(temporal_deuda_interseccion_soporte1);
            respuesta += "\n " + temporal_deuda_interseccion_soporte1;
        }
        respuesta += "\n\n\t***Nacimientos***";
        ArrayList<String> faltante_soporte_vivos = new ArrayList<>();
        for (String temporal_deuda_interseccion_soporte1 : this.getDeuda_certificado().getColumna()) {
            faltante_soporte_vivos.add(temporal_deuda_interseccion_soporte1);
            respuesta += "\n  " + temporal_deuda_interseccion_soporte1;
        }
        respuesta += "\n_________________________________________________";
        respuesta += "\n\t---Entregas pendientes por parte del municipio";
        //System.out.println("certificados vivos resultante faltantes "+faltante_soporte_vivos);
        //System.out.println("certificados difuntos resultante faltantes "+faltantes_soporte_defunciones);
        // ******** LOS SERTIFICADOS que hacen falta por parte del municipio
        this.getEstadistica_vital_nacimientos().getColumna(1);
        this.getEstadistica_vital_defunfion().getColumna(1);
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //System.out.println(temporal_deuda_interseccion_soporte_vivos);
        //System.out.println(temporal_deuda_interseccion_soporte_defunciones);
        respuesta += "\n\n\t***Nacimientos***";
        ArrayList<String> tiene_municipio_vivos = new ArrayList<>();
        for (String tiene_municipio_vivo : temporal_deuda_interseccion_soporte_vivos) {
            tiene_municipio_vivos.add(tiene_municipio_vivo);
        }
        ArrayList<String> tiene_municipio_difuntos = new ArrayList<>();
        for (String tiene_municipio_vivo : temporal_deuda_interseccion_soporte_defunciones) {
            tiene_municipio_difuntos.add(tiene_municipio_vivo);
        }
        //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //System.out.println("Valores para el municipio nacimientos "+this.getEstadistica_vital_nacimientos().getColumna().size());
        //System.out.println("Valores para el municipio difuntos"+this.getEstadistica_vital_defunfion().getColumna().size());
        temporal_deuda_interseccion_soporte_vivos.removeAll(this.getEstadistica_vital_nacimientos().getColumna());
        temporal_deuda_interseccion_soporte_defunciones.removeAll(this.getEstadistica_vital_defunfion().getColumna());
        //System.out.println("Lo que debe el municipios de vivo "+temporal_deuda_interseccion_soporte_vivos);
        //System.out.println("Lo que debe el municipios de difuntos "+temporal_deuda_interseccion_soporte_defunciones);
        for (String tiene_municipio_viv : temporal_deuda_interseccion_soporte_vivos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        respuesta += "\n\n\t***Difuntos***";
        for (String tiene_municipio_difunt : temporal_deuda_interseccion_soporte_defunciones) {
            respuesta += "\n" + tiene_municipio_difunt;
        }
        //System.out.println("_________________________________________________");
        tiene_municipio_vivos.removeAll(temporal_deuda_interseccion_soporte_vivos);
        tiene_municipio_difuntos.removeAll(temporal_deuda_interseccion_soporte_defunciones);
        //System.out.println("Tiene municipio vivos "+tiene_municipio_vivos);
        //System.out.println("Tiene municipio  difuntos "+tiene_municipio_difuntos);
        respuesta += "\n_________________________________________________";
        respuesta += "\n\t---Entregas por parte del municipio";
        respuesta += "\n\n\t***Vivos***";
        for (String tiene_municipio_viv : tiene_municipio_vivos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        respuesta += "\n\n\t***Difuntos***";
        for (String tiene_municipio_viv : tiene_municipio_difuntos) {
            respuesta += "\n" + tiene_municipio_viv;
        }
        System.out.println(respuesta);
    }

    @Override
    public void readNode(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getColumna(int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ArchivoControlPrenatalDefuncion getControl_prenatal_defuncion() {
        return control_prenatal_defuncion;
    }

    public void setControl_prenatal_defuncion(ArchivoControlPrenatalDefuncion control_prenatal_defuncion) {
        this.control_prenatal_defuncion = control_prenatal_defuncion;
    }

    public ArchivoControlPrenatalVivo getControl_prenatal_vivo() {
        return control_prenatal_vivo;
    }

    public void setControl_prenatal_vivo(ArchivoControlPrenatalVivo control_prenatal_vivo) {
        this.control_prenatal_vivo = control_prenatal_vivo;
    }

    public ArchivoDeudaCertificado getDeuda_certificado() {
        return deuda_certificado;
    }

    public void setDeuda_certificado(ArchivoDeudaCertificado deuda_certificado) {
        this.deuda_certificado = deuda_certificado;
    }

    public ArchivoEstadisticaVitalDefunciones getEstadistica_vital_defunfion() {
        return estadistica_vital_defunfion;
    }

    public void setEstadistica_vital_defunfion(ArchivoEstadisticaVitalDefunciones estadistica_vital_defunfion) {
        this.estadistica_vital_defunfion = estadistica_vital_defunfion;
    }

    public ArchivoEstadisticaVitalNacimientos getEstadistica_vital_nacimientos() {
        return estadistica_vital_nacimientos;
    }

    public void setEstadistica_vital_nacimientos(ArchivoEstadisticaVitalNacimientos estadistica_vital_nacimientos) {
        this.estadistica_vital_nacimientos = estadistica_vital_nacimientos;
    }

    public Vector<String> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Vector<String> municipios) {
        this.municipios = municipios;
    }

    @Override
    public void extraerNodosTipo2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraerNodosTipo3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> extraerNodos(ArrayList<String> op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
