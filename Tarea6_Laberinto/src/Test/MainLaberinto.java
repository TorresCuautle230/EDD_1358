/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.IOException;
import java.util.ArrayList;
import laberinto.Casilla;
import laberinto.Casilla;
import laberinto.Tablero;
import laberinto.Tablero;

public class MainLaberinto {
	public static void main(String[] args) throws IOException {
                String ruta = "src\\Laberintos\\lab1.dat";
                ArrayList<Casilla<Boolean>> camino = new ArrayList<>();
		Tablero<Casilla<Boolean>> lab = new Tablero<Casilla<Boolean>>(ruta,10,10,9,1,6,9);		
		camino.add(lab.getDatos().getItem(9, 1));
		lab.rellenarCaminos(lab, (Casilla<Boolean>) lab.getDatos().getItem(9, 1), camino);
		System.out.println("Camino mostrado con Pila");
		lab.getTrallecto().transversal();
		
	}
}