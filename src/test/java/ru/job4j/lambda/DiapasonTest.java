package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 5. Подсчет функции в диапазоне. [#285549]
 */
public class DiapasonTest {
    @Test
    public void whenLinearFunction() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D, 129D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = Diapason.diapason(5, 8, x -> Math.pow(2D, x) + 1);
        List<Double> expected = Arrays.asList(33D, 65D, 129D, 257D);
        assertThat(result, is(expected));
    }
}