/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JorgeDominguez
 */

@XmlRootElement(name = "PeticionEncender")
public class PeticionEncender implements Serializable{
    
    private Boolean esRojoL1;
    private Boolean esAmarilloL1;
    private Boolean esVerdeL1;
    private Boolean esIntermitenteL1;
    
    private Boolean esRojoL2;
    private Boolean esAmarilloL2;
    private Boolean esVerdeL2;
    private Boolean esIntermitenteL2;

    public PeticionEncender(Boolean esRojoL1, Boolean esAmarilloL1, Boolean esVerdeL1, Boolean esIntermitenteL1, Boolean esRojoL2, Boolean esAmarilloL2, Boolean esVerdeL2, Boolean esIntermitenteL2) {
        this.esRojoL1 = esRojoL1;
        this.esAmarilloL1 = esAmarilloL1;
        this.esVerdeL1 = esVerdeL1;
        this.esIntermitenteL1 = esIntermitenteL1;
        this.esRojoL2 = esRojoL2;
        this.esAmarilloL2 = esAmarilloL2;
        this.esVerdeL2 = esVerdeL2;
        this.esIntermitenteL2 = esIntermitenteL2;
    }

    public PeticionEncender() {
        
    }

    public Boolean getEsRojoL1() {
        return esRojoL1;
    }

    @XmlElement
    public void setEsRojoL1(Boolean esRojoL1) {
        this.esRojoL1 = esRojoL1;
    }

    public Boolean getEsAmarilloL1() {
        return esAmarilloL1;
    }

    @XmlElement
    public void setEsAmarilloL1(Boolean esAmarilloL1) {
        this.esAmarilloL1 = esAmarilloL1;
    }

    public Boolean getEsVerdeL1() {
        return esVerdeL1;
    }

    @XmlElement
    public void setEsVerdeL1(Boolean esVerdeL1) {
        this.esVerdeL1 = esVerdeL1;
    }

    public Boolean getEsIntermitenteL1() {
        return esIntermitenteL1;
    }

    @XmlElement
    public void setEsIntermitenteL1(Boolean esIntermitenteL1) {
        this.esIntermitenteL1 = esIntermitenteL1;
    }

    public Boolean getEsRojoL2() {
        return esRojoL2;
    }

    @XmlElement
    public void setEsRojoL2(Boolean esRojoL2) {
        this.esRojoL2 = esRojoL2;
    }

    public Boolean getEsAmarilloL2() {
        return esAmarilloL2;
    }

    @XmlElement
    public void setEsAmarilloL2(Boolean esAmarilloL2) {
        this.esAmarilloL2 = esAmarilloL2;
    }

    public Boolean getEsVerdeL2() {
        return esVerdeL2;
    }

    @XmlElement
    public void setEsVerdeL2(Boolean esVerdeL2) {
        this.esVerdeL2 = esVerdeL2;
    }

    public Boolean getEsIntermitenteL2() {
        return esIntermitenteL2;
    }

    @XmlElement
    public void setEsIntermitenteL2(Boolean esIntermitenteL2) {
        this.esIntermitenteL2 = esIntermitenteL2;
    }

    @Override
    public String toString() {
        return "{" + "esRojoL1:" + esRojoL1 + ", esAmarilloL1:" + esAmarilloL1 + ", esVerdeL1:" + esVerdeL1 + ", esIntermitenteL1:" + esIntermitenteL1 + ", esRojoL2:" + esRojoL2 + ", esAmarilloL2:" + esAmarilloL2 + ", esVerdeL2:" + esVerdeL2 + ", esIntermitenteL2:" + esIntermitenteL2 + '}';
    }
        
}
