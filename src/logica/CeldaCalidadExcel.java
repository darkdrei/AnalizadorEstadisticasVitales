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
    private float oportunidad_vivo;
    private float oportunidad_defuncion;
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
    
    public CeldaCalidadExcel(String municipio, String entidad, float oportunidad_vivo, float oportunidad_defuncion, float calidad_vivo, float calidad_defunciones) {
        this.zode = "";
        this.municipio = municipio;
        this.entidad = entidad;
        this.periodo = "";
        this.cobertura_vivo = oportunidad_vivo;
        this.cobertura_defuncion = oportunidad_defuncion;
        this.oportunidad_vivo = oportunidad_vivo;
        this.oportunidad_defuncion = oportunidad_defuncion;
        this.calidad_vivo = calidad_vivo;
        this.calidad_defunciones = calidad_defunciones;
        this.responsable = "";
        this.observeciones = "";
    }

    public String getZode() {
        return zode;
    }

    public void setZode(String zode) {
        this.zode = zode;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public float getCobertura_vivo() {
        return cobertura_vivo;
    }

    public void setCobertura_vivo(float cobertura_vivo) {
        this.cobertura_vivo = cobertura_vivo;
    }

    public float getCobertura_defuncion() {
        return cobertura_defuncion;
    }

    public void setCobertura_defuncion(float cobertura_defuncion) {
        this.cobertura_defuncion = cobertura_defuncion;
    }

    public float getOportunidad_vivo() {
        return oportunidad_vivo;
    }

    public void setOportunidad_vivo(float oportunidad_vivo) {
        this.oportunidad_vivo = oportunidad_vivo;
    }

    public float getOportunidad_defuncion() {
        return oportunidad_defuncion;
    }

    public void setOportunidad_defuncion(float oportunidad_defuncion) {
        this.oportunidad_defuncion = oportunidad_defuncion;
    }

    public float getCalidad_vivo() {
        return calidad_vivo;
    }

    public void setCalidad_vivo(float calidad_vivo) {
        this.calidad_vivo = calidad_vivo;
    }

    public float getCalidad_defunciones() {
        return calidad_defunciones;
    }

    public void setCalidad_defunciones(float calidad_defunciones) {
        this.calidad_defunciones = calidad_defunciones;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getObserveciones() {
        return observeciones;
    }

    public void setObserveciones(String observeciones) {
        this.observeciones = observeciones;
    }

    
}
