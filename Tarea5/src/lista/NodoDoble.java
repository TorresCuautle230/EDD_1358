/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lista;

/**
 *
 * @author cuaut
 */
public class NodoDoble<T> {

    private T datos;
    private NodoDoble<T> Siguiente;
    private NodoDoble<T> Anterior;

    //Constructor por defecto
    public NodoDoble() { 
    }
    
    //Constructor sobrecargado, solo dato
    public NodoDoble(T dato) {  
        this.datos = dato;
    }
    
    //Constructor sobrecargado 
    public NodoDoble(T dato, NodoDoble<T> Sig, NodoDoble<T> Ant) { 
        this.datos = dato;
        this.Siguiente = Sig;
        this.Anterior = Ant;
    }


    public NodoDoble<T> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoDoble<T> Sig) {
        this.Siguiente = Sig;
    }
    
    public NodoDoble<T> getAnterior(){
        return Anterior;
    }
    
    public void setAnterior(NodoDoble<T> Ant){
        this.Anterior = Ant;
    }

    public T getDato() {
        return datos;
    }

    public void setDato(T dato) {
        this.datos = dato;
    }

    //Método toString()
    @Override
    public String toString() {
        return "|" + datos + "| <-> ";
    }

    public String mostrarTodo() {
        return "[Anterior= "+ this.getAnterior() + "] <-> [Dato= " + datos + "] <-> [Siguiente= " + this.getSiguiente() + "]";
    }
}
