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
public class CalidadExcel extends Reporte{
    
    public CalidadExcel(int con_area_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> area_nacimiento, int con_sitio_nacimiento, ArrayList<FilaEstadisticaVitalNacimientos> sitio_nacimiento, int con_semana_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> semana_gestacion, int con_peso, ArrayList<FilaEstadisticaVitalNacimientos> peso, int con_peso_tiempo_gestacion, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion, int con_talla, ArrayList<FilaEstadisticaVitalNacimientos> talla, int con_peso_tiempo_gestacion_talla, ArrayList<FilaEstadisticaVitalNacimientos> peso_tiempo_gestacion_talla, int con_grupo_sanguineo, ArrayList<FilaEstadisticaVitalNacimientos> grupo_sanguineo, int con_factor_rh, ArrayList<FilaEstadisticaVitalNacimientos> factor_rh, int con_direccion, ArrayList<FilaEstadisticaVitalNacimientos> direccion, int con_edad_padre, ArrayList<FilaEstadisticaVitalNacimientos> edad_padre, int con_estado, ArrayList<FilaEstadisticaVitalNacimientos> estado, int con_multiplicidad, ArrayList<FilaEstadisticaVitalNacimientos> multiplicidad) {
        super(con_area_nacimiento, area_nacimiento, con_sitio_nacimiento, sitio_nacimiento, con_semana_gestacion, semana_gestacion, con_peso, peso, con_peso_tiempo_gestacion, peso_tiempo_gestacion, con_talla, talla, con_peso_tiempo_gestacion_talla, peso_tiempo_gestacion_talla, con_grupo_sanguineo, grupo_sanguineo, con_factor_rh, factor_rh, con_direccion, direccion, con_edad_padre, edad_padre, con_estado, estado, con_multiplicidad, multiplicidad);
    }
    
    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
