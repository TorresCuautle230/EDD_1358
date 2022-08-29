package ArregloADT;

import java.util.Arrays;

public class Arreglo {
	Object[] lista;
	private int longitud;

	public Arreglo(int longitud) {
		this.longitud = longitud;
		lista = new Object[longitud];
	}

	public Object getElemento(int indice) {

		return lista[indice];

	}

	public <T> void setElemento(int indice, T elemento) {

		lista[indice] = elemento;

	}

	public int getLongitud() {
		return longitud;
	}

	public <T> void limpiar(T elemento) {

		for (int i = 0; i <= lista.length - 1; i++) {

			lista[i] = elemento;
	

		}
	}

	@Override
	public String toString() {
		return "Arreglo [lista=" + Arrays.toString(lista) + ", longitud=" + longitud + "]";
	}

}
