package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * 5. Tracker - хранилище [#285788]
     * Метод находит все ненулевые заявки из массива items и возвращает их в виде массива
     * Так как массив items может быть фрагментирован, сначала производится группировка элементов
     * в отдельном массиве.
     * Предполагается, что объект Tracker содержит поле size которое хранит всегда актуальное количество заявок,
     * поэтому массив для группировки элементов сразу создается с нужным размером и не требует обрезки
     *
     * @return массив заполненных заявок (Item)
     */
    public Item[] findAll() {
        int newIndex = 0;
        Item[] itemsWithoutNull = new Item[size];
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                continue;
            }
            itemsWithoutNull[newIndex] = items[i];
            newIndex++;
        }
        return itemsWithoutNull;
    }

    /**
     * 5. Tracker - хранилище [#285788]
     * Метод находит заявки по наименованию и возвращает их в виде массива
     * Результирующий массив "обрезается" по содержимому
     *
     * @return массив заявок (Item)
     */
    public Item[] findByName(String key) {
        int newIndex = 0;
        Item[] results = new Item[size];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if ((item != null) && (item.getName().equalsIgnoreCase(key))) {
                results[newIndex] = item;
                newIndex++;
            }
        }
        return Arrays.copyOf(results, newIndex);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}