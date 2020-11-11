package ru.job4j.tracker;

import java.util.Comparator;

/**
 * 0. Сортировка [#285697]
 */
public class ItemComparatorDesc implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getId() - first.getId();
    }
}
