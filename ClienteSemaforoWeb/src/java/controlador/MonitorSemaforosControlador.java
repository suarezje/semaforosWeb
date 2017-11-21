/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Persistencia.GestionarArchivo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelo.MonitorSemaforosMBean;
import modelo.PeticionEncender;
import modelo.RegistroMBean;
import modelo.Semaforo;
import utils.Constantes;
import utils.FacesUtils;

/**
 *
 * @author JorgeDominguez
 */
@ManagedBean(name = "monitorControlador", eager = true)
@SessionScoped
public class MonitorSemaforosControlador implements Serializable {

    @ManagedProperty("#{registroBean}")
    private RegistroMBean registroBean;

    @ManagedProperty("#{monitorBean}")
    private MonitorSemaforosMBean monitorBean;

 
    public MonitorSemaforosControlador() {

    
    }

    @PostConstruct
    public void init() {

        if (FacesUtils.getFromSession("CARGA") == null) {
            monitorBean.setCarga(true);
        } else {
            monitorBean.setCarga((boolean) FacesUtils.getFromSession("CARGA"));
        }

        if (monitorBean.isCarga()) {

            monitorBean.setnL1(Integer.parseInt(registroBean.getSemaforosL1()));
            monitorBean.setnL2(Integer.parseInt(registroBean.getSemaforosL2()));
            monitorBean.setIdCliente(registroBean.getIdCliente());
            monitorBean.setIp(registroBean.getIp());
            monitorBean.setPuerto(registroBean.getPuerto());

            monitorBean.setListaLinea1(new ArrayList<Semaforo>());
            monitorBean.setListaLinea2(new ArrayList<Semaforo>());

            for (int i = 0; i < monitorBean.getnL1(); i++) {
                monitorBean.getListaLinea1().add(new Semaforo("L1-" + i, false, false, false, false));
                System.out.println("L1-" + i);
            }

            for (int i = 0; i < monitorBean.getnL2(); i++) {
                monitorBean.getListaLinea2().add(new Semaforo("L2-" + i, false, false, false, false));
                System.out.println("L2-" + i);
            }
            monitorBean.setCarga(false);
            FacesUtils.addToSession("CARGA", monitorBean.isCarga());

        }

    }

    public String actualizarMonitor() {

        String linea = GestionarArchivo.leerArchivo();
        String orden = linea.trim().replace("N", "").replace(" ", "").replace("{", "").replace("}", "");

        if (linea.startsWith("N")) {

            String[] atr = orden.split(",");
            PeticionEncender pe = new PeticionEncender();

            for (String v : atr) {
                if (v.startsWith("esRojoL1")) {
                    pe.setEsRojoL1(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esAmarilloL1")) {
                    pe.setEsAmarilloL1(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esVerdeL1")) {
                    pe.setEsVerdeL1(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esRojoL2")) {
                    pe.setEsRojoL2(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esAmarilloL2")) {
                    pe.setEsAmarilloL2(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esVerdeL2")) {
                    pe.setEsVerdeL2(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esIntermitenteL1")) {
                    pe.setEsIntermitenteL1(Boolean.parseBoolean(v.split(":")[1]));
                } else if (v.startsWith("esIntermitenteL2")) {
                    pe.setEsIntermitenteL2(Boolean.parseBoolean(v.split(":")[1]));
                }
            }

            for (int i = 0; i < monitorBean.getListaLinea1().size(); i++) {
                monitorBean.getListaLinea1().get(i).setRojo(pe.getEsRojoL1());
                monitorBean.getListaLinea1().get(i).setAmarillo(pe.getEsAmarilloL1());
                monitorBean.getListaLinea1().get(i).setVerde(pe.getEsVerdeL1());
                monitorBean.getListaLinea1().get(i).setIntermintente(pe.getEsIntermitenteL1());
            }

            for (int i = 0; i < monitorBean.getListaLinea2().size(); i++) {
                monitorBean.getListaLinea2().get(i).setRojo(pe.getEsRojoL2());
                monitorBean.getListaLinea2().get(i).setAmarillo(pe.getEsAmarilloL2());
                monitorBean.getListaLinea2().get(i).setVerde(pe.getEsVerdeL2());
                monitorBean.getListaLinea2().get(i).setIntermintente(pe.getEsIntermitenteL2());
            }

            monitorBean.setnDañadosAmarilloL1(0);
            monitorBean.setnDañadosVerdeL1(0);
            monitorBean.setnDañadosRojoL1(0);
            monitorBean.setnDañadosAmarilloL2(0);
            monitorBean.setnDañadosVerdeL2(0);
            monitorBean.setnDañadosRojoL2(0);

            GestionarArchivo.escribirArchivo("L", pe);
        }

        return Constantes.IR_A_MONITOR;
    }

    public void marcarDaño(ActionEvent event) {
        String buttonId = event.getComponent().getAttributes().get("value").toString();

        Integer idSemaforo = Integer.parseInt(buttonId.split("-")[1]);
        String luzSemaforo = buttonId.split("-")[2];

        System.out.println(" llego ids: " + idSemaforo + " ls: " + luzSemaforo);

        if (buttonId.startsWith(Constantes.LINEA1)) {

            switch (luzSemaforo) {
                case Constantes.ROJO:
                    monitorBean.getListaLinea1().get(idSemaforo).setRojo(false);
                    monitorBean.setnDañadosRojoL1(monitorBean.getnDañadosRojoL1() + 1);
                    break;
                case Constantes.AMARILLO:
                    monitorBean.getListaLinea1().get(idSemaforo).setAmarillo(false);
                    monitorBean.setnDañadosAmarilloL1(monitorBean.getnDañadosAmarilloL1() + 1);
                    break;
                case Constantes.VERDE:
                    monitorBean.getListaLinea1().get(idSemaforo).setVerde(false);
                    monitorBean.setnDañadosVerdeL1(monitorBean.getnDañadosVerdeL1() + 1);
                    break;
            }

        } else {
            switch (luzSemaforo) {
                case Constantes.ROJO:
                    monitorBean.getListaLinea2().get(idSemaforo).setRojo(false);
                    monitorBean.setnDañadosRojoL2(monitorBean.getnDañadosRojoL2() + 1);
                    break;
                case Constantes.AMARILLO:
                    monitorBean.getListaLinea2().get(idSemaforo).setAmarillo(false);
                    monitorBean.setnDañadosAmarilloL2(monitorBean.getnDañadosAmarilloL2() + 1);
                    break;
                case Constantes.VERDE:
                    monitorBean.getListaLinea2().get(idSemaforo).setVerde(false);
                    monitorBean.setnDañadosVerdeL2(monitorBean.getnDañadosVerdeL2() + 1);
                    break;
            }
        }

        reportarLuces();

    }

    public void reportarLuces() {
        monitorBean.setnBuenosRojoL1(monitorBean.getnL1() - monitorBean.getnDañadosRojoL1());
        monitorBean.setnBuenosAmarilloL1(monitorBean.getnL1() - monitorBean.getnDañadosAmarilloL1());
        monitorBean.setnBuenosVerdeL1(monitorBean.getnL1() - monitorBean.getnDañadosVerdeL1());

        monitorBean.setnBuenosRojoL2(monitorBean.getnL2() - monitorBean.getnDañadosRojoL2());
        monitorBean.setnBuenosAmarilloL2(monitorBean.getnL2() - monitorBean.getnDañadosAmarilloL2());
        monitorBean.setnBuenosVerdeL2(monitorBean.getnL2() - monitorBean.getnDañadosVerdeL2());

        invocarServicioRest();

    }

    public void invocarServicioRest() {

        String urlRest = "";
        String strJsonSalida = "";
        String json = "";

        try {

            urlRest = "http://" + registroBean.getIp() + ":" + registroBean.getPuerto() + "/ServidorSemaforo1/rest/servidorSemaforo/buenos";
            json = "{\n"
                    + "	\"idUsuario\":\"" + monitorBean.getIdCliente() + "\",\n"
                    + "     \"cantVerdeL1\":" + ((monitorBean.getnBuenosVerdeL1() < 0) ? 0 : monitorBean.getnBuenosVerdeL1()) + ",\n"
                    + "     \"cantAmarilloL1\":" + ((monitorBean.getnBuenosAmarilloL1() < 0) ? 0 : monitorBean.getnBuenosAmarilloL1()) + ",\n"
                    + "	\"cantRojoL1\":" + ((monitorBean.getnBuenosRojoL1() < 0) ? 0 : monitorBean.getnBuenosRojoL1()) + ",\n"
                    + "	\"cantVerdeL2\":" + ((monitorBean.getnBuenosVerdeL2() < 0) ? 0 : monitorBean.getnBuenosVerdeL2()) + ",\n"
                    + "     \"cantAmarilloL2\":" + ((monitorBean.getnBuenosAmarilloL2() < 0) ? 0 : monitorBean.getnBuenosAmarilloL2()) + ",\n"
                    + "	\"cantRojoL2\":" + ((monitorBean.getnBuenosRojoL2() < 0) ? 0 : monitorBean.getnBuenosRojoL2()) + "\n"
                    + "}";

            System.out.println("json: " + json);

            URL url = new URL(urlRest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(json);
            out.close();

            int iResponseCode = conn.getResponseCode();

            if (iResponseCode != 200) {
                System.out.println("Error en respuesta");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;

            while ((output = br.readLine()) != null) {
                strJsonSalida = strJsonSalida + output;
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("ERROR AL INVOCAR REST EN " + monitorBean.getIp() + " " + monitorBean.getPuerto());
        }
    }

    public RegistroMBean getRegistroBean() {
        return registroBean;
    }

    public void setRegistroBean(RegistroMBean registroBean) {
        this.registroBean = registroBean;
    }

    public MonitorSemaforosMBean getMonitorBean() {
        return monitorBean;
    }

    public void setMonitorBean(MonitorSemaforosMBean monitorBean) {
        this.monitorBean = monitorBean;
    }

    public String getIpLocal() {

        String ipLocal = "";

        try {
            ipLocal = InetAddress.getLocalHost().getHostAddress();

        } catch (UnknownHostException ex) {
            System.out.println("ERROR OBTENIENDO IP LOCAL");
        }
        return ipLocal;
    }
}
