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
public class ArchivoControlPrenatalDefuncion extends Excel {

    private ArrayList<ControlPapeleriaDefunciones> defunciones;

    public ArchivoControlPrenatalDefuncion() {
        super();
        defunciones = new ArrayList<>();
    }

    public ArchivoControlPrenatalDefuncion(File archivo) {
        super(archivo);
        defunciones = new ArrayList<>();
    }

    @Override
    public void addFila(Object o) {
        this.defunciones.add((ControlPapeleriaDefunciones) o);
    }

    public ArrayList<ControlPapeleriaDefunciones> extraerFilas(ArrayList l) {
        ArrayList<ControlPapeleriaDefunciones> tem = new ArrayList<>();
        for (ControlPapeleriaDefunciones l1 : getDefunciones()) {
            tem.add(l1);
        }
        return tem;
    }

    @Override
    public void extraerNodos() {
        this.identificacionEstructuraArchivo(1);
        if (this.getArchivo().exists()) {
            Sheet shee = this.getWork_book().getSheet(1);
            String fecha = "";
            for (int i = this.getStart(); i < shee.getRows(); i++) {
                //System.out.println(shee.getCell(6, i).getContents());
                //fecha=shee.getCell(4, i).getContents().length()>0?shee.getCell(4, i).getContents():fecha;
//                try{
                String municipio = shee.getCell(this.post_municipio, i).getContents();
                if (this.municipios.contains(municipio)) {
                    //System.out.println("Defunciones control prenatal  "+shee.getCell(4, i).getContents()+"  "+shee.getCell(1, i).getContents());
                    //System.out.println(i + " " + shee.getCell(6, i).getContents() + " " + shee.getCell(1, i).getContents() + " " + shee.getCell(2, i).getContents() + " " + shee.getCell(3, i).getContents());
                    if (this.isTipo1()) {
                        this.addFila(new ControlPapeleriaDefunciones(shee.getCell(2, i).getContents(),
                                shee.getCell(0, i).getContents(),
                                shee.getCell(1, i).getContents(),
                                shee.getCell(3, i).getContents(),
                                shee.getCell(4, i).getContents(),
                                shee.getCell(5, i).getContents()));

                    } else if (this.isTipo2()) {
                        this.addFila(new ControlPapeleriaDefunciones(i + "",
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
//                }catch(ArrayIndexOutOfBoundsException g){
//                    System.err.println("µµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµ");
//                }

            }
        }
    }

    @Override
    public void getColumna(int columna) {
        this.setColumna(new ArrayList<>());
        for (ControlPapeleriaDefunciones d : this.defunciones) {
            this.getColumna().add(d.getCert_nac_entregado());
        }
    }

    public ArrayList<ControlPapeleriaDefunciones> getDefunciones() {
        return defunciones;
    }

    public void setDefunciones(ArrayList<ControlPapeleriaDefunciones> defunciones) {
        this.defunciones = defunciones;
    }

    @Override
    public ArrayList<Object> extraerNodos(ArrayList<String> op) {
        //To change body of generated methods, choose Tools | Templates.
        ArrayList<Object> tem = new ArrayList<>();
        for (String string : op) {
            nacimiento:
            for (ControlPapeleriaDefunciones nacimiento : this.getDefunciones()) {
                if (string.equals(nacimiento.getCert_nac_entregado())) {
                    String entrega = nacimiento.getFecha_entrega_dane();
                    if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", entrega)) {
                        String res[] = entrega.split("/");
                        res[2] = Pattern.matches("\\d{1,2}", res[2]) ? res[2] : res[2].substring(2, res[2].length());
                        if (!anios.contains(Integer.parseInt(res[2]))) {
                            anios.add(Integer.parseInt(res[2]));
                        }
                        nacimiento.setValor(Integer.parseInt(res[0]) + 30 * Integer.parseInt(res[1]) + 365 * Integer.parseInt(res[2]));
                    } else {
                        nacimiento.setValor(1000000000);
                    }
                    tem.add(nacimiento);
                    break nacimiento;
                }
            }

        }
        return tem;
    }

}
