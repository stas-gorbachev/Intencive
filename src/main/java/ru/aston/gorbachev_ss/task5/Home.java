package ru.aston.gorbachev_ss.task5;

import java.util.Scanner;
import java.time.Year;

public class Home {

    public short number, year;
    public String name;

    public Home(String name, short year, short number) {
        this.name = name;
        this.year = year;
        this.number = number;
    }

    static String getName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название: ");
        return in.nextLine();
    }

    static short getYear() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите год постройки: ");
        return in.nextShort();
    }

    static short getNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество этажей: ");
        return in.nextShort();
    }

    void printData() {
        System.out.println("Название: " + name);
        System.out.println("Год постройки: " + year);
        System.out.println("Количество этажей: " + number);
    }

    void printAge (short year) {
        int currentYear = Year.now().getValue();
        System.out.println("Количество лет с момента постройки: " + (currentYear - year));
    }
}

class Main {
    public static void main(String[] args) {
        Home home1 = new Home (Home.getName(), Home.getYear(), Home.getNumber());
        Home home2 = new Home (Home.getName(), Home.getYear(), Home.getNumber());
        home1.printData();
        home1.printAge(home1.year);
        home2.printData();
        home2.printAge(home2.year);
    }
}