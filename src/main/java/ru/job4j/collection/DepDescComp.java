package ru.job4j.collection;

import java.util.Comparator;

/**
 * Отсортировать департаменты [#285690]
 */
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] ar1 = s1.split("/");
        String[] ar2 = s2.split("/");

        if (ar1.length > 0 && ar2.length > 0) {
            int result = ar2[0].compareTo(ar1[0]);
            if (result != 0) {
                return result;
            }
        }
        return s1.compareTo(s2);
    }
}
