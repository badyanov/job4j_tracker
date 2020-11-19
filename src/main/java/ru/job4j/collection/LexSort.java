package ru.job4j.collection;

import java.util.Comparator;

/**
 * 4. Сортировка номера [#285694]
 */
public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Math.min(left.length(), right.length());
        String dLeft = "", dRight = "";
        boolean isNumberLeft, isNumberRight;
        for (int i = 0; i < length; i++) {
            isNumberLeft = Character.isDigit(left.charAt(i));
            isNumberRight = Character.isDigit(right.charAt(i));

            if (isNumberLeft || isNumberRight) {
                dLeft += (isNumberLeft) ? left.charAt(i) : "";
                dRight += (isNumberRight) ? right.charAt(i) : "";

            } else if (dLeft.isEmpty() && dRight.isEmpty()) {
                int result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    return result;
                }
            } else {
                int result = Integer.compare(toInt(dLeft), toInt(dRight));
                dLeft = "";
                dRight = "";
                if (result != 0) {
                    return result;
                }
            }
        }
        if (dLeft.isEmpty() && dRight.isEmpty()) {
            return Integer.compare(left.length(), right.length());
        }
        // Проверяем еще один следующий символ, если это число, то оно может влиять на порядок при сортировке
        if (left.length() > length && Character.isDigit(left.charAt(length))) {
            dLeft += left.charAt(length);
        } else if (right.length() > length && Character.isDigit(right.charAt(length))) {
            dRight += right.charAt(length);
        }
        int result = Integer.compare(toInt(dLeft), toInt(dRight));
        if (result != 0) {
            return result;
        }
        return Integer.compare(left.length(), right.length());
    }

    private int toInt(String s) {
        if (s.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }
}
