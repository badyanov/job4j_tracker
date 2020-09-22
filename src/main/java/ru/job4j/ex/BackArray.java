package ru.job4j.ex;

import java.util.Arrays;

/**
 * 0. Что такое исключение. [#285746]
 */
public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            int lastIndex = names.length - 1;
            names[index] = names[lastIndex - index];
            names[lastIndex - index] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}