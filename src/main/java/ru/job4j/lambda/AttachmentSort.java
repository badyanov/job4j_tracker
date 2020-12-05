package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Анонимные классы [#285554]
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        Comparator<Attachment> comparatorBySize = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment a1, Attachment a2) {
                return Integer.compare(a1.getSize(), a2.getSize());
            }
        };

        attachments.sort(comparatorBySize);
        System.out.println(attachments);

        Comparator<Attachment> comparatorByName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment a1, Attachment a2) {
                return a1.getName().compareTo(a2.getName());
            }
        };

        attachments.sort(comparatorByName);
        System.out.println(attachments);
    }
}
