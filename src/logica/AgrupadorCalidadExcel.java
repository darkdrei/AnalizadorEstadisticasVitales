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
public class AgrupadorCalidadExcel implements ExportFile{
    private ArrayList<CalidadExcel> filas_excel;

    public AgrupadorCalidadExcel() {
        this.filas_excel = new ArrayList<>();
    }

    public ArrayList<CalidadExcel> getFilas_excel() {
        return filas_excel;
    }

    public void setFilas_excel(ArrayList<CalidadExcel> filas_excel) {
        this.filas_excel = filas_excel;
    } 

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
