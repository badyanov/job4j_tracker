package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddNewItem() {
        String taskName = "Run test";
        String[] answers = {taskName};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        StartUI.createItem(input, tracker);
        Item itemCreated = tracker.findAll()[0];
        Item itemExpected = new Item(taskName);
        assertThat(itemCreated.getName(), is(itemExpected.getName()));
    }
}