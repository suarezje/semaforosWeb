/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.PeticionEncender;
import utils.Constantes;

/**
 *
 * @author Alejo
 */
public class GestionarArchivo {

    public static void escribirArchivo(String marca, PeticionEncender peticion) {
        System.out.println("ESCRIBIENDO ARCHIVO");
        try {
            File archivo = new File(Constantes.ARCHIVO_PERSISTENCIA);
            FileWriter escribir = new FileWriter(archivo, false);
            escribir.write(marca + peticion.toString());
            escribir.write(System.lineSeparator());
            escribir.close();
        } catch (IOException ex) {
            System.out.println("ERROR ESCRIBIENDO ARCHIVO");
        }
    }

    public static String leerArchivo() {
        
        String linea = "";

        try {
            FileReader lector = new FileReader(Constantes.ARCHIVO_PERSISTENCIA);
            BufferedReader contenido = new BufferedReader(lector);
            linea = contenido.readLine();

        } catch (FileNotFoundException ex) {
            System.out.println("ARCHIVO NO ENCONTRADO");
        } catch (IOException ex) {
            System.out.println("NO ES POSIBLE LEER EL ARCHIVO");
        }
        return linea;

    }
}
