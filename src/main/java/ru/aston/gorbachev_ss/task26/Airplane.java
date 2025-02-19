package ru.aston.gorbachev_ss.task26;

public class Airplane {

    class Wing {

        static float weight = 497.7f;

        static void print() {
            System.out.println("Вес крыла: " + weight + " кг.");
        }
    }

    Airplane airplane = new Airplane();
}

class Main {
    public static void main(String[] args) {
        Airplane.Wing.print();
//        Airplane.Wing wing1 = new Airplane();
    }
}