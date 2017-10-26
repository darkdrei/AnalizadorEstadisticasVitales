/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author dark
 */
public class Reporte implements ExportFile{
    private int con_area_nacimiento = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento = new ArrayList<>();
    private int con_sitio_nacimiento = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento = new ArrayList<>();
    private int con_semana_gestacion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion = new ArrayList<>();
    private int con_peso = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso = new ArrayList<>();
    private int con_peso_tiempo_gestacion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion = new ArrayList<>();
    private int con_talla = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> talla = new ArrayList<>();
    private int con_peso_tiempo_gestacion_talla = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla = new ArrayList<>();
    private int con_grupo_sanguineo = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo = new ArrayList<>();
    private int con_factor_rh = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> factor_rh = new ArrayList<>();
    private int con_direccion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> direccion = new ArrayList<>();
    private int con_edad_padre = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> edad_padre = new ArrayList<>();
    private int con_estado = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> estado = new ArrayList<>();
    private int con_multiplicidad = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad = new ArrayList<>();

    public Reporte(int con_area_nacimiento, 
            ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento,
            int con_sitio_nacimiento,
            ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento,
            int con_semana_gestacion,
            ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion,
            int con_peso,
            ArrayList<FilaEstadisticaVitalNacimientos> peso,
            int con_peso_tiempo_gestacion,
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion,
            int con_talla,
            ArrayList<FilaEstadisticaVitalNacimientos> talla,
            int con_peso_tiempo_gestacion_talla,
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla,
            int con_grupo_sanguineo,
            ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo,
            int con_factor_rh,
            ArrayList<FilaEstadisticaVitalNacimientos> factor_rh,
            int con_direccion,
            ArrayList<FilaEstadisticaVitalNacimientos> direccion,
            int con_edad_padre,
            ArrayList<FilaEstadisticaVitalNacimientos> edad_padre,
            int con_estado,
            ArrayList<FilaEstadisticaVitalNacimientos> estado,
            int con_multiplicidad,
            ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad)
    {
        this.con_area_nacimiento = con_area_nacimiento;
        this.area_nacimiento =area_nacimiento;
        this.con_sitio_nacimiento = con_sitio_nacimiento;
        this.sitio_nacimiento =sitio_nacimiento;
        this.con_semana_gestacion = con_semana_gestacion;
        this.semana_gestacion = semana_gestacion;
        this.con_peso=con_peso;
        this.peso = peso;
        this.con_peso_tiempo_gestacion = con_peso_tiempo_gestacion;
        this.peso_tiempo_gestacion = peso_tiempo_gestacion;
        this.con_talla = con_talla;
        this.talla = talla;
        this.con_peso_tiempo_gestacion_talla = con_peso_tiempo_gestacion_talla;
        this.peso_tiempo_gestacion_talla = peso_tiempo_gestacion_talla;
        this.con_grupo_sanguineo = con_grupo_sanguineo;
        this.grupo_sanguineo = grupo_sanguineo;
        this.con_factor_rh = con_factor_rh;
        this.factor_rh = factor_rh;
        this.con_direccion = con_direccion;
        this.direccion = direccion;
        this.con_edad_padre=con_edad_padre;
        this.edad_padre = edad_padre;
        this.con_estado =  con_estado;
        this.estado = estado;
        this.con_multiplicidad = con_multiplicidad;
        this.multiplicidad = multiplicidad;
    }
    
    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
