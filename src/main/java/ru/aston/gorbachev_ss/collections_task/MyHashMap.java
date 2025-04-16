package ru.aston.gorbachev_ss.collections_task;

/**
 * Реализация HashMap с методами добавления/обновления, получения и удаления элементов.
 * @param <K> тип для ключей в бакете
 * @param <V> тип для значений в бакете
 */
public class MyHashMap<K, V> {

    /**
     * Константа хранящая значение начального размера массива бакетов (нод).
     */
    private static final int START_SIZE = 16;

    /**
     * Константа хранящая коэффициент загруженности мапы, при достижении которого, размер мапы увеличивается в 2 раза.
     */
    private static final float LOAD_COEFFICIENT = 0.75f;

    /**
     * Массив бакетов для хранения данных HashMap.
     */
    private Node<K, V>[] table;

    /**
     * Переменная, которая хранит значение размера мапы.
     */
    private int size;

    /**
     * Описание полей бакета (ноды).
     */
    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        /**
         * Конструктор для бакета.
         * @param hash hashCode полученный для ключа
         * @param key ключ
         * @param value значение
         * @param next ссылка на следующий бакет в массиве
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Создает HashMap с начальным размером 16.
     */
    public MyHashMap() {
        table = (Node<K, V>[]) new Node[START_SIZE];
    }

    /**
     * Добавляет или обновляет пару ключ-значение
     * @param key ключ
     * @param value значение
     */
    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
            return;
        }
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> node = table[index];
        while (node != null) {
            if (node.hash == hash && (node.key == key || key.equals(node.key))) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        addNode(hash, key, value, index);
    }

    /**
     * Обрабатывает добавление null-ключа
     * @param value значение
     */
    private void putForNullKey(V value) {
        Node<K, V> node = table[0];
        while (node != null) {
            if (node.key == null) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        addNode(0, null, value, 0);
    }

    /**
     * Вспомогательный метод для добавления нового узла
     */
    private void addNode(int hash, K key, V value, int index) {
        Node<K, V> newNode = new Node<>(hash, key, value, table[index]);
        table[index] = newNode;
        if (++size > table.length * LOAD_COEFFICIENT) {
            resize();
        }
    }

    /**
     * Возвращает значение по ключу
     * @param key ключ
     * @return значение или null, если ключ отсутствует
     */
    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> node = table[index];
        while (node != null) {
            if (node.hash == hash && (node.key == key || key.equals(node.key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Обрабатывает поиск по null-ключу
     */
    private V getForNullKey() {
        Node<K, V> node = table[0];
        while (node != null) {
            if (node.key == null) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Удаляет пару по ключу
     * @param key ключ
     * @return удаленное значение или null, если ключ отсутствовал
     */
    public V remove(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> prev = null;
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.hash == hash && (node.key == key || key.equals(node.key))) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    /**
     * Возвращает количество элементов
     * @return текущий размер мапы
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет пустоту мапы
     * @return true если нет элементов
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Вычисляет хеш ключа
     */
    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Увеличивает размер таблицы при переполнении
     */
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = (Node<K, V>[]) new Node[oldTable.length << 1];

        for (Node<K, V> head : oldTable) {
            while (head != null) {
                Node<K, V> next = head.next;
                int newIndex = (table.length - 1) & head.hash;
                head.next = table[newIndex];
                table[newIndex] = head;
                head = next;
            }
        }
    }
}