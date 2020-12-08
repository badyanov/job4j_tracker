package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 4. Сортировка номера [#285694]
 */
public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "21. Task.",
                "2. Task.",
                "11. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task.",
                "11. Task.",
                "21. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}