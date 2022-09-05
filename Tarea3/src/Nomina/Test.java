/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Nomina;

import ADT.ArregloADT;
import Nomina.Trabajador;
import Nomina.Nomina;
import java.awt.desktop.OpenFilesEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.module.ModuleDescriptor;
import javax.sound.sampled.LineEvent;
/**
 *
 * @author cuaut
 */
public class Test {

    private static Test entrada;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       String ruta="src\\Archivo\\junio.dat";
        System.out.println("\n///////////////\n");
       Nomina test= new Nomina(ruta);
        System.out.println("\n///////////////\n");
      test.mayor_antiguedad();
       System.out.println("\n///////////////\n");
       test.lista_Sueldo(); 
    }

   
    
}
