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

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public ArrayList<Object> getDatos() {
            return datos;
        }

        public void setDatos(ArrayList<Object> datos) {
            this.datos = datos;
        }
        
        
    }
    
    public class TemporalesMeses{
        private ArrayList<TemporalMes> meses;
        
        public TemporalesMeses(){
            this.meses = new ArrayList<>();
        }
        
        public void addDato(int mes,Object o){
            stop:
            for(int i=0;i <this.meses.size();i++){
                if(mes == this.meses.get(i).getMes()){
                    this.meses.get(i).addDato(o);
                    break stop;
                }
            }
        }

        public ArrayList<TemporalMes> getMeses() {
            return meses;
        }

        public void setMeses(ArrayList<TemporalMes> meses) {
            this.meses = meses;
        }
    }
}
