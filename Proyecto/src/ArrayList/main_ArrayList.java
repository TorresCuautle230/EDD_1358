/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ArrayList;

import java.util.ArrayList;

/**
 *
 * @author cuaut
 */
  
public class main_ArrayList {

    
    public static void main(String[] args) {
       
         ArrayList lista = new ArrayList();
        
        lista.add("hola");//Agrega un elemento al final.
        lista.add(1, 3);//Agrega un elemento en un indice especifico.
        lista.add(4);
        lista.add(2);
        lista.add(6);
        System.out.println("Elemento en la casilla 1: "+ lista.get(1));//obtiene un valor en un indice especificado.
        System.out.println("¿Lista contiene 2? "+ lista.contains(2));//devuelve true o false (boolean)si esta un elemento x en la lista.
        System.out.println("/////////");
        for (int i = 0; i <= lista.size()-1; i++) {//devuelve el numero de elementos en la lista.
            System.out.println("Elemento en la posicion "+ i+": "+ lista.get(i));
        }
        System.out.println("\n"+lista.toString());//muestra los elementos en la lista en forma de String.
        
    }
    
}
