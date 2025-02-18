package ru.aston.gorbachev_ss.task23;

public class Car {

    public int weight;
    public String model;
    public char color;
    public float speed;

    public void outPut () {
        System.out.println("Вес " + model + " составляет " + weight + " кг.");
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

    int wheels, maxWeight;

    void newWheels() {
        System.out.println("Установлено новое количество колёс: " + (wheels = 10));
    }

    Truck (int w, String m, char c, float s, int wheels, int maxWeight) {
        super (w, m, c, s);
        this.wheels = wheels;
        this.maxWeight = maxWeight;
    }
}

class Main {
    public static void main(String[] args) {
        Truck car = new Truck(15880, "fabia", 'g', 160.7f, 8, 20000);
        car.outPut();
        System.out.println("Автомобиль с максимальным весом " + car.maxWeight + " кг. и количеством колёс - " + car.wheels);
        car.newWheels();
        car.outPut();
        System.out.println("Автомобиль с максимальным весом " + car.maxWeight + " кг. и количеством колёс - " + car.wheels);
    }
}