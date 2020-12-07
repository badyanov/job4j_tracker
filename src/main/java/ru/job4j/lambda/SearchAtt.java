package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.0. Встроенные функциональные интерфейсы. [#285557]
 */
public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> condition = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment a) {
                return a.getSize() >= 100;
            }
        };
        return filter(list, condition);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> condition = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment a) {
                return a.getName().contains("bug");
            }
        };
        return filter(list, condition);
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> condition) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (condition.test(att)) {
                result.add(att);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2 bug", 34),
                new Attachment("image 3 big bug", 13)
        );

        List<Attachment> result = new ArrayList<>();

        // 1. фильтр size >= 100
        result = filterSize(attachments);
        System.out.println(result);

        // 2. фильтр name содержит 'bug'
        result = filterName(attachments);
        System.out.println(result);

    }
}
