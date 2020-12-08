package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0. Stream API [#285562]
 */
public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5));
        System.out.println(numbers);

        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }
}
