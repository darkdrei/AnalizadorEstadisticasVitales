/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//reclutamiento.personal1@gmail.com
package logica;

/**
 *
 * @author dark
 */
public class ControlPapeleriaDefunciones extends FilaControlPrenatal{

    public ControlPapeleriaDefunciones(String index, String consecutivo, String cert_nac_entregado, String fecha_entrega_dane, String entidad_quien_recibe, String fecha_entrega_en_sds, String nombre_de_quien_recibe_en_la_entidad, String municipio, String institucion_de_salud, String observaciones) {
        super(index, consecutivo, cert_nac_entregado, fecha_entrega_dane, entidad_quien_recibe, fecha_entrega_en_sds, nombre_de_quien_recibe_en_la_entidad, municipio, institucion_de_salud, observaciones);
    } 

    public ControlPapeleriaDefunciones(String consecutivo, String cert_nac_entregado, String fecha_entrega_dane, String entidad_quien_recibe, String nombre_de_quien_recibe_en_la_entidad, String fecha_entrega_municipio) {
        super(consecutivo, cert_nac_entregado, fecha_entrega_dane, entidad_quien_recibe, nombre_de_quien_recibe_en_la_entidad, fecha_entrega_municipio);
    }
    
    
}
