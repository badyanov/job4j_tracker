package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 2. Преобразования List в Map. [#285710]
 */
public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Order #1"));

        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("1"), is(new Order("1", "Order #1")));
    }

    @Test
    public void when2EqualsOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Order #1"));
        orders.add(new Order("1", "Order #1"));

        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(1));
        assertThat(map.get("1"), is(new Order("1", "Order #1")));
    }

    @Test
    public void whenSeveralOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            orders.add(new Order("" + i, "Order #" + i));
        }

        HashMap<String, Order> map = OrderConvert.process(orders);
        for (int i = 1; i <= 10; i++) {
            assertThat(map.get("" + i), is(new Order("" + i, "Order #" + i)));
        }
    }
}