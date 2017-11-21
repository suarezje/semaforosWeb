/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author MartinLu
 */
@ManagedBean(name = "monitorBean", eager = true)
@SessionScoped
public class MonitorSemaforosMBean implements Serializable{
    
    private List<Semaforo> listaLinea1;
    private List<Semaforo> listaLinea2;
    
    private int nL1;
    private int nL2;

    private int nDañadosRojoL1;
    private int nDañadosAmarilloL1;
    private int nDañadosVerdeL1;

    private int nDañadosRojoL2;
    private int nDañadosAmarilloL2;
    private int nDañadosVerdeL2;

    private int nBuenosRojoL1;
    private int nBuenosAmarilloL1;
    private int nBuenosVerdeL1;

    private int nBuenosRojoL2;
    private int nBuenosAmarilloL2;
    private int nBuenosVerdeL2;

    private boolean carga;

    private String idCliente;
    private String ip;
    private String puerto;

    @ManagedProperty("#{registroBean}")
    private RegistroMBean registrobean;
    

    /**
     * Creates a new instance of MonitorSemaforosMBean
     */
    public MonitorSemaforosMBean() {
    }

    public List<Semaforo> getListaLinea1() {
        return listaLinea1;
    }

    public void setListaLinea1(List<Semaforo> listaLinea1) {
        this.listaLinea1 = listaLinea1;
    }

    public List<Semaforo> getListaLinea2() {
        return listaLinea2;
    }

    public void setListaLinea2(List<Semaforo> listaLinea2) {
        this.listaLinea2 = listaLinea2;
    }

    public int getnL1() {
        return nL1;
    }

    public void setnL1(int nL1) {
        this.nL1 = nL1;
    }

    public int getnL2() {
        return nL2;
    }

    public void setnL2(int nL2) {
        this.nL2 = nL2;
    }

    public int getnDañadosRojoL1() {
        return nDañadosRojoL1;
    }

    public void setnDañadosRojoL1(int nDañadosRojoL1) {
        this.nDañadosRojoL1 = nDañadosRojoL1;
    }

    public int getnDañadosAmarilloL1() {
        return nDañadosAmarilloL1;
    }

    public void setnDañadosAmarilloL1(int nDañadosAmarilloL1) {
        this.nDañadosAmarilloL1 = nDañadosAmarilloL1;
    }

    public int getnDañadosVerdeL1() {
        return nDañadosVerdeL1;
    }

    public void setnDañadosVerdeL1(int nDañadosVerdeL1) {
        this.nDañadosVerdeL1 = nDañadosVerdeL1;
    }

    public int getnDañadosRojoL2() {
        return nDañadosRojoL2;
    }

    public void setnDañadosRojoL2(int nDañadosRojoL2) {
        this.nDañadosRojoL2 = nDañadosRojoL2;
    }

    public int getnDañadosAmarilloL2() {
        return nDañadosAmarilloL2;
    }

    public void setnDañadosAmarilloL2(int nDañadosAmarilloL2) {
        this.nDañadosAmarilloL2 = nDañadosAmarilloL2;
    }

    public int getnDañadosVerdeL2() {
        return nDañadosVerdeL2;
    }

    public void setnDañadosVerdeL2(int nDañadosVerdeL2) {
        this.nDañadosVerdeL2 = nDañadosVerdeL2;
    }

    public int getnBuenosRojoL1() {
        return nBuenosRojoL1;
    }

    public void setnBuenosRojoL1(int nBuenosRojoL1) {
        this.nBuenosRojoL1 = nBuenosRojoL1;
    }

    public int getnBuenosAmarilloL1() {
        return nBuenosAmarilloL1;
    }

    public void setnBuenosAmarilloL1(int nBuenosAmarilloL1) {
        this.nBuenosAmarilloL1 = nBuenosAmarilloL1;
    }

    public int getnBuenosVerdeL1() {
        return nBuenosVerdeL1;
    }

    public void setnBuenosVerdeL1(int nBuenosVerdeL1) {
        this.nBuenosVerdeL1 = nBuenosVerdeL1;
    }

    public int getnBuenosRojoL2() {
        return nBuenosRojoL2;
    }

    public void setnBuenosRojoL2(int nBuenosRojoL2) {
        this.nBuenosRojoL2 = nBuenosRojoL2;
    }

    public int getnBuenosAmarilloL2() {
        return nBuenosAmarilloL2;
    }

    public void setnBuenosAmarilloL2(int nBuenosAmarilloL2) {
        this.nBuenosAmarilloL2 = nBuenosAmarilloL2;
    }

    public int getnBuenosVerdeL2() {
        return nBuenosVerdeL2;
    }

    public void setnBuenosVerdeL2(int nBuenosVerdeL2) {
        this.nBuenosVerdeL2 = nBuenosVerdeL2;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
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

    public RegistroMBean getRegistrobean() {
        return registrobean;
    }

    public void setRegistrobean(RegistroMBean registrobean) {
        this.registrobean = registrobean;
    }

    
}
