package ru.aston.gorbachev_ss.task4_4;

public class ArrayOutput {

    void print(int[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }
}