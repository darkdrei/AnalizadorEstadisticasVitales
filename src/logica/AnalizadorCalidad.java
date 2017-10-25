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
            int con_peso =0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso = new ArrayList<>();
            int con_peso_tiempo_gestacion =0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion = new ArrayList<>();
            int con_talla =0;
            ArrayList<FilaEstadisticaVitalNacimientos> talla = new ArrayList<>();
            int con_peso_tiempo_gestacion_talla =0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla = new ArrayList<>();
            
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
                
                if (Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion())){
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    if (semana < 37 || semana > 42){
                        con_semana_gestacion++;
                        semana_gestacion.add(n);
                    }
                }else{
                    con_semana_gestacion++;
                    semana_gestacion.add(n);
                }
                if (Pattern.matches("\\d{1,6}", n.getPeso())){
                    float peso2 = Float.parseFloat(n.getPeso());
                    if (peso2 < 2500 ){
                        con_peso++;
                        //System.out.println(con_peso+" "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                        peso.add(n);
                    }
                }else{
                    con_peso++;
                    peso.add(n);
                    //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                }
                if(Pattern.matches("\\d{1,6}", n.getPeso()) && Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion())){
                    float peso2 = Float.parseFloat(n.getPeso());
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    if (peso2<2500 && semana>37){
                        con_peso_tiempo_gestacion++;
                        peso_tiempo_gestacion.add(n);
                        //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getTiempo_de_gestion()+"  "+n.getNumero_certificado());
                    }
                }
                if (Pattern.matches("\\d{1,6}", n.getTalla())){
                    float talla2 = Float.parseFloat(n.getTalla());
                    if (talla2 < 45 || talla2>55 ){
                        con_talla++;
                        //System.out.println(con_peso+" "+n.getTalla()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                        talla.add(n);
                    }
                }else{
                    con_talla++;
                    talla.add(n);
                    //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                }
                if(Pattern.matches("\\d{1,6}", n.getPeso()) && Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion()) && Pattern.matches("\\d{1,6}", n.getTalla())){
                    float peso2 = Float.parseFloat(n.getPeso());
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    float talla2 = Float.parseFloat(n.getTalla());
                    if (semana>=37 && semana<=42 && peso2> 2500 && talla2 < 45){
                        con_peso_tiempo_gestacion_talla++;
                        peso_tiempo_gestacion_talla.add(n);
                        System.out.println(n.getTalla()+" ++ "+n.getPeso()+ "  "+n.getTiempo_de_gestion()+"  "+n.getNumero_certificado());
                    }
                }
            }
        }
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
