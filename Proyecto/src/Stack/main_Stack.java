
package Stack;
/**
 *
 * @author cuaut
 */
import java.util.Stack;
public class main_Stack {
    public static void main(String[] args) {
       Stack pila =new Stack();
       pila.add(1);//Agrega un elemento al final.
       pila.add(2);
       pila.add(3);
       pila.add(4);
       System.out.println("\n"+pila.toString()+ "\n");
       
       pila.add(4, 5);//Agrega un elemento en el indice especificado.
       pila.push(6);//Agrega un elemento al top de la pila.
       System.out.println("\n"+pila.toString()+ "\n");
       
       pila.size();//indica el numero de elementos que hay en la pila.
       pila.empty();//Devuelve true o false si la pila esta vacia.    
       
       System.out.println("Elemento en top: "+pila.pop());//Consulta el elemento en la posicion top y despues lo remueve.
       
       System.out.println("Elemento en top: "+ pila.peek());//Consulta el elemento en la posicion top.
       System.out.println("la capacidad: "+ pila.capacity());//Consulta la capacidad de la pila.
       
       System.out.println("\n"+pila.toString()+ "\n");//muestra los elementos en la pila en forma de String.
    }
}
