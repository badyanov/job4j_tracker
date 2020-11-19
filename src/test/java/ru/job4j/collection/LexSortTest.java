package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

/**
 * 4. Сортировка номера [#285694]
 */
public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
                "11. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task.",
                "11. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortDifficultString() {
        String[] input = {
                "10Task10.",
                "2. Second Task.",
                "1-First 10",
                "1-First 2",
                "1-First 1",
                "11.Task.",
                "1-Second2"
        };
        String[] out = {
                "1-First 1",
                "1-First 2",
                "1-First 10",
                "1-Second2",
                "2. Second Task.",
                "10Task10.",
                "11.Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortTestForTest() {
        String[] input = {
                "1-Task 10",
                "1-Task 2"
        };
        String[] out = {
                "1-Task 2",
                "1-Task 10"
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}