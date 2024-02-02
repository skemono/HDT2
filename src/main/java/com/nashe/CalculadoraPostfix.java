package com.nashe;

import java.util.StringTokenizer;

/**
 * Implementación de la interfaz CalculadoraADT para evaluar expresiones en notación postfix.
 */
public class CalculadoraPostfix implements CalculadoraADT {

    private Stack<Integer> pila;

    public CalculadoraPostfix(Stack<Integer> pila) {
        this.pila = pila;
    }

    public int evaluarExpresion(String expresion) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(expresion);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (esOperando(token)) {
                int operando = Integer.parseInt(token);
                pila.push(operando);
            } else if (esOperador(token)) {
                evaluarOperacion(token);
            } else {
                throw new IllegalArgumentException("Expresión contiene caracteres no válidos");
            }
        }

        // Al final, debe haber un único valor en la pila, que es el resultado final.
        if (pila.size() == 1) {
            return pila.pop();
        } else {
            throw new IllegalArgumentException("Operandos insuficientes en la expresión");
        }
    }

    private boolean esOperando(String token) {
        // Verifica si el token es un operando (número)
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esOperador(String token) {
        // Verifica si el token es un operador válido (+, -, *, /)
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private void evaluarOperacion(String operador) throws Exception {
        if (pila.size() < 2) {
            throw new IllegalArgumentException("Operandos insuficientes para la operación " + operador);
        }
        int operandoB = pila.pop();
        int operandoA = pila.pop();

        switch (operador) {
            case "+":
                pila.push(operandoA + operandoB);
                break;
            case "-":
                pila.push(operandoA - operandoB);
                break;
            case "*":
                pila.push(operandoA * operandoB);
                break;
            case "/":
                if (operandoB == 0) {
                    throw new ArithmeticException("División por cero");
                }
                pila.push(operandoA / operandoB);
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}
