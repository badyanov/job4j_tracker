package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 0. Сортировка [#285697]
 */
public class ItemTest {
    private final int[] ids = {9, 1, 7, 10, 2, 6, 5, 4, 8, 3};

    @Test
    public void testAscending() {
        List<Item> actual = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int id = ids[i];
            Item actualItem = new Item("Item #" + id);
            actualItem.setId(id);
            actual.add(actualItem);
            int expectedId = i + 1;
            Item expectedItem = new Item("Item #" + (expectedId));
            expectedItem.setId(expectedId);
            expected.add(expectedItem);
        }
        actual.sort(new ItemComparatorAsc());
        assertThat(actual, is(expected));
    }

    @Test
    public void testDescending() {
        List<Item> actual = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            int id = ids[i];
            Item actualItem = new Item("Item #" + id);
            actualItem.setId(id);
            actual.add(actualItem);
            int expectedId = i + 1;
            Item expectedItem = new Item("Item #" + (expectedId));
            expectedItem.setId(expectedId);
            expected.add(expectedItem);
        }
        actual.sort(new ItemComparatorDesc());
        assertThat(actual, is(expected));
    }
}