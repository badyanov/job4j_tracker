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
     * Объект Tracker содержит поле size которое хранит всегда актуальное количество заявок,
     * !предполагается, что массив не должен быть фрагментирован!
     *
     * @return массив заполненных заявок (Item)
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
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
        for (int i = 0; i < size; i++) {
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