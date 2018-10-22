/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.bddirectoalvarofr.beans;

import java.io.Serializable;

/**
 *
 * @author atomsk
 */
public class Ave implements Serializable{
    String anilla;
    String especie;
    String lugar;
    String fecha;

    public String getAnilla() {
	return anilla;
    }

    public void setAnilla(String anilla) {
	this.anilla = anilla;
    }

    public String getEspecie() {
	return especie;
    }

    public void setEspecie(String especie) {
	this.especie = especie;
    }

    public String getLugar() {
	return lugar;
    }

    public void setLugar(String lugar) {
	this.lugar = lugar;
    }

    public String getFecha() {
	return fecha;
    }

    public void setFecha(String fecha) {
	this.fecha = fecha;
    }
    
    public String allParamsToString(){
	return getAnilla()+"_"+getEspecie()+"_"+getLugar()+"_"+getFecha();
    }
}
