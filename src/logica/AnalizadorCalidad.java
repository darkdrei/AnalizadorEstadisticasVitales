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
public class AnalizadorCalidad implements OperacionesCalidad {

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

    public void addRegistro(RegistrosMunicipio r) {
        this.datos.addRegistro(r);
    }

    @Override
    public void analizarCalidaDeLaInformacion() {
        for (RegistrosMunicipio r : this.getDatos().getRegistros()) {
            int con_area_nacimiento = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento = new ArrayList<>();
            int con_sitio_nacimiento = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento = new ArrayList<>();
            int con_semana_gestacion = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion = new ArrayList<>();
            int con_peso = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso = new ArrayList<>();
            int con_peso_tiempo_gestacion = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion = new ArrayList<>();
            int con_talla = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> talla = new ArrayList<>();
            int con_peso_tiempo_gestacion_talla = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla = new ArrayList<>();
            int con_grupo_sanguineo = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo = new ArrayList<>();
            int con_factor_rh = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> factor_rh = new ArrayList<>();
            int con_direccion = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> direccion = new ArrayList<>();
            int con_edad_padre = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> edad_padre = new ArrayList<>();
            int con_estado = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> estado = new ArrayList<>();
            int con_multiplicidad = 0;
            ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad = new ArrayList<>();
            for (FilaEstadisticaVitalNacimientos n : r.getNacimientos()) {
                //System.out.println(n.getArea_nacimiento()+"  "+n.getSitio_nacimiento());
                if (n.getArea_nacimiento().equals("RURAL DISPERSO") && n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD")) {
                    con_area_nacimiento++;
                    area_nacimiento.add(n);
                }

                if (n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD") && !n.getParto_atendido_por().equals("M�DICO")) {
                    con_sitio_nacimiento++;
                    sitio_nacimiento.add(n);
                }

                if (Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion())) {
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    if (semana < 37 || semana > 42) {
                        con_semana_gestacion++;
                        semana_gestacion.add(n);
                    }
                } else {
                    con_semana_gestacion++;
                    semana_gestacion.add(n);
                }
                if (Pattern.matches("\\d{1,6}", n.getPeso())) {
                    float peso2 = Float.parseFloat(n.getPeso());
                    if (peso2 < 2500) {
                        con_peso++;
                        //System.out.println(con_peso+" "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                        peso.add(n);
                    }
                } else {
                    con_peso++;
                    peso.add(n);
                    //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                }
                if (Pattern.matches("\\d{1,6}", n.getPeso()) && Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion())) {
                    float peso2 = Float.parseFloat(n.getPeso());
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    if (peso2 < 2500 && semana > 37) {
                        con_peso_tiempo_gestacion++;
                        peso_tiempo_gestacion.add(n);
                        //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getTiempo_de_gestion()+"  "+n.getNumero_certificado());
                    }
                }
                if (Pattern.matches("\\d{1,6}", n.getTalla())) {
                    float talla2 = Float.parseFloat(n.getTalla());
                    if (talla2 < 45 || talla2 > 55) {
                        con_talla++;
                        //System.out.println(con_peso+" "+n.getTalla()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                        talla.add(n);
                    }
                } else {
                    con_talla++;
                    talla.add(n);
                    //System.out.println(con_peso+" ++ "+n.getPeso()+ "  "+n.getMunicipio()+"  "+n.getNumero_certificado());
                }
                if (Pattern.matches("\\d{1,6}", n.getPeso()) && Pattern.matches("\\d{1,2}", n.getTiempo_de_gestion()) && Pattern.matches("\\d{1,6}", n.getTalla())) {
                    float peso2 = Float.parseFloat(n.getPeso());
                    int semana = Integer.parseInt(n.getTiempo_de_gestion());
                    float talla2 = Float.parseFloat(n.getTalla());
                    if (semana >= 37 && semana <= 42 && peso2 > 2500 && talla2 < 45) {
                        con_peso_tiempo_gestacion_talla++;
                        peso_tiempo_gestacion_talla.add(n);
                        //System.out.println(n.getTalla()+" ++ "+n.getPeso()+ "  "+n.getTiempo_de_gestion()+"  "+n.getNumero_certificado());
                    }
                }
                if (!Pattern.matches("[A-Za-z]{1,2}", n.getGrupo_sanguineo())) {
                    //System.out.println(n.getGrupo_sanguineo());
                    con_grupo_sanguineo++;
                    grupo_sanguineo.add(n);
                }
                //System.err.println(n.getFactor_rh());
                if (!Pattern.matches("POSITIVO|NEGATIVO", n.getFactor_rh().toUpperCase())) {
                    //System.err.println(n.getFactor_rh()+"  *");
                    con_factor_rh++;
                    factor_rh.add(n);
                }
                if (n.getDireccion().length() == 0) {
                    //System.err.println(n.getFactor_rh()+"  *");
                    con_direccion++;
                    direccion.add(n);
                }
                if (!Pattern.matches("\\d+{2,2}\\(4\\)", n.getEdad_padre())) {
                    //System.err.println(n.getEdad_padre()+"  *");
                    con_edad_padre++;
                    edad_padre.add(n);
                }
                //System.out.println(n.getEstado_certificado());
                if (!Pattern.matches("CONFITMADO", n.getEstado_certificado().toUpperCase())) {
                    //System.err.println(n.getEdad_padre()+"  *");
                    con_estado++;
                    estado.add(n);
                    //System.out.println(n.getEstado_certificado());
                }
                //System.out.println(" multiplicidad --> "+n.getMultiplicidad_embarazo());
                if (Pattern.matches("[A-Z]+", n.getMultiplicidad_embarazo())) {
                    String m = n.getMultiplicidad_embarazo();
                    int emb = m.equals("SIMPLE") ? 1 : m.equals("DOBLE") ? 2 : m.equals("CU�DRUPLE O M�S") ? 4 : m.equals("TRIPLE") ? 3 : 0;
                    if (emb > 0) {
                        int tem_con = 0;
                        for (FilaEstadisticaVitalNacimientos n2 : r.getNacimientos()) {
                            if (n.getNumero_documento_madre().equals(n2.getNumero_documento_madre())) {
                                tem_con++;
                            }
                        }
                        if ((emb != tem_con && emb > tem_con)) {
                            con_multiplicidad++;
                            multiplicidad.add(n);
                        }else if (emb != tem_con){
                            con_multiplicidad++;
                            multiplicidad.add(n);
                        }
                    }
                } else {
                    con_multiplicidad++;
                    multiplicidad.add(n);
                }
            }
        }
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
