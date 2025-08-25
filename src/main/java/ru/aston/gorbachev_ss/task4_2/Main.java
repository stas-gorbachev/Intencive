package ru.aston.gorbachev_ss.task4_2;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 7, 2};
        ArrayOutput arrayOutput = new ArrayOutput();
        arrayOutput.print(array);
        SwapFirstAndLast swapFirstAndLast = new SwapFirstAndLast();
        swapFirstAndLast.swap(array);
        System.out.println("Swap the first and last element...");
        arrayOutput.print(array);
    }
}