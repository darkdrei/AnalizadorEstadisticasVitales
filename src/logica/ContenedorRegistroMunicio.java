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
public class ContenedorRegistroMunicio {
    private ArrayList<RegistrosMunicipio> registros;

    public ContenedorRegistroMunicio() {
        registros = new ArrayList<>();
    }

    public ArrayList<RegistrosMunicipio> getRegistros() {
        return registros;
    }
    

    public void setRegistros(ArrayList<RegistrosMunicipio> registros) {
        this.registros = registros;
    }
    
    public void addRegistro(RegistrosMunicipio r)  {
        this.registros.add(r);
    } 
    
    public int size(){
        return this.registros.size();
    }
    
    
}
