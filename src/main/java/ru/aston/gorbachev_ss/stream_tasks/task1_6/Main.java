package ru.aston.gorbachev_ss.stream_tasks.task1_6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = asList(1, 3, 6, 8, 10, 18, 36);
        //посчитать среднее
        double average = nums.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Среднее: " + average);

        List<String> colors = asList("RED", "grEEn", "white", "Orange", "pink");
        //перевести все в верхний и нижний регистр
        System.out.println("\nВерхний регистр:");
        colors.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("\nНижний регистр:");
        colors.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        nums = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //посчитать сумму четных и нечетных элементов
        int even = nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("\nСумма чётных элементов: " + even);
        int odd = nums.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("Сумма нечётных элементов: " + odd);

        nums = asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        //удалить дубликаты
        System.out.println("\nУникальные элементы:");
        nums.stream()
                .distinct()
                .forEach(System.out::println);

        colors = asList("Red", "Green", "Blue", "Pink", "Brown");
        //получить количество элементов начинающихся с определенной буквы
        //отсортировать в порядке возрастания и убывания
        Map<String, Long> amount = colors.stream()
                .collect(Collectors.groupingBy(c -> c.substring(0, 1), Collectors.counting()));
        System.out.println("\nКоличество элементов начинающихся с определённой буквы: " + amount);
        System.out.println("\nСортировка по возрастанию:");
        colors.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("\nСортировка по убыванию:");
        colors.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        nums = asList(1, 17, 54, 14, 14, 33, 45, -11);
        //найти наибольший и наименьший элемент
        //найти второй наибольший и второй наименьший элемент
        int max = nums.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println("\nМаксимальный элемент: " + max);
        int min = nums.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println("Минимальный элемент: " + min);
        int second_max = nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Второй максимальный элемент: " + second_max);
        int second_min = nums.stream()
                .sorted()
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Второй минимальный элемент: " + second_min);
    }
}