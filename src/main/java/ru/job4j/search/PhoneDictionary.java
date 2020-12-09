package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 1. Телефонный справочник на базе ArrayList [#285699]
 * 6. Функции высшего порядка [#285550]
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = t -> t.getName().contains(key);
        Predicate<Person> predicateSurname = t -> t.getSurname().contains(key);
        Predicate<Person> predicatePhone = t -> t.getPhone().contains(key);
        Predicate<Person> predicateAddress = t -> t.getAddress().contains(key);

        Predicate<Person> combine = predicateName
                .or(predicateSurname)
                .or(predicatePhone)
                .or(predicateAddress);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
