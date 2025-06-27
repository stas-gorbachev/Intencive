package ru.aston.gorbachev_ss.task4_2;

public class SwapFirstAndLast {

    int[] array1;

    public SwapFirstAndLast(int[] array1) {
        this.array1 = array1;
    }

    void swap() {
        int[] array2 = new int[array1.length];
        array2[0] = array1[array1.length - 1];
        for (int i = 1; i < array1.length - 1; i++) {
            array2[i] = array1[i];
        }
        array2[array2.length - 1] = array1[0];

        System.out.print("Array 1: [");
        for (int i = 0; i < array1.length - 1; i++) {
            System.out.print(array1[i] + ", ");
        }
        System.out.println(array1[array1.length - 1] + "]");
        System.out.print("Array 2: [");
        for (int i = 0; i < array1.length - 1; i++) {
            System.out.print(array2[i] + ", ");
        }
        System.out.println(array2[array1.length - 1] + "]");
    }
}