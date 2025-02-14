package ru.aston.gorbachev_ss.task16;

public class Tree {

    public int age;
    public boolean alive;
    public String name;

    public Tree (int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Tree (int age, boolean alive, String name) {
        this.age = age;
        this.alive = alive;
        this.name = name;
    }

    public Tree () {
        System.out.println("Пустой конструктор без параметров сработал");
    }
}

class Main {
    public static void main(String[] args) {
        Tree tree1 = new Tree(73, "Дуб");
        Tree tree2 = new Tree(29, true, "Клён");
        Tree tree3 = new Tree();
        System.out.println(tree1.age + " | " + tree1.name);
        System.out.println(tree2.age + " | " + tree2.alive + " | " + tree2.name);
    }
}