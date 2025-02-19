package ru.aston.gorbachev_ss.task25;

import java.util.Scanner;

public class Age {

    String get() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите возраст пользователя: ");
        return in.nextLine();
    }
}

class Name extends Age {

    @Override
    String get() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        return in.nextLine();
    }
}

class Main {
    public static void main(String[] args) {
        Name user = new Name();
        user.get();
    }
}