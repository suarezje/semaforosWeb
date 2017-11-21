/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.RegistroMBean;
import utils.Constantes;

/**
 *
 * @author Alejo
 */
@ManagedBean(name = "registroControlador")
@SessionScoped
public class RegistroControlador {

    @ManagedProperty(value = "#{registroBean}")
    private RegistroMBean registroMBean;

    public RegistroMBean getRegistroMBean() {
        return registroMBean;
    }

    public void setRegistroMBean(RegistroMBean registroMBean) {
        this.registroMBean = registroMBean;
    }

    public String registrarLineas() {
        System.out.println(registroMBean.toString());
        return invocarServicioRest();
    }

    public String invocarServicioRest() {

        String urlRest = "";
        String strJsonSalida = "";
        String json = "";
        int iResponseCode = 0;

        try {
            urlRest = "http://" + registroMBean.getIp() + ":" + registroMBean.getPuerto() + "/ServidorSemaforo1/rest/servidorSemaforo/crearCliente";
            json = "{\n"
                    + "\n"
                    + "	\"cantidadL1\":" + registroMBean.getSemaforosL1() + ",\n"
                    + "     \"cantidadL2\":" + registroMBean.getSemaforosL2() + ",\n"
                    + "     \"idUsuario\":\"" + registroMBean.getIdCliente() + ",\"\n"
                    + "     \"ip\":\"" + getIpLocal() + "\"\n"
                    + "     \"puerto\":\"" + Constantes.PUERTO_LOCAL + "\"\n"
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

            iResponseCode = conn.getResponseCode();

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
            System.out.println("ERROR AL INVOCAR REST EN " + registroMBean.getIp() + " " + registroMBean.getPuerto());
        }
        return ((iResponseCode == 200) ? Constantes.IR_A_MONITOR : Constantes.IR_A_REGISTRO);
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
