/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nomina;

import ADT.ArregloADT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



/**
 *
 * @author cuaut
 */
public class Nomina {
    public static void main(String[] args) {
          String ruta="src\\Archivo\\junio.dat";
         Nomina test= new Nomina(ruta);
         
         
    }
    int z;
    ArregloADT nominaADT;

    public Nomina(String ruta) {
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		Path filePath = Paths.get(ruta);
		try {

			BufferedReader br = Files.newBufferedReader(filePath,Charset.forName("ISO-8859-1"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosDelinea = linea.split(",");
                                String[] contador=linea.split("\n");
                                z=z+contador.length;
				ArrayList<String> datosTemporal = new ArrayList<String>();
				for (String dato : datosDelinea) {
					datosTemporal.add(dato);
				}
				datos.add(datosTemporal);
			}
                        nominaADT= new ArregloADT(z-1);
                        int columna=0;
                        for(int fila=1;fila<datos.size();fila++){
                          Trabajador empleado=new Trabajador(Integer.parseInt(datos.get(fila).get(0)),
                                   datos.get(fila).get(1),datos.get(fila).get(2),datos.get(fila).get(3),
                                  Integer.parseInt(datos.get(fila).get(4)),Integer.parseInt(datos.get(fila).get(5)),Integer.parseInt(datos.get(fila).get(6)));
                         nominaADT.setElemento(columna, empleado);
                         columna++;

                        }
                       for(int i=0;i<nominaADT.getLongitud();i++){
                           System.out.println(nominaADT.getElemento(i)+" ////");
                           
                       }
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
             
    }
     Trabajador temp;
    public void lista_Sueldo(){
        
        for(int i=0;i<nominaADT.getLongitud();i++){
            temp=(Trabajador) nominaADT.getElemento(i);
            System.out.println("ID: "+temp.getNumTrabajador()+", Sueldo: "+ temp.sueldoTotal());
            
        }          
    }
    public void mayor_antiguedad(){
        int mayor=2023;
        int idice=0;
        for(int i=0;i<nominaADT.getLongitud();i++){
            temp=(Trabajador) nominaADT.getElemento(i);
            if(temp.getAñoingreso()<mayor){
              idice=i;
              mayor=temp.getAñoingreso();
            }
        }
         temp=(Trabajador) nominaADT.getElemento(idice);
        System.out.println("ID: "+temp.getNumTrabajador()+", Nombre: "+temp.getNombre()+ ", Año de ingreso"+ temp.getAñoingreso());
    }
}

