package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2. Идентичные тексты. [#285713]
 */
public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "Mouse eats my milk and a cat";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isEquals2() {
        String origin = "1 2 3 4 5 6 7 8 9 0";
        String text = "0 9 8 7 6 5 4 3 2 1";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isEquals3() {
        String origin = "One Two Three Four Five";
        String text = "one two three four five";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }

}