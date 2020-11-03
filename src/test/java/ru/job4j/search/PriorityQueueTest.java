package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2. Очередь с приоритетом на LinkedList [#285700]
 */
public class PriorityQueueTest {
    @Test
    public void putTest() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("ultra-urgent", 0));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        assertThat(queue.take().getDesc(), is("ultra-urgent"));
        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("low"));
    }
}