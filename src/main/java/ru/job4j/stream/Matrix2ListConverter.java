package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5. Преобразование матрицы чисел в список чисел. [#285567]
 */
public class Matrix2ListConverter {
    public List<Integer> collect(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(a -> Stream.of(a))
                .collect(Collectors.toList());
    }
}
