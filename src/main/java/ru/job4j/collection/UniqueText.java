package ru.job4j.collection;

import java.util.HashSet;

/**
 * 2. Идентичные тексты. [#285713]
 */
public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word.toLowerCase());
        }
        boolean result = true;
        for (String word : text) {
            if (!check.contains(word.toLowerCase())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
