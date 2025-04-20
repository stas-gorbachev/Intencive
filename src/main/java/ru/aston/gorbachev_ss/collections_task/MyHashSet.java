package ru.aston.gorbachev_ss.collections_task;

/**
 * Реализация HashSet с методами добавления и удаления элементов.
 * @param <E> тип для элементов в ноде
 */
public class MyHashSet<E> {

    /**
     * Константа хранящая значение начального размера массива бакетов.
     */
    private static final int START_SIZE = 16;

    /**
     * Константа хранящая коэффициент загруженности множества,
     * при достижении которого, размер множества увеличивается в 2 раза.
     */
    private static final float LOAD_COEFFICIENT = 0.75f;

    /**
     * Массив бакетов для хранения данных HashSet.
     */
    private Node<E>[] table;

    /**
     * Переменная, которая хранит значение количества элементов во множестве.
     */
    private int size;

    /**
     * Описание полей для хранения основных данных в ноде.
     */
    private static class Node<E> {
        final E item;
        Node<E> next;

        /**
         * Конструктор для ноды.
         * @param item элемент для хранения в ноде
         * @param next ссылка на следующую ноду в односвязном списке.
         *             Равно null, при добавлении в пустой бакет.
         */
        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * Создает HashSet с начальным размером 16.
     */
    public MyHashSet() {
        table = (Node<E>[]) new Node[START_SIZE];
    }

    /**
     * Вычисляет hash для элемента с помощью встроенного метода hashCode.
     * Затем находит индекс бакета для указанного элемента.
     * @param element элемент, который необходимо вставить (удалить) в (из) HashSet
     * @return индекс в массиве бакетов
     */
    private int getIndex(E element) {
        return element.hashCode() & (table.length - 1);
    }

    /**
     * Добавляет элемент во множество, если его там еще нет.
     * @param element элемент, который необходимо поместить в HashSet
     * @return true - если элемент успешно добавлен, false - если элемент присутствует во множестве
     * @throws NullPointerException если элемент равен null
     */
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Null-элементы не допускаются");
        }
        int index = getIndex(element);
        Node<E> first = table[index];
        for (Node<E> node = first; node != null; node = node.next) {
            if (element.equals(node.item)) {
                return false;
            }
        }
        table[index] = new Node<>(element, first);
        size++;
        if (size > LOAD_COEFFICIENT * table.length) {
            resize();
        }
        return true;
    }

    /**
     * При переполнении массива бакетов, его размер увеличивается в 2 раза.
     * Из-за изменения размера пересчитываются индексы хранения для всех нод.
     * А ноды, в свою очередь, кладутся в новый массив бакетов, соответственно новых индексов.
     */
    private void resize() {
        Node<E>[] oldTable = table;
        table = (Node<E>[]) new Node[oldTable.length * 2];
        size = 0;
        for (Node<E> node : oldTable) {
            while (node != null) {
                add(node.item);
                node = node.next;
            }
        }
    }

    /**
     * Удаляет элемент из множества, если он там присутствует.
     * @param element элемент, который необходимо удалить из HashSet
     * @return true - если элемент успешно удален, false - если элемент отсутствует во множестве
     * @throws NullPointerException если элемент равен null
     */
    public boolean remove(E element) {
        if (element == null) {
            throw new NullPointerException("Null-элементы не допускаются");
        }
        int index = getIndex(element);
        Node<E> node = table[index];
        Node<E> prev = null;
        while (node != null) {
            if (element.equals(node.item)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    /**
     * Возвращает количество элементов находящихся в HashSet.
     * @return количество нод во множестве
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, содержит ли HashSet элементы.
     * @return true - если множество пусто, в противном случае - false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}