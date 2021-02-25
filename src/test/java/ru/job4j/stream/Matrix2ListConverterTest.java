package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 5. Преобразование матрицы чисел в список чисел. [#285567]
 */
public class Matrix2ListConverterTest {

    @Test
    public void matrixToListTest() {
        Integer[][] matrix = {{0, 1, 2 }, {3, 4, 5}, {6, 7, 8}};

        Matrix2ListConverter converter = new Matrix2ListConverter();

        List<Integer> result = converter.collect(matrix);
        List<Integer> expect = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertThat(result, is(expect));
    }
}