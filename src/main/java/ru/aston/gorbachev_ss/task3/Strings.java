package ru.aston.gorbachev_ss.task3;

import java.util.Scanner;

public class Strings {

    static String getString() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return in.nextLine();
    }

    static void longWord(String text) {
        int length = 0;
        String longWrd = "";
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.length() > length) {
                length = word.length();
                longWrd = word;
            }
        }
        System.out.println("Самое длинное слово: " + longWrd);
    }

    static void palindrome(String text) {
        for (int i = 0; i < (text.length() / 2); i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                System.out.println("Слово \"" + text + "\" не является палиндромом.");
                return;
            }
        }
        System.out.println("Слово \"" + text + "\" является палиндромом.");
    }

    static void replacement(String text) {
        String result = text.replace("бяка", "[вырезано цензурой]");
        System.out.println("Результат работы цензуры: " + result);
    }

    static void numberOfOccurrences (String text1, String text2) {
        int i = 0;
        int count = 0;
        while ((i = text1.indexOf(text2, i)) != -1) {
            i += text2.length();
            count++;
        }
        System.out.println("Количество вхождений одной подстроки в строку: " + count);
    }

    static void inversion (String text) {
        int i = 0;
        String[] words = text.split("\\s+");
        for (String word : words) {
            char[] inversionWord = new char[word.length()];
            for (int j = 0; j < word.length(); j++) {
                inversionWord[j] = word.charAt(word.length() - j - 1);
            }
            words[i] = String.valueOf(inversionWord);
            i++;
        }
        text = String.join(" ", words);
        System.out.println("Результат инверсии слов в строке: " + text);
    }
}

class Main {
    public static void main(String[] args) {
        String text = Strings.getString();
        Strings.longWord(text);
        text = Strings.getString();
        Strings.palindrome(text);
        text = Strings.getString();
        Strings.replacement(text);
        String text1 = Strings.getString();
        String text2 = Strings.getString();
        Strings.numberOfOccurrences(text1, text2);
        text = Strings.getString();
        Strings.inversion(text);
    }
}