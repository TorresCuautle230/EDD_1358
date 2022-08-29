package Test;
import java.util.ArrayList;

import ArregloADT.Arreglo;

public class Prueva {
	public static void main(String[] args) {
		  Arreglo lista =new Arreglo(3);
		  ArrayList<String> perros= new ArrayList();
		  perros.add("salchicha");
		  perros.add("chihuahua");
		  perros.add("doberman");
		  
		System.out.println(lista.getLongitud());
		lista.setElemento(0, "hola");
		
		
		System.out.println(lista.getElemento(0));
		lista.setElemento(2, 3312);
		System.out.println(lista.getElemento(2));
		lista.setElemento(1, perros);
		System.out.println(lista.getElemento(1));
		
		Object x=lista.getElemento(2);
		System.out.println(x);
	
		System.out.println(lista.toString());
		
		lista.limpiar(null);
		System.out.println(lista.toString());
		
		lista.limpiar("hola");
		System.out.println(lista.toString());
	
		
		
	}

}
