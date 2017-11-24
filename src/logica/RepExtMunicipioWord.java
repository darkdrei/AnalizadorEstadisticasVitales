/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author dark
 */
public class RepExtMunicipioWord extends ReporteExistencia{
    
    public RepExtMunicipioWord(){
        super();
    }
    
    public RepExtMunicipioWord(ContenedorInfoMunicipio d){
        super(d);
    }
    
     @Override
    public void writeFile() {
        for(TemporalInfo t: this.getData().getData()){
        
        }
    }
    
}
