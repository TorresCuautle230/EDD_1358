/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tabla_hash;

import java.util.ArrayList;

/**
 *
 * @author cuaut
 */
public class Tabla_hash<T> {
    private ArrayList<ArrayList<T>> principal;
    private int tamanio;

    public Tabla_hash(int tamanio) {
        if (tamanio%2!=0){
            this.tamanio = tamanio;
        }else{
            tamanio=tamanio+1;
            this.tamanio = tamanio;
        }
       
        principal= new ArrayList<>(this.tamanio);
        for (int i = 0; i <= this.tamanio-1; i++) {
            ArrayList<T> secundaria = new ArrayList<>();
            principal.add(i, secundaria);
        }
        
    }
    
    public void Add(int key ,T value){
        int casilla=key%tamanio;
       T llave=(T) (""+key);
        
        this.principal.get(casilla).add(llave);        
        this.principal.get(casilla).add(value);
        
    }
    
    public T valueOf( int key){
        int casilla=key%tamanio;
          String llave= ""+key;
         T resultado = (T) "elemento no exis<tente";
                   
         for (int i = 0; i <= principal.get(casilla).size()-1; i++) {            
             String comp=(String) principal.get(casilla).get(i);             
             if(comp.equals(llave)){                             
                 resultado=this.principal.get(casilla).get(i+1);
                 break;
            }
             
            
         }
         
         return resultado;
    }
    
   public void Remove(int key){
       int casilla=key%tamanio;
          String llave= ""+key;
         
                   
         for (int i = 0; i <= principal.get(casilla).size()-1; i++) {            
             String comp=(String) principal.get(casilla).get(i);             
             if(comp.equals(llave)){
                 principal.get(casilla).remove(i+1);
                 principal.get(casilla).remove(i);
                 
                 
            }
            
         }
        
   }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       Tabla_hash lis= new Tabla_hash(10);
       
       //se guarda en la misma casilla "colicion"
       lis.Add(25, "gato");       
       lis.Add(3, "Perro");
       //se guarda en una casilla diferente
       lis.Add(3456, 444);
       //busca el la llave 3 que corresponde a perro
       System.out.println(lis.valueOf(3));
       //elimina a perro
       lis.Remove(3);
       //busca el elemento eliminado
       System.out.println(lis.valueOf(3));
       //busca el elemento 444
       System.out.println(lis.valueOf(3456));
    }
    
}
