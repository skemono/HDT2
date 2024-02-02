package com.nashe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPila {

    private Stack<Integer> pila;

    @Before
    public void setUp() {
        pila = new StackArrayList<>();
    }

    @Test
    public void testPushPop() throws Exception {
        pila.push(1);
        pila.push(2);

        assertEquals(2, (int) pila.pop());
        assertEquals(1, (int) pila.pop());
    }

    @Test
    public void testPeek() throws Exception {
        pila.push(3);
        pila.push(5);

        assertEquals(5, (int) pila.peek());
        assertEquals(2, pila.size()); // La pila no debe cambiar después de un peek
    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(pila.empty());

        pila.push(7);
        assertFalse(pila.empty());

        pila.pop();
        assertTrue(pila.empty());
    }
}
