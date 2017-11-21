/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author JorgeDominguez
 */
public class Semaforo implements Serializable{
    
    private boolean rojo = false;
    private boolean amarillo = false;
    private boolean verde = false;
    private boolean intermintente = false;
    private String id = "ids";
    

    public Semaforo(String id, boolean rojo, boolean amarillo, boolean verde, boolean intermitente) {
        this.id = id;
        this.rojo = rojo;
        this.amarillo = amarillo;
        this.verde = verde;
        this.intermintente = intermitente;
        
    }

    public Semaforo() {
        }
    
    
    
    public boolean isRojo() {
        return rojo;
    }

    public void setRojo(boolean rojo) {
        this.rojo = rojo;
    }

    public boolean isAmarillo() {
        return amarillo;
    }

    public void setAmarillo(boolean amarillo) {
        this.amarillo = amarillo;
    }

    public boolean isVerde() {
        return verde;
    }

    public void setVerde(boolean verde) {
        this.verde = verde;
    }

    public boolean isIntermintente() {
        return intermintente;
    }

    public void setIntermintente(boolean intermintente) {
        this.intermintente = intermintente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Semaforo{" + "rojo=" + rojo + ", amarillo=" + amarillo + ", verde=" + verde + ", intermintente=" + intermintente + ", id=" + id + '}';
    }
    
    
}
