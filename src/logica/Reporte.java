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
    private int municipio;

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
            ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad,
            int municipio)
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
        this.municipio = municipio;
    }
    
    
    
    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCon_area_nacimiento() {
        return con_area_nacimiento;
    }

    public void setCon_area_nacimiento(int con_area_nacimiento) {
        this.con_area_nacimiento = con_area_nacimiento;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getArea_nacimiento() {
        return area_nacimiento;
    }

    public void setArea_nacimiento(ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento) {
        this.area_nacimiento = area_nacimiento;
    }

    public int getCon_sitio_nacimiento() {
        return con_sitio_nacimiento;
    }

    public void setCon_sitio_nacimiento(int con_sitio_nacimiento) {
        this.con_sitio_nacimiento = con_sitio_nacimiento;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getSitio_nacimiento() {
        return sitio_nacimiento;
    }

    public void setSitio_nacimiento(ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento) {
        this.sitio_nacimiento = sitio_nacimiento;
    }

    public int getCon_semana_gestacion() {
        return con_semana_gestacion;
    }

    public void setCon_semana_gestacion(int con_semana_gestacion) {
        this.con_semana_gestacion = con_semana_gestacion;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getSemana_gestacion() {
        return semana_gestacion;
    }

    public void setSemana_gestacion(ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion) {
        this.semana_gestacion = semana_gestacion;
    }

    public int getCon_peso() {
        return con_peso;
    }

    public void setCon_peso(int con_peso) {
        this.con_peso = con_peso;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getPeso() {
        return peso;
    }

    public void setPeso(ArrayList<FilaEstadisticaVitalNacimientos> peso) {
        this.peso = peso;
    }

    public int getCon_peso_tiempo_gestacion() {
        return con_peso_tiempo_gestacion;
    }

    public void setCon_peso_tiempo_gestacion(int con_peso_tiempo_gestacion) {
        this.con_peso_tiempo_gestacion = con_peso_tiempo_gestacion;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getPeso_tiempo_gestacion() {
        return peso_tiempo_gestacion;
    }

    public void setPeso_tiempo_gestacion(ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion) {
        this.peso_tiempo_gestacion = peso_tiempo_gestacion;
    }

    public int getCon_talla() {
        return con_talla;
    }

    public void setCon_talla(int con_talla) {
        this.con_talla = con_talla;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getTalla() {
        return talla;
    }

    public void setTalla(ArrayList<FilaEstadisticaVitalNacimientos> talla) {
        this.talla = talla;
    }

    public int getCon_peso_tiempo_gestacion_talla() {
        return con_peso_tiempo_gestacion_talla;
    }

    public void setCon_peso_tiempo_gestacion_talla(int con_peso_tiempo_gestacion_talla) {
        this.con_peso_tiempo_gestacion_talla = con_peso_tiempo_gestacion_talla;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getPeso_tiempo_gestacion_talla() {
        return peso_tiempo_gestacion_talla;
    }

    public void setPeso_tiempo_gestacion_talla(ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla) {
        this.peso_tiempo_gestacion_talla = peso_tiempo_gestacion_talla;
    }

    public int getCon_grupo_sanguineo() {
        return con_grupo_sanguineo;
    }

    public void setCon_grupo_sanguineo(int con_grupo_sanguineo) {
        this.con_grupo_sanguineo = con_grupo_sanguineo;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public int getCon_factor_rh() {
        return con_factor_rh;
    }

    public void setCon_factor_rh(int con_factor_rh) {
        this.con_factor_rh = con_factor_rh;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getFactor_rh() {
        return factor_rh;
    }

    public void setFactor_rh(ArrayList<FilaEstadisticaVitalNacimientos> factor_rh) {
        this.factor_rh = factor_rh;
    }

    public int getCon_direccion() {
        return con_direccion;
    }

    public void setCon_direccion(int con_direccion) {
        this.con_direccion = con_direccion;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<FilaEstadisticaVitalNacimientos> direccion) {
        this.direccion = direccion;
    }

    public int getCon_edad_padre() {
        return con_edad_padre;
    }

    public void setCon_edad_padre(int con_edad_padre) {
        this.con_edad_padre = con_edad_padre;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getEdad_padre() {
        return edad_padre;
    }

    public void setEdad_padre(ArrayList<FilaEstadisticaVitalNacimientos> edad_padre) {
        this.edad_padre = edad_padre;
    }

    public int getCon_estado() {
        return con_estado;
    }

    public void setCon_estado(int con_estado) {
        this.con_estado = con_estado;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getEstado() {
        return estado;
    }

    public void setEstado(ArrayList<FilaEstadisticaVitalNacimientos> estado) {
        this.estado = estado;
    }

    public int getCon_multiplicidad() {
        return con_multiplicidad;
    }

    public void setCon_multiplicidad(int con_multiplicidad) {
        this.con_multiplicidad = con_multiplicidad;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getMultiplicidad() {
        return multiplicidad;
    }

    public void setMultiplicidad(ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad) {
        this.multiplicidad = multiplicidad;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }
}