package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 1. Телефонный справочник на базе ArrayList [#285699]
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenDidNotFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Dmitriy");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindAllFromSPb() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Pavel", "Durov", "Telegram", "SPb")
        );
        phones.add(
                new Person("Sergey", "Sobyanin", "7777777", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "1234567", "SPb")
        );
        var persons = phones.find("SPb");
        assertThat(persons.size(), is(2));
    }
}