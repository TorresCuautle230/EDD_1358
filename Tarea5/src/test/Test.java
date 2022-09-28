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
        cabeza.agregarAlFinal(70);
        cabeza.transversal();
         System.out.println("////////////////////////1");
        cabeza.agregarDespuesDe(2, 5);
        cabeza.transversal();
         System.out.println("////////////////////////2");
         cabeza.agregarAlInicio(9);         
         cabeza.transversal();
         System.out.println(cabeza.getTamanio());
         System.out.println("////////////////////////3");
         cabeza.eliminar(5);
         cabeza.transversal();
         System.out.println("////////////////////////4");
         cabeza.eliminarElPrimero();
         cabeza.transversal();
         System.out.println("////////////////////////5");
         cabeza.eliminarElFinal();
         
         cabeza.transversal();         
         System.out.println(cabeza.getTamanio());
         System.out.println("////////////////////////6");
         System.out.println(cabeza.buscarValor(18));
         System.out.println("////////////////////////7");
         cabeza.actualizarValor(18, 6);
         cabeza.transversal();
         System.out.println("////////////////////////8");
         cabeza.transversal("dere");
    }
}
