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
     * 6. Метод замены заявки. Tracker.replace [#285785]
     * @param id - идентификатор заменяемой заявки
     * @param item - заменяемая заявка
     * @return Возвращает true, если замена произведена или false, если index по id не найден.
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items[index] = item;
        return true;
    }

    /**
     * 7. Метод удаления заявки Tracker.delete [#285786]
     * Удаление элемента и последующая дефрагментация массива заявок
     * @param id удаляемого элемента
     * @return true если элемент удален, false - если элемент не найден по id
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        int lengthOfTail = size - index;
        System.arraycopy(items, index + 1, items, index, lengthOfTail);
        items[size - 1] = null;
        size--;
        return true;
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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}