package ru.aston.gorbachev_ss.task4_1;

public class CheckAscSort {

    int[] array;

    public CheckAscSort(int[] array) {
        this.array = array;
    }

    void check() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("Please, try again");
                return;
            }
        }
        System.out.println("OK");
    }
}