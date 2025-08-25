package ru.aston.gorbachev_ss.task4_2;

public class SwapFirstAndLast {

     void swap(int[] array) {
        int firstNumber = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = firstNumber;
     }
}