package ru.aston.gorbachev_ss.task21;

import java.util.Scanner;

abstract class Human {

    String name, surname;

    static String getName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        return in.nextLine();
    }

    static String getSurname() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        return in.nextLine();
    }

    abstract void printData();

    Human (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class Client extends Human {

    String bankName;

    Client (String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }

    @Override
    void printData() {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Название банка: " + bankName);
    }
}

class BankEmployee extends Human {

    String bankName;

    BankEmployee (String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }

    @Override
    void printData() {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Название банка: " + bankName);
    }
}

class Main {
    public static void main(String[] args) {
        Human human1 = new Client (Human.getName(), Human.getSurname(), "Беларусбанк");
        Human human2 = new BankEmployee (Human.getName(), Human.getSurname(), "Белинвестбанк");
        human1.printData();
        human2.printData();
    }
}