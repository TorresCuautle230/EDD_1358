/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/*ListaLigadaADT() → Constructor ----------------- Listo
● estaVacia() → esta vacía? ---------------------- Listo
● getTamanio() → regresa el número de elementos. - Listo
● agregarAlFinal(valor) → agrega el nodo al final entrando por head. - Listo
● agregarAlInicio( valor ) → Agregar al inicio --- Listo
● agregarDespuésDe( referencia , valor ) → Agregar un nodo después del
nodo referencia ----------------------------------- Listo
● Eliminar( posicion ) → elimina el elemento en cierta posición. ------- Listo
● EliminarElPrimero() → elimina el primero de la lista. ---------------- Listo
● EliminarElFinal() → elimina el último ---------- Listo
● buscar( valor ) → buscar un elemento en la lista, regresa la posición(int).
--------------------------------------------------- Listo
● actualizar(a_buscar ,valor) -------------------- Listo
● transversal() -→ recorrido transversal para mostrar todos los elementos Listo
 */

public class listaDobleligada<T> {
    
    NodoDoble<T> head;
    int tamanio;

    public listaDobleligada() {
        this.head = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.head == null;
    }

    public int getTamanio() {
        NodoDoble<T> nuevo = this.head;
        int tam=0;
        while (nuevo.getSiguiente() != null) {
                nuevo = nuevo.getSiguiente();
                
                tam=tam+1;
                
            }
        return tamanio=tam+1;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
            NodoDoble<T> aux = this.head;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                nuevo.setAnterior(aux);
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            aux = null;
            nuevo = null;
        }
    }

    public void agregarAlInicio(T valor) {
         NodoDoble<T> nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
        } else {
           nuevo.setSiguiente(this.head);
           head.setAnterior(nuevo);
           this.head=nuevo;
           
           
        }

    }

    public void agregarDespuesDe(int posicion, T valor) {
        NodoDoble<T> nuevo = new NodoDoble(valor);
        NodoDoble<T> aux = this.head;
        for (int contador = 1; contador <= posicion - 1; contador++) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);
    }

    public void eliminar(int posicion) {
         //Solo elimina despues de head 
         NodoDoble<T> aux = this.head;
        for (int contador = 1; contador <= posicion-1 ; contador++) {
            aux = aux.getSiguiente();            
        }
        
        aux.setSiguiente(aux.getSiguiente().getSiguiente());
        aux.setAnterior(aux);
              

    }
   

    public void eliminarElPrimero() {
        
        
        if (this.estaVacia()) {
            System.out.println("Esta vacia");
        } else {
          NodoDoble<T> nuevo = head.getSiguiente();
          head=nuevo;
          head.setAnterior(null);
           
           
        }

    }

    public void eliminarElFinal() {
        NodoDoble<T> nuevo = this.head;
        int tam=0;
        while (nuevo.getSiguiente() != null) {
                nuevo = nuevo.getSiguiente();
               
                tam=tam+1;
                
            }
       NodoDoble<T> aux = this.head;
        for (int contador = 1; contador <= tam-1 ; contador++) {
            aux = aux.getSiguiente();            
        }
        
        aux.setSiguiente(aux.getSiguiente().getSiguiente());
        aux.setAnterior(aux);   

    }

    public int buscarValor(T valor) {
         NodoDoble<T> nuevo = this.head;
        int posicion = 1;
        while (nuevo.getSiguiente() != null) {
            
            
             if(nuevo.getDato()!=valor){
                  posicion+=1;
                  nuevo = nuevo.getSiguiente();
             }else {
                 break;
             }
                
            }
        return posicion;
    }

    public void actualizarValor(T antiguo, T nuevo) {
        
          NodoDoble<T> aux = this.head;
        
        while (aux.getSiguiente() != null) {
            
            if(aux.getDato()==antiguo) {
                aux.setDato(nuevo);
                 break;
             } if(aux.getDato()!=antiguo){
                 
                  aux = aux.getSiguiente();
                                   
             } if(aux.getDato()==antiguo) {
                aux.setDato(nuevo);
                 break;
             }
            
        }
            
             

    }

    public void transversal() {
        NodoDoble nodo_actual = this.head;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    


}