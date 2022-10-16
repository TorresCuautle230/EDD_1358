package laberinto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

public class Pila<T> {

    public ArrayList<T> pila;
    int tope;

    Pila() {
        pila = new ArrayList<>();
        tope = -1;
    }

    public void push(T i) {
        pila.add(i);
        tope++;

    }

    public T pop() {
        T aux;
        if (isEmpty()) {
            System.out.println("Error");
            return null;
        } else {
            aux = pila.get(tope);
            pila.remove(tope);
            tope--;
            return aux;
        }

    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public int length() {
        return pila.size();

    }

    public T Peek() {
        T aux;
        if (isEmpty()) {
            System.out.println("Pila Vacia");
            return null;
        } else {
            aux = pila.get(tope);
            return aux;
        }

    }

    public void clear() {
        pila.clear();
    }

    public void transversal() {

        for (int i = 0; i <= pila.size() - 1; i++) {
            System.out.println("[" + pila.get(i) + "]");
        }
    }
}
