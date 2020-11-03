package ru.job4j.search;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 2. Очередь с приоритетом на LinkedList [#285700]
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() >= element.getPriority()) {
                index++;
            }
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(String.format("%s(%d), ", task.getDesc(), task.getPriority()));
        }
        return output.toString();
    }
}
