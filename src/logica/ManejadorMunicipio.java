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
public class ManejadorMunicipio {

    private ArrayList<Municipio> municipios;

    public ManejadorMunicipio() {
        this.municipios = new ArrayList<>();
        this.municipios.add(new logica.Municipio(0, "ACHI"));
        this.municipios.add(new Municipio(0, "ACH�"));
        this.municipios.add(new Municipio(0, "ACHÍ"));
        this.municipios.add(new Municipio(1, "MAGANGUE"));
        this.municipios.add(new Municipio(1, "MAGANGUÉ"));
        this.municipios.add(new Municipio(1, "MAGUANGUE"));
        this.municipios.add(new Municipio(2, "MONTECRISTO"));
        this.municipios.add(new Municipio(3, "PINILLOS"));
        this.municipios.add(new Municipio(4, "SAN JACINTO DEL CAUCA"));
        this.municipios.add(new Municipio(5, "TIQUISIO"));
        this.municipios.add(new Municipio(6, "SAN JUAN NEPOMUCENO"));
        this.municipios.add(new Municipio(7, "SAN JACINTO"));
        this.municipios.add(new Municipio(8, "MAR�A LA BAJA"));
        this.municipios.add(new Municipio(8, "MARIALABAJA"));
        this.municipios.add(new Municipio(8, "MARIA LA BAJA"));
        this.municipios.add(new Municipio(9, "ARROYO HONDO"));
        this.municipios.add(new Municipio(9, "ARROYOHONDO"));
        this.municipios.add(new Municipio(10, "ARJONA"));
        this.municipios.add(new Municipio(11, "CALAMAR"));
        this.municipios.add(new Municipio(12, "TURBACO"));
        this.municipios.add(new Municipio(13, "TURBANA"));
        this.municipios.add(new Municipio(14, "MAHATES"));
        this.municipios.add(new Municipio(15, "ALTOS DEL ROSARIO"));
        this.municipios.add(new Municipio(16, "SAN MARTIN DE LOBA"));
        this.municipios.add(new Municipio(17, "RIO VIEJO"));
        this.municipios.add(new Municipio(18, "BARRANCO DE LOBA"));
        this.municipios.add(new Municipio(19, "REGIDOR"));
        this.municipios.add(new Municipio(20, "EL PEÑON"));
        this.municipios.add(new Municipio(21, "NOROSI"));
        
    }

    public String getMunicipio(int id) {
        corte:
        for (Municipio municipio : municipios) {
            if (municipio.getId() == id) {
                return municipio.getNombre();
            }
        }
        return "";
    }

    public ArrayList<String> getMunicipios(int id) {
        ArrayList<String> mun_tem = new ArrayList<>();
        for (Municipio mun_tem1 : this.municipios) {
            if (mun_tem1.getId() == id && id != -1) {
                mun_tem.add(mun_tem1.getNombre());
            }
            if (id == -1) {
                mun_tem.add(mun_tem1.getNombre());
            }
        }
        return mun_tem;
    }
}
