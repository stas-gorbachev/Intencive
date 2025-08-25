package ru.aston.gorbachev_ss.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(7);
        arrayList1.add(4);
        arrayList1.add(9);
//        System.out.println(arrayList1);
//        arrayList1.remove((Integer) 4);
//
//        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);
//        System.out.println(arrayList2);
//        System.out.println(arrayList2.isEmpty());
//        System.out.println(arrayList2.size());
//        System.out.println(arrayList2.indexOf(7));
//
//        ArrayList<Character> arrayList3 = new ArrayList<>(10);
//        arrayList3.addFirst('s');
//        arrayList3.addLast('l');
//        System.out.println(arrayList3);
//        arrayList3.set(0, 'a');
//        System.out.println(arrayList3.get(1));
//
//        HashMap<Integer, String> hashMap1 = new HashMap<>();
//        hashMap1.put(1, "r");
//        hashMap1.put(2, "a");
//        hashMap1.put(3, "f");
//        System.out.println(hashMap1);
//        hashMap1.compute(2, (k, v) -> v + 6);
//
//        HashMap<Integer, String> hashMap2 = new HashMap<>(hashMap1);
//        System.out.println(hashMap2);
//        hashMap2.merge(1, "est", String::concat);
//        System.out.println(hashMap2.remove(3, "e"));
//        System.out.println(hashMap2);
//
//        HashMap<String, Integer> hashMap3 = new HashMap<>(10);
//        hashMap3.put("a", 1);
//        hashMap3.put("b", 2);
//        hashMap3.put("c", 3);
//        hashMap3.put("d", 4);
//        hashMap3.put("e", 5);
//        System.out.println(hashMap3);
//        System.out.println(hashMap3.getOrDefault("o", 99));
//
//        HashMap<String, Integer> hashMap4 = new HashMap<>(10, 0.5f);
//        hashMap4.putAll(hashMap3);
//        System.out.println(hashMap4.get("d"));

        TreeSet<String> treeSet1 = new TreeSet<>();
        treeSet1.add("d");
        treeSet1.add("c");
        treeSet1.add("y");
        treeSet1.add("f");
        treeSet1.add("p");
        System.out.println(treeSet1);
        treeSet1.pollLast();
        System.out.println(treeSet1);

        TreeSet<String> treeSet2 = new TreeSet<>(treeSet1);
        TreeSet<Integer> treeSet3 = new TreeSet<>(arrayList1);
        TreeSet<Integer> treeSet4 = new TreeSet<>(
                (a, b) -> b - a
        );
    }
}