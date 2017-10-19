/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author E7250
 */
public class AnalizadorCalidad implements OperacionesCalidad{
    private RegistrosMunicipio datos;

    public AnalizadorCalidad() {
        this.datos = new RegistrosMunicipio();
    }

    public RegistrosMunicipio getDatos() {
        return datos;
    }

    public void setDatos(RegistrosMunicipio datos) {
        this.datos = datos;
    }
    
    

    @Override
    public void analizarCalidaDeLaInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void analizarCalidaDeLaInformacion(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
