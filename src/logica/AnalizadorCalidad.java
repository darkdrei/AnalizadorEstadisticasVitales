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
public class AnalizadorCalidad implements OperacionesCalidad{
    private ContenedorRegistroMunicio datos;

    public AnalizadorCalidad() {
        this.datos = new ContenedorRegistroMunicio();
    }

    public ContenedorRegistroMunicio getDatos() {
        return datos;
    }

    public void setDatos(ContenedorRegistroMunicio datos) {
        this.datos = datos;
    }
    
    public void addRegistro(RegistrosMunicipio r){
        this.datos.addRegistro(r);
    }
    

    @Override
    public void analizarCalidaDeLaInformacion() {
        for ( RegistrosMunicipio r : this.getDatos().getRegistros()){
            int con_area_nacimiento = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento = new ArrayList<>();
            for(FilaEstadisticaVitalNacimientos n :r.getNacimientos()){
                //System.out.println(n.getArea_nacimiento()+"  "+n.getSitio_nacimiento());
                if (n.getArea_nacimiento().equals("RURAL DISPERSO") && n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD")){
                    con_area_nacimiento++;
                    area_nacimiento.add(n);
                }
                if(n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD"))
                
            }
        }
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
