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
    private int con_area_nacimiento = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento = new ArrayList<>();
    private int con_sitio_nacimiento = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento = new ArrayList<>();
    private int con_semana_gestacion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion = new ArrayList<>();
    private int con_peso = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso = new ArrayList<>();
    private int con_peso_tiempo_gestacion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion = new ArrayList<>();
    private int con_talla = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> talla = new ArrayList<>();
    private int con_peso_tiempo_gestacion_talla = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla = new ArrayList<>();
    private int con_grupo_sanguineo = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo = new ArrayList<>();
    private int con_factor_rh = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> factor_rh = new ArrayList<>();
    private int con_direccion = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> direccion = new ArrayList<>();
    private int con_edad_padre = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> edad_padre = new ArrayList<>();
    private int con_estado = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> estado = new ArrayList<>();
    private int con_multiplicidad = 0;
    private ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad = new ArrayList<>();
    /*DEFICION DE VARIABLES PARA DEFUNCIONES*/
    private ArrayList<EstadisticaVital_defuncion> area_defuncion = new ArrayList<>();
    private ArrayList<EstadisticaVital_defuncion> tipo_defuncion = new ArrayList<>();
    private ArrayList<EstadisticaVital_defuncion> direccion_defuncion = new ArrayList<>();
    private ArrayList<EstadisticaVital_defuncion> mujeres = new ArrayList<>();
    private ArrayList<EstadisticaVital_defuncion> tipo_profesional = new ArrayList<>();
    private ArrayList<EstadisticaVital_defuncion> estado_defuncion =new ArrayList<>();

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
        String hospital ="";
        for (RegistrosMunicipio r : this.getDatos().getRegistros()) {
            con_area_nacimiento = 0;
            area_nacimiento = new ArrayList<>();
            con_sitio_nacimiento = 0;
            sitio_nacimiento = new ArrayList<>();
            con_semana_gestacion = 0;
            semana_gestacion = new ArrayList<>();
            con_peso = 0;
            peso = new ArrayList<>();
            con_peso_tiempo_gestacion = 0;
            peso_tiempo_gestacion = new ArrayList<>();
            con_talla = 0;
            talla = new ArrayList<>();
            con_peso_tiempo_gestacion_talla = 0;
            peso_tiempo_gestacion_talla = new ArrayList<>();
            con_grupo_sanguineo = 0;
            grupo_sanguineo = new ArrayList<>();
            con_factor_rh = 0;
            factor_rh = new ArrayList<>();
            con_direccion = 0;
            direccion = new ArrayList<>();
            con_edad_padre = 0;
            edad_padre = new ArrayList<>();
            con_estado = 0;
            estado = new ArrayList<>();
            con_multiplicidad = 0;
            multiplicidad = new ArrayList<>();
            ArrayList<String> instituciones_de_salud_nacimiento = new ArrayList<>();
            ArrayList<String> instituciones_de_salud_defunciones = new ArrayList<>();
            for (FilaEstadisticaVitalNacimientos n : r.getNacimientos()) {
                if(!n.getNombre_institucion().equals(hospital)){
                    hospital = n.getNombre_institucion();
                    instituciones_de_salud_nacimiento.add(hospital);
                }
                //System.out.println(n.getArea_nacimiento()+"  "+n.getSitio_nacimiento());
                if ((n.getArea_nacimiento().equals("EL DOMICILIO") || n.getArea_nacimiento().equals("RURAL DISPERSO")) && n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD")) {
                    con_area_nacimiento++;
                    area_nacimiento.add(n);
                    System.out.println(n.getArea_nacimiento() + "  " + n.getSitio_nacimiento());
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

                if (!Pattern.matches("CONFIRMADO", n.getEstado_certificado().toUpperCase())) {
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
                        } else if (emb != tem_con) {
                            con_multiplicidad++;
                            multiplicidad.add(n);
                        }
                    }
                } else {
                    con_multiplicidad++;
                    multiplicidad.add(n);
                }
            }
            area_defuncion = new ArrayList<>();
            tipo_defuncion = new ArrayList<>();
            direccion_defuncion = new ArrayList<>();
            mujeres = new ArrayList<>();
            tipo_profesional = new ArrayList<>();
            estado_defuncion =new ArrayList<>();
            hospital="";
            for (EstadisticaVital_defuncion d : r.getDefunciones()) {
                //((d.getArea_de_defuncion().equals("RURAL DISPERSO"))&& (d.getSitio_defuncion().equals("HOSPITAL") || d.getSitio_defuncion().equals("CL�NICA") || d.getSitio_defuncion().equals("HOSPITAL/CL�NICA")))
               if(!d.getNombre_institucion().equals(hospital)){
                    hospital = d.getNombre_institucion();
                    instituciones_de_salud_defunciones.add(hospital);
                }
                if (((d.getArea_de_defuncion().equals("RURAL DISPERSO"))&& (d.getSitio_defuncion().equals("HOSPITAL") || d.getSitio_defuncion().equals("CL�NICA") || d.getSitio_defuncion().equals("HOSPITAL/CL�NICA")))||(d.getArea_de_defuncion().equals("CABECERA MUNICIPAL") && (!d.getSitio_defuncion().contains("HOSPITAL") || !d.getSitio_defuncion().contains("CL�NICA") || !d.getSitio_defuncion().contains("HOSPITAL/CL�NICA")))) {
                    area_defuncion.add(d);
                    System.out.println(""+d.getArea_de_defuncion()+"   "+d.getSitio_defuncion());
                }
                if (d.getTipo_defuncion().equals("FETAL") && (!d.getNombres_fallecido().equals("") || !d.getNumero_documento_fallecido().equals(""))) {
                    tipo_defuncion.add(d);
                }
                if (d.getDireccion().length() == 0) {
                    //System.err.println(n.getFactor_rh()+"  *");
                    con_direccion++;
                    direccion_defuncion.add(d);
                }
                if (d.getSexo_fallecido().equals("FEMENINO") && Pattern.matches("\\d+{2,2}\\(4\\)", d.getEdad_fallecido())) {
                    float edad = Float.parseFloat(d.getEdad_fallecido().split("\\(")[0]);
                    if (edad >= 15 && edad <= 54) {
                        if (!Pattern.matches("SI|NO", d.getEmbarazada_cuandno_fallecio())
                                || !Pattern.matches("SI|NO", d.getEmbarazada_ultimas_12_meses())
                                || !Pattern.matches("SI|NO", d.getEmbarazada_ultimas_6_semanas())) {
                            mujeres.add(d);
                        }
                    }
                }
                if(d.getTipo_profesion().length()>0){
                    
                    if(!d.getExpedido_por().contains(d.getTipo_profesion()) ){
                        tipo_profesional.add(d);
                    }
                }else{
                    tipo_profesional.add(d);
                }
                if (!Pattern.matches("CONFIRMADO", d.getEstado_certificado().toUpperCase())) {
                    //System.err.println(n.getEdad_padre()+"  *");
                    estado_defuncion.add(d);
                    //System.out.println(n.getEstado_certificado());
                }                

            }
            CalidadWord word = new CalidadWord(con_area_nacimiento, area_nacimiento, con_sitio_nacimiento, sitio_nacimiento, con_semana_gestacion, semana_gestacion, con_peso, peso, con_peso_tiempo_gestacion, peso_tiempo_gestacion, con_talla, talla, con_peso_tiempo_gestacion_talla, peso_tiempo_gestacion_talla, con_grupo_sanguineo, grupo_sanguineo, con_factor_rh, factor_rh, con_direccion, direccion, con_edad_padre, edad_padre, con_estado, estado, con_multiplicidad, multiplicidad,
                                               area_defuncion,tipo_defuncion,direccion_defuncion,mujeres,tipo_profesional,estado_defuncion,r.getMunicipio());
            word.setMunicipio(r.getMunicipio());
            word.setInstituciones_de_salud_nacimiento(instituciones_de_salud_nacimiento);
            word.setInstituciones_de_salud_defunciones(instituciones_de_salud_defunciones);
            word.setTotal_nacimientos(r.getNacimientos().size());
            word.setTotal_defunciones(r.getDefunciones().size());
            word.writeFile();
        }
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        String hospital ="";
        for (RegistrosMunicipio r : this.getDatos().getRegistros()) {
            con_area_nacimiento = 0;
            area_nacimiento = new ArrayList<>();
            con_sitio_nacimiento = 0;
            sitio_nacimiento = new ArrayList<>();
            con_semana_gestacion = 0;
            semana_gestacion = new ArrayList<>();
            con_peso = 0;
            peso = new ArrayList<>();
            con_peso_tiempo_gestacion = 0;
            peso_tiempo_gestacion = new ArrayList<>();
            con_talla = 0;
            talla = new ArrayList<>();
            con_peso_tiempo_gestacion_talla = 0;
            peso_tiempo_gestacion_talla = new ArrayList<>();
            con_grupo_sanguineo = 0;
            grupo_sanguineo = new ArrayList<>();
            con_factor_rh = 0;
            factor_rh = new ArrayList<>();
            con_direccion = 0;
            direccion = new ArrayList<>();
            con_edad_padre = 0;
            edad_padre = new ArrayList<>();
            con_estado = 0;
            estado = new ArrayList<>();
            con_multiplicidad = 0;
            multiplicidad = new ArrayList<>();
            ArrayList<String> instituciones_de_salud_nacimiento = new ArrayList<>();
            ArrayList<String> instituciones_de_salud_defunciones = new ArrayList<>();
            for (FilaEstadisticaVitalNacimientos n : r.getNacimientos()) {
                if(!n.getNombre_institucion().equals(hospital)){
                    hospital = n.getNombre_institucion();
                    instituciones_de_salud_nacimiento.add(hospital);
                }
                //System.out.println(n.getArea_nacimiento()+"  "+n.getSitio_nacimiento());
                if ((n.getArea_nacimiento().equals("EL DOMICILIO") || n.getArea_nacimiento().equals("RURAL DISPERSO")) && n.getSitio_nacimiento().equals("INSTITUCI�N DE SALUD")) {
                    con_area_nacimiento++;
                    area_nacimiento.add(n);
                    System.out.println(n.getArea_nacimiento() + "  " + n.getSitio_nacimiento());
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

                if (!Pattern.matches("CONFIRMADO", n.getEstado_certificado().toUpperCase())) {
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
                        } else if (emb != tem_con) {
                            con_multiplicidad++;
                            multiplicidad.add(n);
                        }
                    }
                } else {
                    con_multiplicidad++;
                    multiplicidad.add(n);
                }
            }
            area_defuncion = new ArrayList<>();
            tipo_defuncion = new ArrayList<>();
            direccion_defuncion = new ArrayList<>();
            mujeres = new ArrayList<>();
            tipo_profesional = new ArrayList<>();
            estado_defuncion =new ArrayList<>();
            hospital="";
            for (EstadisticaVital_defuncion d : r.getDefunciones()) {
                //((d.getArea_de_defuncion().equals("RURAL DISPERSO"))&& (d.getSitio_defuncion().equals("HOSPITAL") || d.getSitio_defuncion().equals("CL�NICA") || d.getSitio_defuncion().equals("HOSPITAL/CL�NICA")))
               if(!d.getNombre_institucion().equals(hospital)){
                    hospital = d.getNombre_institucion();
                    instituciones_de_salud_defunciones.add(hospital);
                }
                if (((d.getArea_de_defuncion().equals("RURAL DISPERSO"))&& (d.getSitio_defuncion().equals("HOSPITAL") || d.getSitio_defuncion().equals("CL�NICA") || d.getSitio_defuncion().equals("HOSPITAL/CL�NICA")))||(d.getArea_de_defuncion().equals("CABECERA MUNICIPAL") && (!d.getSitio_defuncion().contains("HOSPITAL") || !d.getSitio_defuncion().contains("CL�NICA") || !d.getSitio_defuncion().contains("HOSPITAL/CL�NICA")))) {
                    area_defuncion.add(d);
                    System.out.println(""+d.getArea_de_defuncion()+"   "+d.getSitio_defuncion());
                }
                if (d.getTipo_defuncion().equals("FETAL") && (!d.getNombres_fallecido().equals("") || !d.getNumero_documento_fallecido().equals(""))) {
                    tipo_defuncion.add(d);
                }
                if (d.getDireccion().length() == 0) {
                    //System.err.println(n.getFactor_rh()+"  *");
                    con_direccion++;
                    direccion_defuncion.add(d);
                }
                if (d.getSexo_fallecido().equals("FEMENINO") && Pattern.matches("\\d+{2,2}\\(4\\)", d.getEdad_fallecido())) {
                    float edad = Float.parseFloat(d.getEdad_fallecido().split("\\(")[0]);
                    if (edad >= 15 && edad <= 54) {
                        if (!Pattern.matches("SI|NO", d.getEmbarazada_cuandno_fallecio())
                                || !Pattern.matches("SI|NO", d.getEmbarazada_ultimas_12_meses())
                                || !Pattern.matches("SI|NO", d.getEmbarazada_ultimas_6_semanas())) {
                            mujeres.add(d);
                        }
                    }
                }
                if(d.getTipo_profesion().length()>0){
                    
                    if(!d.getExpedido_por().contains(d.getTipo_profesion()) ){
                        tipo_profesional.add(d);
                    }
                }else{
                    tipo_profesional.add(d);
                }
                if (!Pattern.matches("CONFIRMADO", d.getEstado_certificado().toUpperCase())) {
                    //System.err.println(n.getEdad_padre()+"  *");
                    estado_defuncion.add(d);
                    //System.out.println(n.getEstado_certificado());
                }                

            }
            CalidadExcel word = new CalidadExcel(con_area_nacimiento, area_nacimiento, con_sitio_nacimiento, sitio_nacimiento, con_semana_gestacion, semana_gestacion, con_peso, peso, con_peso_tiempo_gestacion, peso_tiempo_gestacion, con_talla, talla, con_peso_tiempo_gestacion_talla, peso_tiempo_gestacion_talla, con_grupo_sanguineo, grupo_sanguineo, con_factor_rh, factor_rh, con_direccion, direccion, con_edad_padre, edad_padre, con_estado, estado, con_multiplicidad, multiplicidad,
                                               area_defuncion,tipo_defuncion,direccion_defuncion,mujeres,tipo_profesional,estado_defuncion,r.getMunicipio());
            word.setMunicipio(r.getMunicipio());
            word.setInstituciones_de_salud_nacimiento(instituciones_de_salud_nacimiento);
            word.setInstituciones_de_salud_defunciones(instituciones_de_salud_defunciones);
            word.setTotal_nacimientos(r.getNacimientos().size());
            word.setTotal_defunciones(r.getDefunciones().size());
            word.writeFile();
        }
    }

}
