package ru.aston.gorbachev_ss.collections_task;

/**
 * Реализация HashMap с методами добавления/обновления, получения и удаления элементов.
 * @param <K> тип для ключей в ноде
 * @param <V> тип для значений в ноде
 */
public class MyHashMap<K, V> {

    /**
     * Константа хранящая значение начального размера массива бакетов.
     */
    private static final int START_SIZE = 16;

    /**
     * Константа хранящая коэффициент загруженности мапы,
     * при достижении которого, размер мапы увеличивается в 2 раза.
     */
    private static final float LOAD_COEFFICIENT = 0.75f;

    /**
     * Массив бакетов для хранения данных HashMap.
     */
    private Node<K, V>[] table;

    /**
     * Переменная, которая хранит значение количества элементов в мапе.
     */
    private int size;

    /**
     * Описание полей для хранения основных данных в ноде.
     */
    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        /**
         * Конструктор для ноды.
         * @param hash hash полученный для ключа
         * @param key ключ для хранения в ноде
         * @param value значение для хранения в ноде
         * @param next ссылка на следующую ноду в односвязном списке.
         *             Равно null, при добавлении в пустой бакет.
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
     * Вычисляет hash для ключа с помощью встроенного метода hashCode.
     * Если ключ равен null всегда вернётся 0.
     * @param key ключ, который необходимо вставить (удалить) в (из) HashMap
     * @return hash для ключа
     */
    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode();
    }

    /**
     * Добавляет/обновляет пару ключ-значение в HashMap.
     * Если ключ равен null - добавление/обновление выполняется через другой метод.
     * @param key ключ, который необходимо поместить в HashMap
     * @param value значение, которое необходимо поместить в HashMap
     */
    public void put(K key, V value) {
        if (key == null) {
            putWithNullKey(value);
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
     * В случае, когда ключ равен null, пара ключ-значение добавляется в HashMap и попадает в бакет с индексом 0.
     * При последующих вставках просто происходит обновление значения value.
     * @param value значение, которое необходимо поместить в HashMap
     */
    private void putWithNullKey(V value) {
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
     * Создаёт и добавляет новую ноду в начало односвязного списка, который находится в определённом бакете.
     * В случае заполнения HashMap на 75% и более, её размер увеличивается в 2 раза.
     * @param hash hash вычисляемый для ключа
     * @param key ключ, который нужно добавить в HashMap
     * @param value значение, которое нужно добавить в HashMap
     * @param index индекс бакета, в который будет добавлена новая нода
     */
    private void addNode(int hash, K key, V value, int index) {
        Node<K, V> newNode = new Node<>(hash, key, value, table[index]);
        table[index] = newNode;
        if (++size > table.length * LOAD_COEFFICIENT) {
            resize();
        }
    }

    /**
     * При переполнении массива бакетов, его размер увеличивается в 2 раза.
     * Из-за изменения размера пересчитываются индексы хранения для всех нод.
     * А ноды, в свою очередь, кладутся в новый массив бакетов, соответственно новых индексов.
     */
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = (Node<K, V>[]) new Node[oldTable.length * 2];
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

    /**
     * По хэшу приходящего ключа ищет нужный бакет.
     * Затем, в нём находит ноду, в которой содержится необходимый ключ.
     * И возвращает соответствующее значение из пары ключ-значение.
     * Если ключ равен null - возврат значения по ключу выполняется через другой метод.
     * @param key ключ, по которому нужно вернуть значение
     * @return значение или null, если ключ отсутствует
     */
    public V get(K key) {
        if (key == null) {
            return getWithNullKey();
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
     * Ищет ноду с null-ключом в бакете с индексом 0, потому что все null-ключи попадают в этот бакет.
     * Если находит - возвращает соответствующее значение, в противном случае возвращает null.
     * @return значение или null, если ключ отсутствует
     */
    private V getWithNullKey() {
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
     * Удаляет ноду из HaspMap по заданному ключу.
     * @param key ключ, по которому должен происходить поиск нужной пары ключ-значение
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
     * Возвращает количество элементов находящихся в HashMap.
     * @return количество нод в мапе
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, содержит ли HashMap элементы.
     * @return true - если мапа пуста, в противном случае - false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}