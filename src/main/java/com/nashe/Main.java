package com.nashe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> pila = new StackArrayList<>();
        CalculadoraADT calculadora = new CalculadoraPostfix(pila);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int resultado = calculadora.evaluarExpresion(linea);
                System.out.println("Expresión: " + linea);
                System.out.println("Resultado: " + resultado);
                System.out.println("-----------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
