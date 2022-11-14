/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea7;

import java.util.ArrayList;

/**
 *
 * @author cuaut
 */
public class colas<T> {
    
    private ArrayList<T> cola;
    private int tamanio;

    public static void main(String[] args) {
        // TODO code application logic here
        colas lis = new colas<>();
        System.out.println(lis.is_Empty());
        System.out.println("//////////");
        lis.enqueue(1);
        lis.enqueue(2);
        lis.enqueue(3);
        lis.enqueue(4);
        lis.enqueue(5);
        lis.enqueue(6);
        lis.enqueue(7);
        lis.enqueue(8);
        lis.enqueue(9);
        lis.enqueue(10);
        System.out.println(lis.to_string());
        System.out.println("//////////");
        System.out.println(lis.length());
        System.out.println("//////////");
        lis.dequeue();
        System.out.println(lis.to_string());
        System.out.println("//////////");
        lis.enqueue(9);
        System.out.println(lis.to_string());
        System.out.println("//////////");
        System.out.println(lis.is_Empty());
        System.out.println("//////////");
        System.out.println(lis.toString());
    }

    public colas() {
        this.tamanio=0;
        this.cola = new ArrayList();       

    }

    public int length() {
        if (is_Empty()) {
            return tamanio;
        } else {
            this.tamanio = cola.size();
            return tamanio;
        }
    }

    public boolean is_Empty() {
        if (this.cola.size()==0) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(T elemento) {
        this.cola.add(elemento);
    }

    public T dequeue() {
        
        T elemento=this.cola.get(0);
        this.cola.remove(0);
        return elemento;
    }

    public String to_string() {
        String cadena = "";
       
        for (int i = 0; i <= this.cola.size()-1; i++) {
            cadena = cadena+ " | " + this.cola.get(i);
        }
        cadena = cadena+ " | ";
        return cadena;
    }

}


