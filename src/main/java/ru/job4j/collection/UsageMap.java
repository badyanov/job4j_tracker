package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. Map, HashMap [#285707]
 */
public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("d.badyanov@outlook.com", "Dmitriy Badyanov");
        map.put("elonmusk@tesla.com", "Elon Musk");

        System.out.println("1)");
        for (String key : map.keySet()) {
            System.out.printf("%s <%s>%n", map.get(key), key);
        }

        System.out.println("2)");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s <%s>%n", entry.getValue(), entry.getKey());
        }

        System.out.println("3)");
        map.forEach((k, v) -> System.out.printf("%s <%s>%n", v, k));
    }
}