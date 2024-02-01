package com.nashe;
/**
 * Implementación de una pila utilizando un ArrayList.
 * Esta implementación sigue la interfaz estándar de una pila (Stack).
 *
 * @param <E> Tipo de elementos almacenados en la pila.
 * @author June Herrera, Jonathan Zacarías
 */

import java.util.ArrayList;

public class StackArrayList<E> implements Stack<E> {

    // La estructura de datos subyacente para almacenar elementos
    protected ArrayList<E> data;

    // Constructor para inicializar el ArrayList
    public StackArrayList() {
        data = new ArrayList<E>();
    }

    // Agrega un elemento a la pila
    public void push(E item) {
        data.add(item);
    }

    // Elimina y devuelve el elemento superior de la pila
    public E pop() {
        // Verifica si la pila está vacía antes de realizar el pop
        if (empty()) {
            throw new java.util.EmptyStackException();
        }
        // Elimina y devuelve el último elemento (cima de la pila)
        return data.remove(size() - 1);
    }

    // Devuelve el elemento superior de la pila sin eliminarlo
    public E peek() {
        // Verifica si la pila está vacía antes de realizar el peek
        if (empty()) {
            throw new java.util.EmptyStackException();
        }
        // Devuelve el último elemento (cima de la pila)
        return data.get(size() - 1);
    }

    // Devuelve el número de elementos en la pila
    public int size() {
        return data.size();
    }

    // Verifica si la pila está vacía
    public boolean empty() {
        return size() == 0;
    }
}
