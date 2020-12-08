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

        return Integer.compare(strToInt(ar1[0]), strToInt(ar2[0]));
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
