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
public class ContenedorInfoMunicipio {
    private ArrayList<TemporalInfo> municipios;

    public ContenedorInfoMunicipio(ArrayList<TemporalInfo> municipios) {
        this.municipios = municipios;
    }
    
    public ContenedorInfoMunicipio() {
        this.municipios = new ArrayList<>();
    }
    
    public void add(TemporalInfo t){
        this.municipios.add(t);
    }
    
    public int size(){
        return this.municipios.size();
    }
    
    public ArrayList getData(){
        return this.municipios;
    }
    
}
