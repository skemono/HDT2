package com.nashe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculadora {

    private CalculadoraADT calculadora;

    @Before
    public void setUp() {
        Stack<Integer> pila = new StackArrayList<>();
        calculadora = new CalculadoraPostfix(pila);
    }

    @Test
    public void testExpresionSimple() throws Exception {
        String expresion = "1 2 +";
        int resultado = calculadora.evaluarExpresion(expresion);
        assertEquals(3, resultado);
    }

    @Test
    public void testExpresionCompleja() throws Exception {
        String expresion = "6 2 3 + *";
        int resultado = calculadora.evaluarExpresion(expresion);
        assertEquals(30, resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpresionInvalida() throws Exception {
        String expresion = "1 a +"; // Contiene un carácter no válido
        calculadora.evaluarExpresion(expresion);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionPorCero() throws Exception {
        String expresion = "4 0 /";
        calculadora.evaluarExpresion(expresion);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOperandosInsuficientes() throws Exception {
        String expresion = "1 +"; // Operación suma sin suficientes operandos
        calculadora.evaluarExpresion(expresion);
    }
}
