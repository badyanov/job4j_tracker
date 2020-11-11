package ru.job4j.tracker;

import java.util.Comparator;

/**
 * 0. Сортировка [#285697]
 */
public class ItemComparatorAsc implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getId() - second.getId();
    }
}
