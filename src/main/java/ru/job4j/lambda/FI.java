package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2.2. Лямбда блок [#285556]
 */
public class FI {
    public static void main(String[] args) {
        Comparator<String> cmpSize = (left, right) -> {
            System.out.printf("Compare the lengths of strings (ascending): %d - %d%n", left.length(), right.length());
            return left.length() - right.length();
        };

        Comparator<String> cmpText = (left, right) -> {
            System.out.printf("Compare the strings (ascending): '%s' - '%s'%n", left, right);
            return left.compareTo(right);
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.printf("Compare the lengths of strings (descending): %d - %d%n", left.length(), right.length());
            return Integer.compare(right.length(), left.length());
        };

        // 2.5. Ленивая загрузка [#285559]
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
