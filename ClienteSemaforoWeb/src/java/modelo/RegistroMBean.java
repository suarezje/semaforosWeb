/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author JorgeDominguez
 */
@ManagedBean (name = "registroBean")
@SessionScoped
public class RegistroMBean implements Serializable{

    /**
     * Creates a new instance of RegistroMBean
     */
    private String idCliente;
    private String ip;
    private String puerto;
    private String semaforosL1;
    private String semaforosL2;
    
    
    public RegistroMBean() {
    }
 
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getSemaforosL1() {
        return semaforosL1;
    }

    public void setSemaforosL1(String semaforosL1) {
        this.semaforosL1 = semaforosL1;
    }

    public String getSemaforosL2() {
        return semaforosL2;
    }

    public void setSemaforosL2(String semaforosL2) {
        this.semaforosL2 = semaforosL2;
    }

    @Override
    public String toString() {
        return "RegistroMBean{" + "idCliente=" + idCliente + ", ip=" + ip + ", puerto=" + puerto + ", semaforosL1=" + semaforosL1 + ", semaforosL2=" + semaforosL2 + '}';
    }
    

 
  


    
    
}
