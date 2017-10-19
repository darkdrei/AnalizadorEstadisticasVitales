/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author dark
 */
public class Excel implements OperacionesLibro {

    private File archivo;
    private Workbook work_book;
    protected ArrayList<String> municipios = new ArrayList<>();
    protected ArrayList<Integer> anios = new ArrayList<>();
    protected ArrayList<String> columna = new ArrayList<>();
    private int opcion_municipio;
    protected boolean tipo1 = false, tipo2 = false;
    private int start = 0;
    protected int post_municipio = 0;

    public ArrayList<Integer> getAnios() {
        return anios;
    }

    public void setAnios(ArrayList<Integer> anios) {
        this.anios = anios;
    }

    public int getPost_municipio() {
        return post_municipio;
    }

    public void setPost_municipio(int post_municipio) {
        this.post_municipio = post_municipio;
    }

    public boolean isTipo1() {
        return tipo1;
    }

    public void setTipo1(boolean tipo1) {
        this.tipo1 = tipo1;
    }

    public boolean isTipo2() {
        return tipo2;
    }

    public void setTipo2(boolean tipo2) {
        this.tipo2 = tipo2;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int sizeRow(Sheet shee, int row) {
        int c = 0;
        int sixe = shee.getRow(row).length;
        for (int t = 0; t < sixe; t++) {
            if (!shee.getCell(t, row).getContents().equals("")) {
                c++;
            }
        }
        return c;
    }

    public void identificacionEstructuraArchivo(int num_libro) {
        //System.out.println("Vivos");
        if (this.getArchivo().exists()) {
            Sheet shee = this.getWork_book().getSheet(num_libro);
            tipo1 = false;
            tipo2 = false;
            start = 1;
            //System.out.println("este el tamano de las filas "+shee.getRows()+"   ");
            if (shee.getRows() > 0) {
                String info = "";
                if (sizeRow(shee, 0) == 6) {
                    tipo1 = true;
                    start = 1;
                } else if (sizeRow(shee, 0) == 2) {
                    tipo2 = true;
                    start = 2;
                }
                int row = start-1;
                stop:
                for (int t = 0; t < shee.getRow(row).length; t++) {
                    if (shee.getCell(t, row).getContents().equals("MUNICIPIO") || shee.getCell(t, row).getContents().equals("MUNICIPIOS")) {
                        post_municipio = t;
                        break stop;
                    }
                }
            } else {
                tipo1 = false;
                tipo2 = false;
                start = 0;
            }
        }
    }

    public ArrayList<String> getMunicipios() {
        return municipios;
    }

    public void seleccionarMunicipio() {
        ManejadorMunicipio m = new ManejadorMunicipio();
        this.setMunicipios(m.getMunicipios(this.getOpcion_municipio()));
    }

    public void seleccionarMunicipio(int op) {
        ManejadorMunicipio m = new ManejadorMunicipio();
        this.setMunicipios(m.getMunicipios(op));
    }

    public int getOpcion_municipio() {
        return opcion_municipio;
    }

    public void setOpcion_municipio(int opcion_municipio) {
        this.opcion_municipio = opcion_municipio;
    }

    public ArrayList<String> getColumna() {
        return columna;
    }

    public void setColumna(ArrayList<String> columna) {
        this.columna = columna;
    }

    public void setMunicipios(ArrayList<String> municipios) {
        this.municipios = municipios;
    }

    public Excel(File archivo) {
        this.archivo = archivo;
    }

    public Excel() {

    }

    @Override
    public void generarWorkBook() {
        try {
            try {
                work_book = Workbook.getWorkbook(archivo);
            } catch (BiffException ex) {
                Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
            work_book = null;
        }
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public Workbook getWork_book() {
        return work_book;
    }

    public void setWork_book(Workbook work_book) {
        this.work_book = work_book;
    }

    @Override
    public void readNode(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraerNodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFila(Object o) {
    }

    @Override
    public void getColumna(int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraerNodos(int op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public class Municipio {

        private int id;
        private String nombre;

        public Municipio(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public  class ManejadorMunicipio {

        private ArrayList<Municipio> municipios;

        public ManejadorMunicipio() {
            this.municipios = new ArrayList<>();
            this.municipios.add(new Municipio(0,"ACHI"));
            this.municipios.add(new Municipio(0,"ACHÍ"));
            this.municipios.add(new Municipio(1,"MAGANGUE"));
            this.municipios.add(new Municipio(1,"MAGANGUÉ"));
            this.municipios.add(new Municipio(1,"MAGUANGUE"));
            this.municipios.add(new Municipio(2,"MONTECRISTO"));
            this.municipios.add(new Municipio(3,"PINILLOS"));
            this.municipios.add(new Municipio(4,"SAN JACINTO DEL CAUCA"));
            this.municipios.add(new Municipio(5,"TIQUISIO"));
            this.municipios.add(new Municipio(0,"ACH�"));
        }
        
        public String getMunicipio(int id){
            corte:
            for (Municipio municipio : municipios) {
                if(municipio.getId()==id){
                    return municipio.getNombre();
                }            }
            return "";
        }
        
        public ArrayList<String> getMunicipios(int id){
            ArrayList<String> mun_tem = new ArrayList<>();
            for (Municipio mun_tem1 : this.municipios) {
                if(mun_tem1.getId()==id && id != -1)
                    mun_tem.add(mun_tem1.getNombre());
                if(id==-1)
                    mun_tem.add(mun_tem1.getNombre());
            }
            return mun_tem;
        }
    }*/
    @Override
    public void extraerNodosTipo2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraerNodosTipo3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> extraerNodos(ArrayList<String> op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
