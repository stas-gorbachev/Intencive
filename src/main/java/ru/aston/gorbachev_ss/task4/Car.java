package ru.aston.gorbachev_ss.task4;

public class Car {

    public String color, name;
    public int weight;

    public void printData() {
        System.out.println("Color: " + color);
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight);
    }

    public Car () {
    }

    public Car (String color) {
        this.color = color;
    }

    public Car (String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Green", 1900);
        Car car2 = new Car("Red");
        car1.printData();
        car2.printData();
    }
}