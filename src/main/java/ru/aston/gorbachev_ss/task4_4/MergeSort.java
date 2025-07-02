package ru.aston.gorbachev_ss.task4_4;

public class MergeSort {

    void sort() {
    }
}

//public static void mergeSort(int[] array) {
//    if (array.length <= 1) return;
//
//    // 1. Разделение массива
//    int mid = array.length / 2;
//    int[] left = new int[mid];
//    int[] right = new int[array.length - mid];
//
//    System.arraycopy(array, 0, left, 0, left.length);
//    System.arraycopy(array, mid, right, 0, right.length);
//
//    // 2. Рекурсивная сортировка
//    mergeSort(left);
//    mergeSort(right);
//
//    // 3. Слияние
//    merge(array, left, right);
//}
//
//private static void merge(int[] result, int[] left, int[] right) {
//    int i = 0, j = 0, k = 0;
//
//    while (i < left.length && j < right.length) {
//        if (left[i] <= right[j]) {
//            result[k++] = left[i++];
//        } else {
//            result[k++] = right[j++];
//        }
//    }
//
//    // Копирование оставшихся элементов
//    while (i < left.length) {
//        result[k++] = left[i++];
//    }
//
//    while (j < right.length) {
//        result[k++] = right[j++];
//    }
//}