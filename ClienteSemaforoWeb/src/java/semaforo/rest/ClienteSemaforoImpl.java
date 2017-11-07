/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo.rest;

import dtos.PeticionEncender;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.core.Response;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 *
 * @author JorgeDominguez
 */
public class ClienteSemaforoImpl implements IClienteSemaforo {

    @Override
    public Response operacionEncenderLuces(InputStream peticionEncender) {
        System.out.print("Entro al WS");

        StringBuilder strBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(peticionEncender));
            String line = null;
            while ((line = in.readLine()) != null) {
                strBuilder.append(line);
            }
        } catch (Exception e) {

            return Response.status(500).build();
        }

        String strDatosEntrada = strBuilder.toString();

        JSONObject jsonObjectOri = null;
        PeticionEncender pe = new PeticionEncender();

        try {
            jsonObjectOri = new JSONObject(strDatosEntrada);
            pe.setEsRojoL1(jsonObjectOri.getBoolean("esRojoL1"));
            pe.setEsAmarilloL1(jsonObjectOri.getBoolean("esAmarilloL1"));
            pe.setEsVerdeL1(jsonObjectOri.getBoolean("esVerdeL1"));
            pe.setEsIntermitenteL1(jsonObjectOri.getBoolean("esIntermitenteL1"));
            pe.setEsRojoL2(jsonObjectOri.getBoolean("esRojoL2"));
            pe.setEsAmarilloL2(jsonObjectOri.getBoolean("esAmarilloL2"));
            pe.setEsVerdeL2(jsonObjectOri.getBoolean("esVerdeL2"));
            pe.setEsIntermitenteL2(jsonObjectOri.getBoolean("esIntermitenteL2"));

        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(pe.toString());
        return Response.status(200).build();

    }

}
