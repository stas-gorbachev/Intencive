package ru.aston.gorbachev_ss.task4_3;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1, 2, 4};
        ArrayOutput arrayOutput = new ArrayOutput();
        arrayOutput.print(array);
        FirstUniqueNumber firstUniqueNumber = new FirstUniqueNumber();
        firstUniqueNumber.search(array);
    }
}