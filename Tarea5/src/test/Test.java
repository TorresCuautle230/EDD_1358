/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import lista.listaDobleligada;

/**
 *
 * @author cuaut
 */
public class Test {
     public static void main(String[] args) {
        listaDobleligada cabeza = new listaDobleligada();
        cabeza.agregarAlInicio(18);
        cabeza.agregarAlFinal(1);
        cabeza.agregarAlFinal(27);
        cabeza.agregarAlFinal(20);
        cabeza.agregarAlFinal(500);
        cabeza.transversal();
         System.out.println("////////////////////////");
        cabeza.agregarDespuesDe(2, 5);
        cabeza.transversal();
         System.out.println("////////////////////////");
         cabeza.agregarAlInicio(9);
         System.out.println(cabeza.getTamanio());
         cabeza.transversal();
         System.out.println("////////////////////////");
         cabeza.eliminar(5);
         cabeza.transversal();
         System.out.println("////////////////////////");
         cabeza.eliminarElPrimero();
         cabeza.transversal();
         System.out.println("////////////////////////1");
         cabeza.eliminarElFinal();
         System.out.println(cabeza.getTamanio());
         cabeza.transversal();
         System.out.println("////////////////////////");
         System.out.println(cabeza.buscarValor(18));
         System.out.println("////////////////////////2");
         cabeza.actualizarValor(18, 6);
         cabeza.transversal();
    }
}
