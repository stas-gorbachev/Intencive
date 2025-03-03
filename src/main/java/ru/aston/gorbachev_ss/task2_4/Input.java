package ru.aston.gorbachev_ss.task2_4;

public class Input {

    int integer = 108;
}

class Output extends Input {

    void print() {
        System.out.println("Целое число: " + integer);
    }
}

class Main {
    public static void main(String[] args) {
        Output number = new Output();
        number.print();
    }
}