/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea8_cola_ac;

import java.util.ArrayList;

/**
 *
 * @author cuaut
 */
public class cola_AC<T> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cola_AC barco = new cola_AC(7);
        System.out.println(barco.is_Empty());
        System.out.println("//////////");
        // 0
        
        //1
        barco.enqueue(1, "Niñas");
        //2
        barco.enqueue(2, "Niños");
        barco.enqueue(2, "3era edad");
        //3
        barco.enqueue(3, "Mujeres");
        barco.enqueue(3, "Hombres");
        //4
         barco.enqueue(4, "Maestre");
         barco.enqueue(4, "Mecanico");
         barco.enqueue(4, "Vijia");
        //5
        barco.enqueue(5, "Capitan");
        //6
           
        
        barco.enqueue(0, "Gato");
        System.out.println(barco.to_string());
        System.out.println("//////////");
        System.out.println(barco.length());
        System.out.println("//////////");
        barco.dequeue();
        System.out.println(barco.to_string());      
        System.out.println("//////////");
        System.out.println(barco.is_Empty());
    }
    private int tamanio;
    private ArrayList<ArrayList> cola_AC;

    public cola_AC(int tamanio) {
        this.tamanio = tamanio;
        cola_AC=new ArrayList<>(tamanio);        
       
        for (int i = 0; i <= tamanio-1; i++) {            
             ArrayList<T> fila= new ArrayList();            
            cola_AC.add(i, fila);            
        }
    }
    
    public boolean is_Empty(){
        int contador=0;        
        for (int i = 0; i <= tamanio-1; i++) {
            
            if(cola_AC.get(i).size()>=1){
                contador=contador+1;
            }
        }
        if(contador>0){
            return false;
        }else{
            return true; 
        }

        
    }
    
    public int length(){
        int elementos=0;
        for (int i = 0; i <= tamanio-1; i++) {
            elementos= elementos + cola_AC.get(i).size();
        }
        return elementos;
    }
    
    public void enqueue(int prioridad, T elemento){
        //empieza desde 0
        cola_AC.get(prioridad).add(elemento);        
    }
    
    public T dequeue(){
        T elemento = null;
        for (int i = tamanio; i >=1; i--) {
            if(cola_AC.get(tamanio-i).size()>0){
                elemento= (T) cola_AC.get(tamanio-i).get(0);
                cola_AC.get(tamanio-i).remove(0);
                if(elemento!=null){
                    break;
                }
            }           
            
        }
        return elemento;
        
    }
    
    public String to_string(){
        String cadena="";
        for (int i = 0; i <= tamanio-1; i++) {
            cadena= cadena + "Prioridad "+ i;
            for (int j = 0; j <=cola_AC.get(i).size()-1; j++) {
                cadena = cadena+ " | " + cola_AC.get(i).get(j);
                
            }
            cadena = cadena+ " |  \n";
        }
        return cadena;
    }
    
}
