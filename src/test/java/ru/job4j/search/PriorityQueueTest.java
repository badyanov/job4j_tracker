package ru.job4j.search;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2. Очередь с приоритетом на LinkedList [#285700]
 */
public class PriorityQueueTest {
    @Test
    public void putTest() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle1", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("ultra-urgent", 0));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("middle2", 3));
        queue.put(new Task("middle3", 3));
        queue.put(new Task("urgent2", 1));
        System.out.println(queue);
        assertThat(queue.take().getDesc(), is("ultra-urgent"));
        assertThat(queue.take().getDesc(), is("urgent1"));
        assertThat(queue.take().getDesc(), is("urgent2"));
        assertThat(queue.take().getDesc(), is("middle1"));
        assertThat(queue.take().getDesc(), is("middle2"));
        assertThat(queue.take().getDesc(), is("middle3"));
        assertThat(queue.take().getDesc(), is("low"));
    }
}