package ru.job4j.collection;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1. Организовать сортировку User [#285695]
 */
public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);

        Set<Integer> numbersDesc = new TreeSet<>(Collections.reverseOrder());
        numbersDesc.add(5);
        numbersDesc.add(1);
        numbersDesc.add(3);
        System.out.println(numbersDesc);
    }
}
