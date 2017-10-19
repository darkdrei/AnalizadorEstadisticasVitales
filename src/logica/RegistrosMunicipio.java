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
    private ArrayList<ControlPapeleriaDefunciones> defunciones;
    private ArrayList<ControlPapeleriaNacimientos> nacimientos;
    private int municipio;

    public RegistrosMunicipio(ArrayList<ControlPapeleriaDefunciones> defunciones, ArrayList<ControlPapeleriaNacimientos> nacimientos, int municipio) {
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

    public ArrayList<ControlPapeleriaDefunciones> getDefunciones() {
        return defunciones;
    }

    public void setDefunciones(ArrayList<ControlPapeleriaDefunciones> defunciones) {
        this.defunciones = defunciones;
    }

    public ArrayList<ControlPapeleriaNacimientos> getNacimientos() {
        return nacimientos;
    }

    public void setNacimientos(ArrayList<ControlPapeleriaNacimientos> nacimientos) {
        this.nacimientos = nacimientos;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }
    
    
    
    
}
