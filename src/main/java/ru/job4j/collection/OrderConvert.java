package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * 2. Преобразования List в Map. [#285710]
 */
public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
