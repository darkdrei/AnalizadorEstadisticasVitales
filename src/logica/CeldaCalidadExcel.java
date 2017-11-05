/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author dark
 */
public class CeldaCalidadExcel {
    private String zode;
    private String municipio;
    private String entidad;
    private String periodo;
    private float cobertura_vivo;
    private float cobertura_defuncion;
    private float calidad_vivo;
    private float calidad_defunciones;
    private String responsable;
    private String observeciones;

    public CeldaCalidadExcel(String zode, String municipio, String entidad, String periodo, float cobertura_vivo, float cobertura_defuncion, float calidad_vivo, float calidad_defunciones, String responsable, String observeciones) {
        this.zode = zode;
        this.municipio = municipio;
        this.entidad = entidad;
        this.periodo = periodo;
        this.cobertura_vivo = cobertura_vivo;
        this.cobertura_defuncion = cobertura_defuncion;
        this.calidad_vivo = calidad_vivo;
        this.calidad_defunciones = calidad_defunciones;
        this.responsable = responsable;
        this.observeciones = observeciones;
    }
    
    public CeldaCalidadExcel(String municipio, String entidad, float cobertura_vivo, float cobertura_defuncion, float calidad_vivo, float calidad_defunciones) {
        this.zode = "";
        this.municipio = municipio;
        this.entidad = entidad;
        this.periodo = "";
        this.cobertura_vivo = cobertura_vivo;
        this.cobertura_defuncion = cobertura_defuncion;
        this.calidad_vivo = calidad_vivo;
        this.calidad_defunciones = calidad_defunciones;
        this.responsable = "";
        this.observeciones = "";
    }

    
}
