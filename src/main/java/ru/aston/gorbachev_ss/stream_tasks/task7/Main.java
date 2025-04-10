package ru.aston.gorbachev_ss.stream_tasks.task7;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
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

        /*
        Объединить коллекцию people в единую коллекцию
        Вывести имена людей с длиной менее 4
        Вывести возраст самого старого человека
        Вывести сумму всех возрастов
        Вывести информацию о людях (средний возраст, минимальный возраст, максимальный возраст, количество людей)
        Сгруппировать и вывести людей по возрасту (взрослые отдельно, дети отдельно)
        Сгруппировать людей по национальности
        Объединить и вывести имена людей через подчеркивание
        Получить и вывести взрослых канадских мужчин
         */
}