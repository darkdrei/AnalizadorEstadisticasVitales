/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileOutputStream;
import java.util.ArrayList;
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
public class CalidadWord extends Reporte {

    public CalidadWord(int con_area_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento, int con_sitio_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento, int con_semana_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion, int con_peso, ArrayList<FilaEstadisticaVitalNacimientos> peso, int con_peso_tiempo_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion, int con_talla, ArrayList<FilaEstadisticaVitalNacimientos> talla, int con_peso_tiempo_gestacion_talla, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla, int con_grupo_sanguineo, ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo, int con_factor_rh, ArrayList<FilaEstadisticaVitalNacimientos> factor_rh, int con_direccion, ArrayList<FilaEstadisticaVitalNacimientos> direccion, int con_edad_padre, ArrayList<FilaEstadisticaVitalNacimientos> edad_padre, int con_estado, ArrayList<FilaEstadisticaVitalNacimientos> estado, int con_multiplicidad, ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad, ArrayList<EstadisticaVital_defuncion> area_defuncion, ArrayList<EstadisticaVital_defuncion> tipo_defuncion, ArrayList<EstadisticaVital_defuncion> direccion_defuncion, ArrayList<EstadisticaVital_defuncion> mujeres, ArrayList<EstadisticaVital_defuncion> tipo_profesional, ArrayList<EstadisticaVital_defuncion> estado_defuncion, int municipio) {
        super(con_area_nacimiento, area_nacimiento, con_sitio_nacimiento, sitio_nacimiento, con_semana_gestacion, semana_gestacion, con_peso, peso, con_peso_tiempo_gestacion, peso_tiempo_gestacion, con_talla, talla, con_peso_tiempo_gestacion_talla, peso_tiempo_gestacion_talla, con_grupo_sanguineo, grupo_sanguineo, con_factor_rh, factor_rh, con_direccion, direccion, con_edad_padre, edad_padre, con_estado, estado, con_multiplicidad, multiplicidad, area_defuncion, tipo_defuncion, direccion_defuncion, mujeres, tipo_profesional, estado_defuncion, municipio);
    }

    @Override
    public void writeFile() {
        ManejadorMunicipio muni = new ManejadorMunicipio();
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(muni.getMunicipio(this.getMunicipio()));
        run.setFontSize(25);
        run.setFontFamily("Arial Black");
        run.setBold(true);
        run.addBreak();
        run.addBreak();

        XWPFRun run_ = paragraph.createRun();
        run_.setText("Nacimientos");
        run_.setFontSize(15);
        run_.setFontFamily("Arial Black");
        run_.setBold(true);
        run_.addBreak();
        run_.addBreak();

        XWPFParagraph paragraph22 = document.createParagraph();
        XWPFRun run22 = paragraph22.createRun();
        run22.setText("Inconsistencias");
        run22.addBreak();
        System.out.println("Contador ne nacimientos " + this.getCon_sitio_nacimiento());
        integrarTabla(document, "Area de nacimiento : ", this.getArea_nacimiento());
        integrarTabla(document, "Sitio de nacimiento : ", this.getSitio_nacimiento());
        integrarTabla(document, "Semanas de gestacion : ", this.getSemana_gestacion());
        integrarTabla(document, "Peso : ", this.getPeso());
        integrarTabla(document, "Peso - Semanas de gestacion : ", this.getPeso_tiempo_gestacion());
        integrarTabla(document, "Talla : ", this.getTalla());
        integrarTabla(document, "Peso - Semanas de gestacion  Talla : ", this.getPeso_tiempo_gestacion_talla());
        integrarTabla(document, "Grupo sanguineo : ", this.getGrupo_sanguineo());
        integrarTabla(document, "Factor rh: ", this.getFactor_rh());
        integrarTabla(document, "Direccion: ", this.getDireccion());
        integrarTabla(document, "Edad del padre: ", this.getEdad_padre());
        integrarTabla(document, "Estado del Certificado : ", this.getEstado());
        integrarTabla(document, "Multiṕlicidad : ", this.getMultiplicidad());

        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun run2 = paragraph2.createRun();
        run2.addBreak();
        run2.addBreak();
        run2.setText("Defunciones");
        run2.setFontSize(15);
        run2.setFontFamily("Arial Black");
        run2.setBold(true);
        run2.addBreak();
        run2.addBreak();
        integrarTablaDefuncion(document, "Area de defunción", this.getArea_defuncion());
        integrarTablaDefuncion(document, "Tipo defunción", this.getTipo_defuncion());
        integrarTablaDefuncion(document, "Dirección de defunción", this.getDireccion_defuncion());
        integrarTablaDefuncion(document, "Mujeres en fertelidad antes de defunción", this.getMujeres());
        integrarTablaDefuncion(document, "Tipo de profesión que certificado", this.getTipo_profesional());
        integrarTablaDefuncion(document, "Estado de Certificacion", this.getEstado_defuncion());
        try {
            System.out.println("*****************");
            FileOutputStream output = new FileOutputStream("/home/dark/proyectos/AnalizadorEstadisticasVitales/data/aaa.docx");
            document.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("logica.CalidadWord.writeFile() pinche ");
        }
    }

    public void integrarTabla(XWPFDocument document, String titulo, ArrayList<FilaEstadisticaVitalNacimientos> data) {
        if (data.size() > 0) {
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.addBreak();
            run2.addBreak();
            run2.setText(titulo + data.size());
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
            par_run1.setText("Fecha de entrega ");
            par_run.setBold(true);
            for (FilaEstadisticaVitalNacimientos f : data) {
                XWPFTableRow row1 = table.createRow();
                XWPFTableCell cell11 = row1.getCell(0);
                cell11.setText(f.getNumero_certificado());
                XWPFTableCell cell12 = row1.getCell(1);
                cell12.setText(f.getFecha_expedicion());
                System.out.println("  " + f.getNumero_certificado() + "  " + f.getFecha_expedicion());
            }
        }
    }
    
    public void integrarTablaDefuncion(XWPFDocument document, String titulo, ArrayList<EstadisticaVital_defuncion> data) {
        if (data.size() > 0) {
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.addBreak();
            run2.addBreak();
            run2.setText(titulo + data.size());
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
            par_run.setText("Codigo del registro Defuncion");
            par_run.setBold(true);
            XWPFTableCell cell1 = row0.createCell();
            XWPFParagraph par1 = cell1.addParagraph();
            XWPFRun par_run1 = par1.createRun();
            par_run1.setFontFamily("Arial Black");
            par_run1.setFontSize(13);
            cell1.setColor("9965F3");
            par_run1.setText("Fecha de entrega ");
            par_run.setBold(true);
            for (EstadisticaVital_defuncion f : data) {
                XWPFTableRow row1 = table.createRow();
                XWPFTableCell cell11 = row1.getCell(0);
                cell11.setText(f.getNumero_certificado());
                XWPFTableCell cell12 = row1.getCell(1);
                cell12.setText(f.getFecha_expedicion());
                System.out.println("  " + f.getNumero_certificado() + "  " + f.getFecha_expedicion());
            }
        }
    }

}
