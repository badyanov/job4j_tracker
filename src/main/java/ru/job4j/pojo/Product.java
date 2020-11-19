package ru.job4j.pojo;

import java.util.Objects;

/**
 * 3. Удаление моделей из массива. [#285784]
 */
public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 4. Сравнение моделей. Метод equals [#285783]
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    /**
     * 4. Сравнение моделей. Метод equals [#285783]
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
