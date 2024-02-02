package com.nashe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> pila = new StackArrayList<>();
        CalculadoraADT calculadora = new CalculadoraPostfix(pila);
        System.out.println(System.getProperty("user.dir"));

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int resultado = calculadora.evaluarExpresion(linea);
                System.out.println("-----------");
                System.out.println("Expresión evaluada: " + linea);
                System.out.println("Resultado final: " + resultado);
                System.out.println("-----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
