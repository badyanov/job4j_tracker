package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2. Комбинированный компаратор. [#285696]
 */
public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 2),
                new Job("Fix bug", 5),
                new Job("Fix bugs", 5),
                new Job("Drink a beer", 4),
                new Job("X task", 0)
        );
        System.out.println(jobs);

        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);

        Comparator<Job> combined = new JobDescByNameLength()
                .thenComparing(new JobDescByPriority())
                .thenComparing(new JobDescByName());
        jobs.sort(combined);
        System.out.println(jobs);
    }
}
