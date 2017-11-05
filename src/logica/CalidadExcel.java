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
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dark
 */
public class CalidadExcel extends Reporte {

    public CalidadExcel(int con_area_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento, int con_sitio_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento, int con_semana_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion, int con_peso, ArrayList<FilaEstadisticaVitalNacimientos> peso, int con_peso_tiempo_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion, int con_talla, ArrayList<FilaEstadisticaVitalNacimientos> talla, int con_peso_tiempo_gestacion_talla, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla, int con_grupo_sanguineo, ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo, int con_factor_rh, ArrayList<FilaEstadisticaVitalNacimientos> factor_rh, int con_direccion, ArrayList<FilaEstadisticaVitalNacimientos> direccion, int con_edad_padre, ArrayList<FilaEstadisticaVitalNacimientos> edad_padre, int con_estado, ArrayList<FilaEstadisticaVitalNacimientos> estado, int con_multiplicidad, ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad, ArrayList<EstadisticaVital_defuncion> area_defuncion, ArrayList<EstadisticaVital_defuncion> tipo_defuncion, ArrayList<EstadisticaVital_defuncion> direccion_defuncion, ArrayList<EstadisticaVital_defuncion> mujeres, ArrayList<EstadisticaVital_defuncion> tipo_profesional, ArrayList<EstadisticaVital_defuncion> estado_defuncion, int municipio) {
        super(con_area_nacimiento, area_nacimiento, con_sitio_nacimiento, sitio_nacimiento, con_semana_gestacion, semana_gestacion, con_peso, peso, con_peso_tiempo_gestacion, peso_tiempo_gestacion, con_talla, talla, con_peso_tiempo_gestacion_talla, peso_tiempo_gestacion_talla, con_grupo_sanguineo, grupo_sanguineo, con_factor_rh, factor_rh, con_direccion, direccion, con_edad_padre, edad_padre, con_estado, estado, con_multiplicidad, multiplicidad, area_defuncion, tipo_defuncion, direccion_defuncion, mujeres, tipo_profesional, estado_defuncion, municipio);
    }

    @Override
    public void writeFile() {
        try {
            FileCopy c = new FileCopy();
            ManejadorMunicipio m = new ManejadorMunicipio();
            String path = "";
            String basePath = new File("").getAbsolutePath();
            if (System.getProperty("os.name").contains("Linux")) {
                path = this.getPath() + "/" + "calidad_" + m.getMunicipio(this.getMunicipio()) + ".xlsx";
                c.fileCopy(basePath + "/data/calidad.xlsx", path);
            } else {
                path = this.getPath() + "\\" + "calidad_" + m.getMunicipio(this.getMunicipio()) + ".xlsx";
                c.fileCopy(basePath + "\\data\\calidad.xlsx", path);
            }
            File file = new File(path);
            //OPRTUNIDAD
            double oportunidad_nacimiento = this.getRegistros_oportunos_nacimientos() / this.getTotal_nacimientos();
            double oportunidad_defunciones = this.getRegistros_oportunos_defunciones() / this.getTotal_defunciones();
            float tem_mayor_nac = 0, tem_may_def = 0;
            if (this.getArea_nacimiento().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getArea_nacimiento().size();
            }
            if (this.getSitio_nacimiento().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getSitio_nacimiento().size();
            }
            if (this.getSemana_gestacion().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getSemana_gestacion().size();
            }
            if (this.getPeso().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getPeso().size();
            }
            if (this.getPeso_tiempo_gestacion().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getPeso_tiempo_gestacion().size();
            }
            if (this.getPeso_tiempo_gestacion_talla().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getPeso_tiempo_gestacion_talla().size();
            }
            if (this.getGrupo_sanguineo().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getGrupo_sanguineo().size();
            }
            if (this.getFactor_rh().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getFactor_rh().size();
            }
            if (this.getDireccion().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getDireccion().size();
            }
            if (this.getEdad_padre().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getEdad_padre().size();
            }
            if (this.getEstado().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getEstado().size();
            }
            if (this.getMultiplicidad().size() > tem_mayor_nac) {
                tem_mayor_nac = this.getMultiplicidad().size();
            }
            if (tem_may_def < this.getArea_defuncion().size()) {
                tem_may_def = this.getArea_defuncion().size();
            }
            if (tem_may_def < this.getTipo_defuncion().size()) {
                tem_may_def = this.getTipo_defuncion().size();
            }
            if (tem_may_def < this.getDireccion_defuncion().size()) {
                tem_may_def = this.getDireccion_defuncion().size();
            }
            if (tem_may_def < this.getMujeres().size()) {
                tem_may_def = this.getMujeres().size();
            }
            if (tem_may_def < this.getTipo_profesional().size()) {
                tem_may_def = this.getTipo_profesional().size();
            }
            if (tem_may_def < this.getEstado_defuncion().size()) {
                tem_may_def = this.getEstado_defuncion().size();
            }
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
            String hosp = "";
            cli:
            for (String s : this.getInstituciones_de_salud_nacimiento()) {
                if (s.contains("HOSPITAL/CL�NICA") || s.contains("HOSPITAL")) {
                    hosp = s;
                    break cli;
                }
            }
            ManejadorMunicipio muni = new ManejadorMunicipio();
            sheet.getRow(pos).getCell(3).setCellValue(hosp);
            sheet.getRow(pos).getCell(2).setCellValue(muni.getMunicipio(this.getMunicipio()));
            float res_oport_naci = this.getRegistros_oportunos_nacimientos() / this.getTotal_nacimientos();
            float res_oport_defu = this.getRegistros_oportunos_defunciones() / this.getTotal_defunciones();
            float calidad_naci = (this.getTotal_nacimientos() - tem_mayor_nac) / this.getTotal_nacimientos();
            System.out.println(" " + this.getTotal_nacimientos() + "   " + tem_mayor_nac);
            float calidad_def = (this.getTotal_defunciones() - tem_may_def) / this.getTotal_defunciones();
            System.out.println(" calidad ---> " + tem_mayor_nac + "   " + tem_may_def);
            sheet.getRow(1).getCell(2).setCellValue("VIRGILIO");
            sheet.getRow(pos).getCell(7).setCellValue(res_oport_naci);
            sheet.getRow(pos).getCell(8).setCellValue(res_oport_defu);
            sheet.getRow(pos).getCell(9).setCellValue(calidad_naci);
            sheet.getRow(pos).getCell(10).setCellValue(calidad_def);
            System.out.println(pos + " " + res_oport_naci + "  " + res_oport_defu + " " + calidad_naci + "  " + calidad_def);
            System.out.println("============================");
            System.out.println(area_defuncion.size());
            System.out.println(tipo_defuncion.size());
            System.out.println(direccion_defuncion.size());
            System.out.println(mujeres.size());
            System.out.println(tipo_profesional.size());
            System.out.println(estado_defuncion.size());
            System.out.println(tem_may_def);
            System.out.println("************************************");
            System.out.println(this.getArea_nacimiento().size());
            System.out.println(getSitio_nacimiento().size());
            System.out.println(getSemana_gestacion().size());
            System.out.println(getPeso().size());
            System.out.println(getPeso_tiempo_gestacion().size());
            System.out.println(getPeso_tiempo_gestacion_talla().size());
            System.out.println(getGrupo_sanguineo().size());
            System.out.println(getFactor_rh().size());
            System.out.println(getDireccion().size());
            System.out.println(getEdad_padre().size());
            System.out.println(getEstado().size());
            System.out.println(getMultiplicidad().size());
            System.out.println(tem_mayor_nac);
            System.out.println("============================");
            FileOutputStream out = new FileOutputStream(path);
            wb.write(out);
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalidadExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalidadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CeldaCalidadExcel getCelda() {

        FileCopy c = new FileCopy();
        ManejadorMunicipio m = new ManejadorMunicipio();
        //OPRTUNIDAD
        double oportunidad_nacimiento = this.getRegistros_oportunos_nacimientos() / this.getTotal_nacimientos();
        double oportunidad_defunciones = this.getRegistros_oportunos_defunciones() / this.getTotal_defunciones();
        float tem_mayor_nac = 0, tem_may_def = 0;
        if (this.getArea_nacimiento().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getArea_nacimiento().size();
        }
        if (this.getSitio_nacimiento().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getSitio_nacimiento().size();
        }
        if (this.getSemana_gestacion().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getSemana_gestacion().size();
        }
        if (this.getPeso().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getPeso().size();
        }
        if (this.getPeso_tiempo_gestacion().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getPeso_tiempo_gestacion().size();
        }
        if (this.getPeso_tiempo_gestacion_talla().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getPeso_tiempo_gestacion_talla().size();
        }
        if (this.getGrupo_sanguineo().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getGrupo_sanguineo().size();
        }
        if (this.getFactor_rh().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getFactor_rh().size();
        }
        if (this.getDireccion().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getDireccion().size();
        }
        if (this.getEdad_padre().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getEdad_padre().size();
        }
        if (this.getEstado().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getEstado().size();
        }
        if (this.getMultiplicidad().size() > tem_mayor_nac) {
            tem_mayor_nac = this.getMultiplicidad().size();
        }
        if (tem_may_def < this.getArea_defuncion().size()) {
            tem_may_def = this.getArea_defuncion().size();
        }
        if (tem_may_def < this.getTipo_defuncion().size()) {
            tem_may_def = this.getTipo_defuncion().size();
        }
        if (tem_may_def < this.getDireccion_defuncion().size()) {
            tem_may_def = this.getDireccion_defuncion().size();
        }
        if (tem_may_def < this.getMujeres().size()) {
            tem_may_def = this.getMujeres().size();
        }
        if (tem_may_def < this.getTipo_profesional().size()) {
            tem_may_def = this.getTipo_profesional().size();
        }
        if (tem_may_def < this.getEstado_defuncion().size()) {
            tem_may_def = this.getEstado_defuncion().size();
        }
        String hosp = "";
        cli:
        for (String s : this.getInstituciones_de_salud_nacimiento()) {
            if (s.contains("HOSPITAL/CL�NICA") || s.contains("HOSPITAL")) {
                hosp = s;
                break cli;
            }
        }
        
        float res_oport_naci = this.getRegistros_oportunos_nacimientos() / this.getTotal_nacimientos();
        float res_oport_defu = this.getRegistros_oportunos_defunciones() / this.getTotal_defunciones();
        float calidad_naci = (this.getTotal_nacimientos() - tem_mayor_nac) / this.getTotal_nacimientos();
        float calidad_def = (this.getTotal_defunciones() - tem_may_def) / this.getTotal_defunciones();
        return new CeldaCalidadExcel(m.getMunicipio(this.getMunicipio()),
                hosp, 
                res_oport_naci, 
                res_oport_defu, calidad_naci, calidad_def);
    }
}
