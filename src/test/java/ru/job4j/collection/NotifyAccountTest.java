package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 3. Модели данных и HashSet. [#285714]
 */
public class NotifyAccountTest {

    @Test
    public void sentTest() {
        List<Account> accounts = Arrays.asList(
                new Account("7777123456", "Petr Arsentev", "40817810570000123456"),
                new Account("7508123456", "Dmitriy Badyanov", "40817810570000555555"),
                new Account("7777123456", "Petr Arsentev", "40817810570000987654"),
                new Account("4004123456", "Ivan Ivanov", "40817810570000111111")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("7777123456", "Petr Arsentev", "40817810570000123456"),
                        new Account("7508123456", "Dmitriy Badyanov", "40817810570000555555"),
                        new Account("4004123456", "Ivan Ivanov", "40817810570000111111")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentTestWhenEmpty() {
        List<Account> accounts = new ArrayList<>();
        HashSet<Account> expect = new HashSet<>();
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}