package ru.aston.gorbachev_ss.task26;

public class Airplane {

    static class Wing {

        float weight = 497.7f;

        void print() {
            System.out.println("Вес крыла: " + weight + " кг.");
        }
    }

    public static void main(String[] args) {
        Wing wing = new Wing();
        wing.print();
        Wing wing1 = new Wing();
        Wing wing2 = new Wing();
        wing1.weight = 654.1f;
        wing2.weight = 249.5f;
        wing1.print();
        wing2.print();
    }
}