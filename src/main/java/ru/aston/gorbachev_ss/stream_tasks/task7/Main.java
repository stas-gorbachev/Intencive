package ru.aston.gorbachev_ss.stream_tasks.task7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Country france = new Country("France", 65_235_184L);
        Country canada = new Country("Canada", 37_653_095L);
        Country uk = new Country("United Kingdom", 67_791_734L);

        var people = new ArrayList<>(Arrays.asList(
                Arrays.asList(
                        new Person("John", 50, Gender.MALE, canada),
                        new Person("May", 12, Gender.FEMALE, france),
                        new Person("Tiff", 23, Gender.MALE, uk)
                ),
                Arrays.asList(
                        new Person("Azul", 15, Gender.FEMALE, france),
                        new Person("Samantha", 67, Gender.FEMALE, canada),
                        new Person("John", 50, Gender.MALE, canada)
                )
        )
        );

        //Объединить коллекцию people в единую коллекцию
        List<Person> peoples = people.stream()
                .flatMap(Collection::stream)
                .toList();

        //Вывести имена людей с длиной менее 4
        System.out.println("Имена людей с длиной менее 4:");
        peoples.stream()
                .map(Person::getName)
                .filter(name -> name.length() < 4)
                .forEach(System.out::println);

        //Вывести возраст самого старого человека
        int maxAge = peoples.stream()
                .map(Person::getAge)
                .max(Integer::compareTo)
                .get();
        System.out.println("\nВозраст самого старого человека: " + maxAge);

        //Вывести сумму всех возрастов
        int sum = peoples.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println("\nСумма всех возрастов: " + sum);

        //Вывести информацию о людях (средний возраст, минимальный возраст, максимальный возраст, количество людей)
        IntSummaryStatistics information = peoples.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();
        System.out.println("\nИнформация о людях:");
        System.out.println("Средний возраст: " + information.getAverage());
        System.out.println("Минимальный возраст: " + information.getMin());
        System.out.println("Максимальный возраст: " + information.getMax());
        System.out.println("Количество людей: " + information.getCount());

        //Сгруппировать и вывести людей по возрасту (взрослые отдельно, дети отдельно)
        System.out.println("\nГруппировка людей по возрасту:");
        Map<Boolean, List<Person>> ageGrouping = peoples.stream()
                .collect(Collectors.partitioningBy(Person::isAdult));
        System.out.println("\nВзрослые:");
        ageGrouping.get(true).forEach(p -> System.out.println(p.getName()));
        System.out.println("\nДети:");
        ageGrouping.get(false).forEach(p -> System.out.println(p.getName()));

        //Сгруппировать людей по национальности
        System.out.println("\nГруппировка людей по национальности:");
        Map<String, List<Person>> grouping = peoples.stream()
                .collect(Collectors.groupingBy(p -> p.getCountry().getName()));
        grouping.forEach((country, persons) -> {
            System.out.println("\n" + country + ":");
            persons.forEach(p -> System.out.println(p.getName()));
        });

        /*// 8. Объединить и вывести имена людей через подчеркивание
        String namesJoined = combined.stream()
                .map(Person::getName)
                .collect(Collectors.joining("_"));
        System.out.println("\nВсе имена через подчеркивание: " + namesJoined);

        // 9. Получить и вывести взрослых канадских мужчин
        System.out.println("\nВзрослые канадские мужчины:");
        combined.stream()
                .filter(p -> p.isAdult() &&
                        p.getCountry().getName().equals("Canada") &&
                        p.getGender() == Gender.MALE)
                .forEach(p -> System.out.println(p.getName()));*/
    }
}