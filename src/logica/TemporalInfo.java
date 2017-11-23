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
public class TemporalInfo {

        private String municipio = "";
        private ArrayList<Object> vivos = new ArrayList<>();
        private ArrayList<Object> difuntos = new ArrayList<>();
        private ArrayList<Integer> anios_vivos = new ArrayList<>();
        private ArrayList<Integer> anios_difuntos = new ArrayList<>();

        public ArrayList<Integer> getAnios_vivos() {
            return anios_vivos;
        }

        public void setAnios_vivos(ArrayList<Integer> anios_vivos) {
            this.anios_vivos = anios_vivos;
        }

        public ArrayList<Integer> getAnios_difuntos() {
            return anios_difuntos;
        }

        public void setAnios_difuntos(ArrayList<Integer> anios_difuntos) {
            this.anios_difuntos = anios_difuntos;
        }

        public TemporalInfo() {
        }

        public TemporalInfo(String municipio) {
            this.municipio = municipio;
        }

        public String getMunicipio() {
            return municipio;
        }

        public void setMunicipio(String municipio) {
            this.municipio = municipio;
        }

        public ArrayList<Object> getVivos() {
            return vivos;
        }

        public void setVivos(ArrayList<Object> vivos) {
            this.vivos = vivos;
        }

        public ArrayList<Object> getDifuntos() {
            return difuntos;
        }

        public void setDifuntos(ArrayList<Object> difuntos) {
            this.difuntos = difuntos;
        }

    }
