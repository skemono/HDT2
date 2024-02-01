package com.nashe;

/**
 * Interfaz que define las operaciones básicas de una pila.
 *
 * @param <E> Tipo de elementos almacenados en la pila.
 */
public interface Stack<E> {

    /** Agrega un elemento a la pila. */
    public void push(E item);

    /** Elimina y devuelve el elemento superior de la pila. */
    public E pop();

    /** Devuelve el elemento superior de la pila sin eliminarlo. */
    public E peek();

    /** Verifica si la pila está vacía. */
    public boolean empty();

    /** Retorna el tamaño del stack. */
    public int size();
}
