package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 0.3. Тестирование исключений с junit [#285740]
 */
public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThan0() {
        Fact fact = new Fact();
        int rsl = fact.calc(-5);
    }

    @Test
    public void when5Then120() {
        Fact fact = new Fact();
        int rsl = fact.calc(5);
        assertThat(rsl, is(120));
    }
}