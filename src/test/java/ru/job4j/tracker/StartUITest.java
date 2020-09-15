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

    @Test
    public void whenReplaceItem() {
        String replacedName = "Replaced item";
        Tracker tracker = new Tracker();
        Item item = new Item("Old name");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id), replacedName};
        Input input = new StubInput(answers);
        StartUI.editItem(input, tracker);
        Item itemReplaced = tracker.findById(id);
        assertThat(itemReplaced.getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Task which will be deleted");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id), "Y"};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        Item itemDeleted = tracker.findById(id);
        assertNull(itemDeleted);
    }
}