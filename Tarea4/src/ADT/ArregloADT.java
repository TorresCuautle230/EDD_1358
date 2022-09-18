/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADT;

/**
 *
 * @author cuaut
 */
import java.util.ArrayList;

public class ArregloADT<T> {

  private int tamanio;
	private ArrayList<T> datos;

	public ArregloADT(int tamaño) {
		this.tamanio = tamaño;
		this.datos = new ArrayList<T>();

		for (int i = 0; i < this.tamanio; i++) {
			this.datos.add(null);
		}

	}

	public T getItem(int indice) {
		if (indice >= 0 && indice < this.tamanio) {
			return datos.get(indice);
		}

		return null;
	}

	public void setItem(T elemento, int indice) {
		if (indice >= 0 && indice < this.tamanio) {
			datos.set(indice, elemento);
		}
	}

	public int getLength() {
		return this.tamanio;
	}

	public void clear(T parametro) {
		for (int i = 0; i < this.tamanio; i++) {
			this.datos.set(i, parametro);
		}
	}

	@Override
	public String toString() {
		String estado = "------------- "+ this.tamanio +" -------------\n";
        for (T dato : datos) {
            if(dato != null){
                estado += dato.toString()+"\n";
            }
        }
        return estado;
	}

}