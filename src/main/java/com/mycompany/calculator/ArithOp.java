/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

public class ArithOp {
    public static interface ArithmeticOp {
        double operation(double a, double b);
    }
    
    public static interface ArithmeticOp2 {
        double lambda(double a, double b);
    }

    public static double add(double a, double b) {
        System.out.println("Suma");
        return a + b;
    }

    public static double exp(double a, double b) {
        System.out.println("Potencia");
        return Math.pow(a, b);
    }

    public static double square(double a, double b) {
        System.out.println("Cuadrado");
        return Math.pow(a, 2);
    }

    public static double sub(double a, double b) {
        System.out.println("Resta");
        return a - b;
    }

    public static double div(double a, double b) {
        System.out.println("División");
        if (b != 0){
            return a / b;
        }
        System.out.println("No se permite la división por cero");
        return 0;
    }
    
    public static double mult(double a, double b) {
        System.out.println("Multiplicación");
        return a * b;
    }
}

