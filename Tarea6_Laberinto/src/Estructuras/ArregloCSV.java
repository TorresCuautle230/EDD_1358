/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Estructuras;



/**
 *
 * @author cuaut
 */
public class ArregloCSV<T> {
    private int fila;
    private int columna;
    private ArregloADT<ArregloADT<T>> lista;

    public ArregloCSV(int filas, int columnas) {
        this.fila = columnas;
        this.columna = filas;
        
        lista=new ArregloADT<>(filas);
        
        for(int i=0;i<lista.getLongitud();i++){
            lista.setElemento(i, new ArregloADT<>(columnas));
        }
    }

 
    
    public int getFila(){
        return this.fila;
    }
    public int getColumna(){
        return this.columna;
    }
    
    public void setElemento(T dato,int columna, int fila){
        this.lista.getElemento(columna).setElemento(fila, dato);
    }
    
    public T getElemento(int columna,int fila){
        return this.lista.getElemento(columna).getElemento(fila);
    }
    
    public void limpiar(T dato){
        for(int i=0; i <= this.columna; i++){
            for(int b=0; b <= this.fila; b++){
                this.setElemento(dato, b, i);
                
            }
        }
    }
    
    @Override
	public String toString() {
		String array = "";
		for (int i = 0; i < this.fila ; i++) {
			for (int j = 0; j < this.columna; j++) {
				array += this.getElemento(j, i) +" ";
			}
			array += "\n";
		}
		return array;
	}
    
    

    
    
}
