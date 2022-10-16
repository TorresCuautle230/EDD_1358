package Estructuras;

import Estructuras.ArregloADT;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Arreglo_DosD_ADT<T> {

	private int filas;
	private int columnas;
	private ArregloADT<ArregloADT<T>> fillasYCollumnas;

	public Arreglo_DosD_ADT(int Fila, int Colu) { // Constructor
		this.filas = Fila;
		this.columnas = Colu;
		fillasYCollumnas = new ArregloADT<ArregloADT<T>>(filas);
		for (int i = 0; i < filas; i++) {
			fillasYCollumnas.setElemento(i, new ArregloADT<T>(Colu));
		}

	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setItem(int IndFil, int IndCol, T Elemento) {
		if (IndCol >= 0 && IndCol < columnas) {
			if (IndFil >= 0 && IndFil < filas) {
				fillasYCollumnas.getElemento(IndFil).setElemento(IndCol, Elemento);
			}
		}
	}

	public T getItem(int IndFil, int IndCol) {
		if (IndCol >= 0 && IndCol < columnas) {
			if (IndFil >= 0 && IndFil < filas) {
				return (T) fillasYCollumnas.getElemento(IndFil).getElemento(IndCol);
			}
		}
		return null;
	}

	public void clear(T Elemento) {
		for (int Fik = 0; Fik < this.filas; Fik++) {
			for (int Cok = 0; Cok < this.columnas; Cok++) {
				setItem(Fik, Cok, Elemento);
			}
		}
	}

	public String toString() {
		String cadena = "";
		cadena += fillasYCollumnas + "\n";
		return cadena;
	}

	public void transversal() {
		for (int Fik = 0; Fik < getFilas(); Fik++) {
			for (int Cok = 0; Cok < getColumnas(); Cok++) {
				System.out.print(getItem(Fik, Cok) + " ");
			}
			System.out.print("\n");

		}
	}

}