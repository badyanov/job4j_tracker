package ru.job4j.collection;

import java.util.Objects;

/**
 * 2. Преобразования List в Map. [#285710]
 */
public class Order {
    private String number;
    private String name;

    public Order(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Order{number='%s', name='%s'}", number, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(number, order.number)
                && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
