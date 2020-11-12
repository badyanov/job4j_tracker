package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

/**
 * 2. Комбинированный компаратор. [#285696]
 */
public class JobTest {

    @Test
    public void whenCompatorByNameAscending() {
        Comparator<Job> comparator = new JobByName();
        int resultWhenGreater = comparator.compare(
                new Job("Omega", 24),
                new Job("Beta", 2)
        );
        assertThat(resultWhenGreater, greaterThan(0));
        int resultWhenLess = comparator.compare(
                new Job("Alpha", 1),
                new Job("Beta", 2)
        );
        assertThat(resultWhenLess, lessThan(0));
        int resultWhenEquals = comparator.compare(
                new Job("Alpha", 1),
                new Job("Alpha", 1)
        );
        assertThat(resultWhenEquals, is(0));
    }

    @Test
    public void whenCompatorByNameDescending() {
        Comparator<Job> comparator = new JobDescByName();
        int resultWhenGreater = comparator.compare(
                new Job("Omega", 24),
                new Job("Beta", 2)
        );
        assertThat(resultWhenGreater, lessThan(0));
        int resultWhenLess = comparator.compare(
                new Job("Alpha", 1),
                new Job("Beta", 2)
        );
        assertThat(resultWhenLess, greaterThan(0));
        int resultWhenEquals = comparator.compare(
                new Job("Alpha", 1),
                new Job("Alpha", 1)
        );
        assertThat(resultWhenEquals, is(0));
    }

    @Test
    public void whenCompatorByPriorityAscending() {
        Comparator<Job> comparator = new JobByPriority();
        int resultWhenGreater = comparator.compare(
                new Job("Omega", 24),
                new Job("Beta", 2)
        );
        assertThat(resultWhenGreater, greaterThan(0));
        int resultWhenLess = comparator.compare(
                new Job("Alpha", 1),
                new Job("Beta", 2)
        );
        assertThat(resultWhenLess, lessThan(0));
        int resultWhenEquals = comparator.compare(
                new Job("Alpha", 1),
                new Job("Alpha", 1)
        );
        assertThat(resultWhenEquals, is(0));
    }

    @Test
    public void whenCompatorByPriorityDescending() {
        Comparator<Job> comparator = new JobDescByPriority();
        int resultWhenGreater = comparator.compare(
                new Job("Omega", 24),
                new Job("Beta", 2)
        );
        assertThat(resultWhenGreater, lessThan(0));
        int resultWhenLess = comparator.compare(
                new Job("Alpha", 1),
                new Job("Beta", 2)
        );
        assertThat(resultWhenLess, greaterThan(0));
        int resultWhenEquals = comparator.compare(
                new Job("Alpha", 1),
                new Job("Alpha", 1)
        );
        assertThat(resultWhenEquals, is(0));
    }

    @Test
    public void whenDescendingByPriorityThenAscendingByName() {
        Comparator<Job> comparator = new JobDescByPriority().thenComparing(new JobByName());
        Set<Job> jobs = new TreeSet<>(comparator);
        jobs.add(new Job("Very urgent task", 1));
        jobs.add(new Job("Fix bugs", 3));
        jobs.add(new Job("Another bug", 3));
        jobs.add(new Job("Drink beer", 10));
        jobs.add(new Job("Reboot server", 9));
        Iterator<Job> iterator = jobs.iterator();
        assertThat(iterator.next(), is(new Job("Drink beer", 10)));
        assertThat(iterator.next(), is(new Job("Reboot server", 9)));
        assertThat(iterator.next(), is(new Job("Another bug", 3)));
        assertThat(iterator.next(), is(new Job("Fix bugs", 3)));
        assertThat(iterator.next(), is(new Job("Very urgent task", 1)));
    }

    @Test
    public void whenCompatorDescendingByNameAndPrority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Alpha", 1),
                new Job("Alpha", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscendingByPriorityAndName() {
        Comparator<Job> comparator = new JobByPriority().thenComparing(new JobByName());
        int rsl = comparator.compare(
                new Job("Omega", 1),
                new Job("Alpha", 2)
        );
        assertThat(rsl, lessThan(0));
    }
}