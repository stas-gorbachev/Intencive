package ru.aston.gorbachev_ss.task4_4;

import ru.aston.gorbachev_ss.task4_2.ArrayOutput;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        ArrayOutput arrayOutput = new ArrayOutput();
        arrayOutput.print(array);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println("Sorting...");
        arrayOutput.print(array);
    }
}