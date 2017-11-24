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
            System.out.println(" ---------------------------------------");
            System.out.println(t.getMunicipio());
            
            System.out.println(t.getAnios_vivos());
            System.out.println(t.getAnios_difuntos());
            
        }
    }
    
    public class TemporalMes{
        private int mes;
        private ArrayList<Object> datos;
        
        public TemporalMes(int m){
            this.mes= m;
            this.datos = new ArrayList<>();
        }
       
        public void addDato(Object d){
            this.datos.add(d);
        }
        
        public int size(){
            return this.datos.size();
        }
    }
    
    public class TemporalesMeses{
        private ArrayList<TemporalMes> meses;
        
        public TemporalesMeses(){
            this.meses = new ArrayList<>();
        }
        
        public void addDato(int mes,Object o){
            stop:
            for(TemporalMes m:this.meses){
                if(mes == m.){
                }
            }
        }
    }
}
