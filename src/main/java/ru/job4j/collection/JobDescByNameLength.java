package ru.job4j.collection;

import java.util.Comparator;

/**
 * 2. Комбинированный компаратор. [#285696]
 */
public class JobDescByNameLength implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getName().length(), o1.getName().length());
    }
}
