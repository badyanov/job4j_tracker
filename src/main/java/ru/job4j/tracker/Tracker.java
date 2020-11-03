package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Изменить программу Tracker из 2-го модуля [#285704]
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
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
        items.set(index, item);
        return true;
    }

    /**
     * Удаление элемента и последующая дефрагментация массива заявок
     * @param id удаляемого элемента
     * @return true если элемент удален, false - если элемент не найден по id
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    /**
     * Метод находит все ненулевые заявки из массива items и возвращает их в виде массива
     * Объект Tracker содержит поле size которое хранит всегда актуальное количество заявок,
     * !предполагается, что массив не должен быть фрагментирован!
     *
     * @return массив заполненных заявок (Item)
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод находит заявки по наименованию и возвращает их в виде массива
     * Результирующий массив "обрезается" по содержимому
     *
     * @return массив заявок (Item)
     */
    public List<Item> findByName(String key) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if ((item != null) && (item.getName().equalsIgnoreCase(key))) {
                results.add(item);
            }
        }
        return results;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private int indexOf(int id) {
        int index = 0;
        int result = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}