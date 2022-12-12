
package LinkedList;

/**
 *
 * @author cuaut
 */
import java.util.LinkedList;
public class main_LinkedList {
    public static void main(String[] args) {
       LinkedList lista_Ligada = new LinkedList();
        lista_Ligada.add(44);//Agrega un elemento al final.
        lista_Ligada.add(5);
        lista_Ligada.add(55);
        lista_Ligada.add(3, "hola");//Agrega un elemento en el indice especificado.
        lista_Ligada.addFirst(1);////Agrega un elemento al principio.
        lista_Ligada.addLast(100);////Agrega un elemento al final de la lista.
        
        System.out.println( lista_Ligada.toString()+"\n ///////\n ");
        
        System.out.println("¿Contiene 5 en la lista?: "+lista_Ligada.contains(5));//Regresa true o false (boolean)si el elemnto X se encuentra en la lista.
        
        System.out.println("obtener el elemento en el indice 0 "+lista_Ligada.get(0));//Obtiene el valor en el indice indicado(puede ser utilizado en iteraciones).
        System.out.println("obtener el primer elemento de la lista: "+ lista_Ligada.getFirst());//Obtiene el primer valor de la listal.
        System.out.println("obtener el ultimo elemento de la lista: "+lista_Ligada.getLast());//Obtiene el ultimo valor de la lista.
        
        System.out.println("¿Esta vacia?"+ lista_Ligada.isEmpty());//Devuelve true o false si la lista esta vacia.        
        System.out.println( lista_Ligada.toString()+"\n ///////\n ");
        
        lista_Ligada.remove("hola");//remueve el dato solicitado.
        lista_Ligada.removeFirst();//remueve el primer dato.
        lista_Ligada.removeLast();//remueve el ultimo dato.
        System.out.println( lista_Ligada.toString()+"\n ///////\n ");//muestra los elementos en la lista en forma de String.
    }
}
