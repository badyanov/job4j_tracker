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
        int length = Math.min(ar1.length, ar2.length);
        int result;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result = ar2[i].compareTo(ar1[i]);
            } else {
                result = ar1[i].compareTo(ar2[i]);
            }
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(ar1.length, ar2.length);
    }
}
