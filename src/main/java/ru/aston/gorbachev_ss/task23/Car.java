package ru.aston.gorbachev_ss.task23;

public class Car {
    public int weight;
    public String model;
    public char color;
    public float speed;


    public void outPut () {
        System.out.println("Вес " + model + " составляет " + weight + "кг.");
        System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
    }

    public Car (int w, String m, char c, float s) {
        weight = w;
        model = m;
        color = c;
        speed = s;
    }

    public Car () {}
}

class Truck extends Car {

    byte wheels;
    int maxWeight;

    void newWheels() {
//        wheels = 10;
        System.out.println("Количество колёс: " + (wheels = 10));
    }

    Truck (int w, String m, char c, float s, byte wheels, int maxWeight) {
        super (w, m, c, s);
        this.wheels = wheels;
        this.maxWeight = maxWeight;
    }
}

class Main {
    public static void main(String[] args) {
        
    }
}