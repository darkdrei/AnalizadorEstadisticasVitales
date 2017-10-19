/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class RegistrosMunicipio {
    private ArrayList<EstadisticaVital_defuncion> defunciones;
    private ArrayList<FilaEstadisticaVitalNacimientos> nacimientos;
    private int municipio;

    public RegistrosMunicipio(ArrayList<EstadisticaVital_defuncion> defunciones, ArrayList<FilaEstadisticaVitalNacimientos> nacimientos, int municipio) {
        this.defunciones = defunciones;
        this.nacimientos = nacimientos;
        this.municipio = municipio;
    }
    
    public RegistrosMunicipio(){
        this.defunciones = new ArrayList<>();
        this.nacimientos = new ArrayList<>();
        this.municipio = 0;
    }
    
    public String getNombreMunicipio(){
        ManejadorMunicipio m = new ManejadorMunicipio();
        return m.getMunicipio(this.getMunicipio());
    }

    public ArrayList<EstadisticaVital_defuncion> getDefunciones() {
        return defunciones;
    }

    public void setDefunciones(ArrayList<EstadisticaVital_defuncion> defunciones) {
        this.defunciones = defunciones;
    }

    public ArrayList<FilaEstadisticaVitalNacimientos> getNacimientos() {
        return nacimientos;
    }

    public void setNacimientos(ArrayList<FilaEstadisticaVitalNacimientos> nacimientos) {
        this.nacimientos = nacimientos;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }
    
    
    
    
}
