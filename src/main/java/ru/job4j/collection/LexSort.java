package ru.job4j.collection;

import java.util.Comparator;

/**
 * 4. Сортировка номера [#285694]
 * Компаратор для естественной сортировки названий задач в формате "%d. %s"
 */
public class LexSort implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String regex = "\\. ";
        String[] ar1 = s1.split(regex, 2);
        String[] ar2 = s2.split(regex, 2);

        int length = Math.min(ar1.length, ar2.length);
        int result;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result = Integer.compare(strToInt(ar1[i]), strToInt(ar2[i]));
            } else {
                result = ar1[i].compareTo(ar2[i]);
            }
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(ar1.length, ar2.length);
    }

    private int strToInt(String s) {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException ignored) {
            // ignored
        }
        return result;
    }
}
