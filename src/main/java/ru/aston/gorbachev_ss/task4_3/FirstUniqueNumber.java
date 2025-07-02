package ru.aston.gorbachev_ss.task4_3;

public class FirstUniqueNumber {

    void search(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == array[j]) {
                        break;
                    }
                    if (j == array.length - 1) {
                        System.out.println("Первое уникальное число: " + array[i]);
                        return;
                    }
                }
            }
        }
        System.out.println("Отсутствуют уникальные числа!");
    }
}