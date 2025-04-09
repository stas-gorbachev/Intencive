package ru.aston.gorbachev_ss.stream_tasks.task1_6;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = asList(1, 3, 6, 8, 10, 18, 36);
        //посчитать среднее
        double average = nums.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Среднее: " + average);
        System.out.println();

        List<String> colors = asList("RED", "grEEn", "white", "Orange", "pink");
        //перевести все в верхний и нижний регистр
        System.out.println("Верхний регистр:");
        colors.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Нижний регистр:");
        colors.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);
        System.out.println();

        nums = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //посчитать сумму четных и нечетных элементов
        int even = nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("Сумма чётных элементов: " + even);
        int odd = nums.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("Сумма нечётных элементов: " + odd);
        System.out.println();

        nums = asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        //удалить дубликаты
        System.out.println("Уникальные элементы:");
        nums.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        colors = asList("Red", "Green", "Blue", "Pink", "Brown");
        //получить количество элементов начинающихся с определенной буквы
        //отсортировать в порядке возрастания и убывания
    }
}
