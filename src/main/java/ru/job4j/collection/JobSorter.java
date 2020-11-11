package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 0. Сортировка [#285697]
 */
public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 3),
                new Job("Fix bugs", 2),
                new Job("Impl task", 1),
                new Job("Drink a beer", 4)
        );
        System.out.println(jobs);
        // 1. Sort by priority
        Collections.sort(jobs);
        System.out.println(jobs);
        // 2. Sort by name
        jobs.sort(new SortByNameJob());
        System.out.println(jobs);
        // 3. Sort by priority descending
        jobs.sort((first, second) -> second.getPriority() - first.getPriority());
        System.out.println(jobs);
    }
}
