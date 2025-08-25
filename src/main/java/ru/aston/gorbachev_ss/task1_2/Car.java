package ru.aston.gorbachev_ss.task1_2;

public class Car {

    int year;
    float engine;
    String brand, model;

    public Car () {
        System.out.println("Constructor default");
    }

    public Car (String brand, String model, int year, float engine) {
        System.out.println("Constructor with parameters");
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }
}

class Main {
    public static void main(String[] args) {
        Car bmw = new Car();
        Car skoda = new Car("Skoda", "Fabia", 2011, 1.6f);
        System.out.println(skoda.brand + " | " + skoda.model + " | " + skoda.year + " | " + skoda.engine);
    }
}