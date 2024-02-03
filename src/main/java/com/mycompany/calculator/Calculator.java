/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Apuntadores
        ArithOp.ArithmeticOp pointer1 = ArithOp::add;
        ArithOp.ArithmeticOp pointer2 = ArithOp::exp;
        ArithOp.ArithmeticOp pointer3 = ArithOp::square;

        System.out.println(pointer1.operation(5, 2));
        System.out.println(pointer2.operation(5, 3));
        System.out.println(pointer3.operation(5, 2));

        // Calculadora con punteros
        calculatorPointer();

        // Calculadora con funciones lambda
        calculatorLambda();

        // Map
        Double[] salaries = {10., 90., 50., 55., 62.};
        List<Double> list = Arrays.asList(salaries);

        System.out.println("Salarios: " + list.toString());
        List<Double> result = list.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Map");
        System.out.println(result);

        // Reduce
        System.out.println("Reduce");
        list.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
    }

    private static void calculatorPointer() {
        System.out.println("**--**--**--** Calculadora con apuntadores **--**--**--**");
        int op;
        do {
            displayCalculatorOptions();
            op = getOptionFromUserInput();
            performOperation(op);
        } while (op >= 0 && op < 6);
    }

    private static void calculatorLambda() {
        System.out.println("**--**--**--** Calculadora con funciones lambda **--**--**--**");
        int op;
        do {
            displayCalculatorOptions();
            op = getOptionFromUserInput();
            performLambdaOperation(op);
        } while (op >= 0 && op < 6);
    }

    private static void displayCalculatorOptions() {
        System.out.println("1. Suma\n2. Potencia\n3. Resta\n4. División\n5. Multiplicación\n6. Salir");
    }

    private static int getOptionFromUserInput() {
        int op = -1;
        try {
            System.out.println("Seleccione una opción:");
            op = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            sc.nextLine(); 
            op = -1;
        }
        return op;
    }

    private static void performOperation(int op) {
        if (op >= 1 && op <= 5) {
            System.out.println("Ingrese número 1:");
            double n1 = getValidatedNumber();
            System.out.println("Ingrese número 2:");
            double n2 = getValidatedNumber();
            ArithOp.ArithmeticOp pointer = getArithmeticOp(op);
            double res = pointer.operation(n1, n2);
            System.out.println(res);
        }
    }

    private static void performLambdaOperation(int op) {
        if (op >= 1 && op <= 5) {
            System.out.println("Ingrese número 1:");
            double n1 = getValidatedNumber();
            System.out.println("Ingrese número 2:");
            double n2 = getValidatedNumber();
            ArithOp.ArithmeticOp2 lambda = getLambda(op);
            if (n2 == 0 && op == 4) {
                System.out.println("No se permite la división por cero");
            } else {
                double res = lambda.lambda(n1, n2);
                System.out.println(res);
            }
        }
    }
    
    private static double getValidatedNumber() {
        double number = 0;
        while (true) {
            try {
                number = sc.nextDouble();
                break; 
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                sc.nextLine(); 
            }
        }
        return number;
    }

    private static ArithOp.ArithmeticOp getArithmeticOp(int op) {
        return switch (op) {
            case 1 -> ArithOp::add;
            case 2 -> ArithOp::exp;
            case 3 -> ArithOp::sub;
            case 4 -> ArithOp::div;
            case 5 -> ArithOp::mult;
            default -> ArithOp::add;
        };
    }

    private static ArithOp.ArithmeticOp2 getLambda(int op) {
        return switch (op) {
            case 1 -> (a, b) -> (a + b);
            case 2 -> Math::pow;
            case 3 -> (a, b) -> (a - b);
            case 4 -> (a, b) -> (a / b);
            case 5 -> (a, b) -> (a * b);
            default -> (a, b) -> (a + b);
        };
    }
    
}

