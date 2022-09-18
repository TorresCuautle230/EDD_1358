/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import ADT.Arreglo2DADT;
import java.util.Scanner;

public class Juego {

    private Reglas obj;
    private Arreglo2DADT<String> reflejo;

    public Juego() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int fila, columna, numCelulas = 1;
        String salida = "s";
        
        System.out.printf("%30s %n", "JUEGO DE LA VIDA");
        System.out.println("Introduzca el número de filas que tendrá el tablero:");
        fila = Integer.parseInt(s.nextLine());
        
        System.out.println("Introduzca el número de columnas que tendrá el tablero:");
        columna = Integer.parseInt(s.nextLine());
        
        this.obj = new Reglas(fila, columna);
        this.reflejo = new Arreglo2DADT<>(this.obj.getCeldas().getFilas(), this.obj.getCeldas().getColumnas());
        System.out.println("\n");
        
        for (int i = 0; i < this.obj.getCeldas().getFilas(); i++) {
            for (int j = 0; j < this.obj.getCeldas().getColumnas(); j++) {
                this.obj.getCeldas().setElemento("-", i, j);
            }
        }

        fila = 0;
        columna = 0;
        
        while (salida.equals("s")) {
            
            System.out.println("*Nota: Las filas empiezan desde el numero 0");
            System.out.println("Ingresa una coordenada para la fila de la celula num " + numCelulas + ":");
            fila = Integer.parseInt(s.nextLine());
            
            System.out.println("*Nota: Las columnas empiezan desde el numero 0");
            System.out.println("Ingresa una coordenada para la columna de la celula num " + numCelulas + ":");
            columna = Integer.parseInt(s.nextLine());
            
            obj.getCeldas().setElemento("0", fila, columna);
            
            System.out.println("¿Desea ingresar más células vivas? Ingrese la letra s para seguir añadiendo o "
                    + "ingrese cualquier letra para salir.");
            salida = s.nextLine();
            numCelulas++;
        }
        System.out.println("\n");
    }

    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);
        String celda;
        boolean entrada = true;
        int numGeneraciones, contGeneraciones = 1;

        System.out.println("Introduzca el número de generaciones que quiere ver:");
        numGeneraciones = Integer.parseInt(sc.nextLine());
        sc.close();
        
        do {
            System.out.printf("%45s %n", "-------- " + contGeneraciones + "° Generación --------- \n");
            System.out.println(this.imprimirMatriz(this.obj.getCeldas()));
            for (int filas = 0; filas < this.obj.getCeldas().getFilas(); filas++) {
                
                for (int columnas = 0; columnas < this.obj.getCeldas().getColumnas(); columnas++) {
                    
                    if (filas == 0 | filas == (this.obj.getCeldas().getFilas() - 1) | columnas == 0 | columnas == (this.obj.getCeldas().getColumnas() - 1)) {
                        celda = this.obj.recorrerCeldaExterior(filas, columnas);
                        this.reflejo.setElemento(celda, filas, columnas);
                    } else {
                        celda = this.obj.recorrerCeldaCentral(filas, columnas);
                        this.reflejo.setElemento(celda, filas, columnas);
                    }
                }
            }
            contGeneraciones++;
            this.copiarArregloADT();
            entrada = this.evaluarArregloADT();
            if (!entrada) {
                System.out.printf("%35s %n", "-------- " + contGeneraciones + "° Generación -------- \n");
                System.out.println(this.imprimirMatriz(this.obj.getCeldas()));
                System.out.printf("%55s %n", "La población murió en su totalidad en la " + contGeneraciones + "° generación");
            }
            if (contGeneraciones == (numGeneraciones + 1)) {
                entrada = !entrada;
            }
        } while (entrada);
    }

    private void copiarArregloADT() {
        for (int filas = 0; filas < this.obj.getCeldas().getFilas(); filas++) {
            for (int columnas = 0; columnas < this.obj.getCeldas().getColumnas(); columnas++) {
                this.obj.getCeldas().setElemento(this.reflejo.getElemento(filas, columnas), filas, columnas);
                this.reflejo.setElemento(null, filas, columnas);
            }
        }
    }

    private boolean evaluarArregloADT() {
        for (int filas = 0; filas < this.obj.getCeldas().getFilas(); filas++) {
            for (int columnas = 0; columnas < this.obj.getCeldas().getColumnas(); columnas++) {
                if (this.obj.getCeldas().getElemento(filas, columnas).equals("0")) {
                    return true;
                }
            }
        }
        return false;
    }

    private String imprimirMatriz(Arreglo2DADT<String> objeto) {
        String ar = "";
        for (int i = 0; i < objeto.getFilas(); i++) {
            for (int j = 0; j < objeto.getColumnas(); j++) {
                ar += objeto.getElemento(i, j) + "    ";
            }
            ar += "\n";
        }
        return ar;
    }
}
