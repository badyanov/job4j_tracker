package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 1. Организовать сортировку User [#285695]
 */
public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Dmitriy", 33));
        users.add(new User("Ivan", 30));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Dmitriy", 33)));
        assertThat(it.next(), is(new User("Ivan", 30)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDmitriyVSIvan() {
        int rsl = new User("Dmitriy", 33)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, lessThan(0));
    }
}