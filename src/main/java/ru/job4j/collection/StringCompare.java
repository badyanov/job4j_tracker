package ru.job4j.collection;

import java.util.Comparator;

/**
 * 3. Компаратор для строк [#285693]
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int result;
        for (int i = 0; i < length; i++) {
            result = Character.compare(s1.charAt(i), s2.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(s1.length(), s2.length());
    }
}
