/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;
import jxl.Sheet;

/**
 *
 * @author dark
 */
public class ArchivoControlPrenatalVivo extends Excel {

    private ArrayList<ControlPapeleriaNacimientos> nacimientos;

    public ArchivoControlPrenatalVivo(File archivo) {
        super(archivo);
        nacimientos = new ArrayList<>();
    }

    public ArrayList<ControlPapeleriaNacimientos> extraerFilas(ArrayList l) {
        ArrayList<ControlPapeleriaNacimientos> tem = new ArrayList<>();
        for (ControlPapeleriaNacimientos l1 : getNacimientos()) {
            tem.add(l1);
        }
        return tem;
    }

    @Override
    public void addFila(Object o) {
        this.nacimientos.add((ControlPapeleriaNacimientos) o);
    }

    @Override
    public void extraerNodos() {
        this.identificacionEstructuraArchivo(0);
        if (this.getArchivo().exists()) {
            Sheet shee = this.getWork_book().getSheet(0);
            String fecha = "";
            for (int i = this.getStart(); i < shee.getRows(); i++) {
                //fecha=shee.getCell(4, i).getContents().length()>0?shee.getCell(4, i).getContents():fecha;
                String municipio = shee.getCell(this.post_municipio, i).getContents();
                //System.out.println(municipio);
                if (this.municipios.contains(municipio)) {
                    //System.out.println("Defunciones control prenatal  "+shee.getCell(4, i).getContents()+"  "+shee.getCell(1, i).getContents());
                    //System.out.println(i + " " + shee.getCell(6, i).getContents() + " " + shee.getCell(1, i).getContents() + " " + shee.getCell(2, i).getContents() + " " + shee.getCell(3, i).getContents());
                    //System.out.println(shee.getCell(6, i).getContents()+"   "+shee.getCell(1, i).getContents()+"   "+this.municipios);
                    if (this.isTipo1()) {
                        this.addFila(new ControlPapeleriaNacimientos(shee.getCell(2, i).getContents(),
                                shee.getCell(0, i).getContents(),
                                shee.getCell(1, i).getContents(),
                                shee.getCell(3, i).getContents(),
                                shee.getCell(4, i).getContents(),
                                shee.getCell(5, i).getContents()));

                    } else if (this.isTipo2()) {
//                        System.out.println(shee.getCell(1, i).getContents()+" "+
//                                        shee.getCell(2, i).getContents()+" "+
//                                        shee.getCell(3, i).getContents()+" "+
//                                        shee.getCell(6, i).getContents()+" "+
//                                shee.getCell(4, i).getContents()+" "+
//                                        shee.getCell(5, i).getContents());
                        this.addFila(new ControlPapeleriaNacimientos(i + "",
                                shee.getCell(0, i).getContents(),
                                shee.getCell(1, i).getContents(),
                                shee.getCell(2, i).getContents(),
                                shee.getCell(3, i).getContents(),
                                shee.getCell(4, i).getContents(),
                                shee.getCell(5, i).getContents(),
                                shee.getCell(6, i).getContents(),
                                shee.getCell(7, i).getContents(),
                                shee.getCell(8, i).getContents()));
                    }
                }
            }
        }
    }

    @Override
    public void extraerNodosTipo2() {
        if (this.getArchivo().exists()) {
            Sheet shee = this.getWork_book().getSheet(0);
            //System.out.println("Vivos");
            for (int i = 1; i < shee.getRows(); i++) {
                if (this.municipios.contains(shee.getCell(6, i).getContents())) {
                    //System.out.println(i+" "+shee.getCell(6, i).getContents()+" "+shee.getCell(1, i).getContents()+" "+shee.getCell(2, i).getContents()+" "+shee.getCell(3, i).getContents());
                    this.addFila(
                            new ControlPapeleriaNacimientos(i + "",
                                    shee.getCell(0, i).getContents(),
                                    shee.getCell(1, i).getContents(),
                                    shee.getCell(2, i).getContents(),
                                    shee.getCell(3, i).getContents(),
                                    shee.getCell(4, i).getContents(),
                                    shee.getCell(5, i).getContents(),
                                    shee.getCell(6, i).getContents(),
                                    shee.getCell(7, i).getContents(),
                                    shee.getCell(8, i).getContents()));
                }
            }
        }
    }

    @Override
    public void extraerNodosTipo3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArchivoControlPrenatalVivo() {
        super();
        nacimientos = new ArrayList<>();
    }

    @Override
    public void extraerNodos(int op) {
        if (op == 1) {
            this.extraerNodos();
        }
    }

    @Override
    public ArrayList<Object> extraerNodos(ArrayList<String> op) {
        //To change body of generated methods, choose Tools | Templates.
        ArrayList<Object> tem = new ArrayList<>();
        for (String string : op) {
            nacimiento:
            for (ControlPapeleriaNacimientos nacimiento : this.getNacimientos()) {
                if (string.equals(nacimiento.getCert_nac_entregado())) {
                    String entrega = nacimiento.getFecha_entrega_dane();
                    if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)){
                        String res[] = entrega.split("/");
                        res[2] = Pattern.matches("\\d{1,2}",res[2])?res[2]:res[2].substring(2, res[2].length());
                        if(!anios.contains(Integer.parseInt(res[2])))
                            anios.add(Integer.parseInt(res[2]));
                        nacimiento.setValor(Integer.parseInt(res[0])+30*Integer.parseInt(res[1])+365*Integer.parseInt(res[2]));
                    }else{
                        nacimiento.setValor(1000000000);
                    }
                     tem.add(nacimiento);
                     break nacimiento;
                }
            }
        }
        return tem;
    }

    @Override
    public void getColumna(int columna) {
        this.setColumna(new ArrayList<>());
        for (ControlPapeleriaNacimientos d : this.nacimientos) {
            this.getColumna().add(d.getCert_nac_entregado());
        }
    }

    public ArrayList<ControlPapeleriaNacimientos> getNacimientos() {
        return nacimientos;
    }

    public void setNacimientos(ArrayList<ControlPapeleriaNacimientos> nacimientos) {
        this.nacimientos = nacimientos;
    }

}
