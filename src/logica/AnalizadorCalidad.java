/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
            int con_sitio_nacimiento = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento = new ArrayList<>();
            int con_semana_gestacion=0;
            ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion = new ArrayList<>();
            for(FilaEstadisticaVitalNacimientos n :r.getNacimientos()){
                //System.out.println(n.getArea_nacimiento()+"  "+n.getSitio_nacimiento());
                if (n.getArea_nacimiento().equals("RURAL DISPERSO") && n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD")){
                    con_area_nacimiento++;
                    area_nacimiento.add(n);
                }
                
                if(n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD") && !n.getProfesion_certificador().equals("M�DICO")){
                    con_sitio_nacimiento++;
                    sitio_nacimiento.add(n);
                    System.out.println(n.getProfesion_certificador());
                }
                
                if (Pattern.matches("\\d{2,2}", n.getTiempo_de_gestion())){
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    if (semana < 37 || semana > 42){
                        System.out.println(n.getTiempo_de_gestion());
                        con_semana_gestacion++;
                        semana_gestacion.add(n);
                    }
                }else{
                    con_semana_gestacion++;
                    semana_gestacion.add(n);
                }
                
                
            }
        }
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
