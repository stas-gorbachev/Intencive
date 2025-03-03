package ru.aston.gorbachev_ss.task1_1;

public class Calculator {

    //сложение
    static double add(double a, double b) {
        return a + b;
    }
    static long add(long a, long b) {
        return a + b;
    }
    static int add(int a, int b) {
        return a + b;
    }

    //вычитание
    static double sub(double a, double b) {
        return a - b;
    }
    static long sub(long a, long b) {
        return a - b;
    }
    static int sub(int a, int b) {
        return a - b;
    }

    //умножение
    static double mul(double a, double b) {
        return a * b;
    }
    static long mul(long a, long b) {
        return a * b;
    }
    static int mul(int a, int b) {
        return a * b;
    }

    //деление
    static double div(double a, double b) {
        return a / b;
    }
    static long div(long a, long b) {
        return a / b;
    }
    static int div(int a, int b) {
        return a / b;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("double = 3.14 | long = 30 | int = 3");
        System.out.println("Сложение double: " + Calculator.add(3.14d, 3.14d));
        System.out.println("Сложение long: " + Calculator.add(30L, 30L));
        System.out.println("Сложение int: " + Calculator.add(3, 3));
        System.out.println("Вычитание double: " + Calculator.sub(3.14d, 3.14d));
        System.out.println("Вычитание long: " + Calculator.sub(30L, 30L));
        System.out.println("Вычитание int: " + Calculator.sub(3, 3));
        System.out.println("Умножение double: " + Calculator.mul(3.14d, 3.14d));
        System.out.println("Умножение long: " + Calculator.mul(30L, 30L));
        System.out.println("Умножение int: " + Calculator.mul(3, 3));
        System.out.println("Деление double: " + Calculator.div(3.14d, 3.14d));
        System.out.println("Деление long: " + Calculator.div(30L, 30L));
        System.out.println("Деление int: " + Calculator.div(3, 3));
    }
}