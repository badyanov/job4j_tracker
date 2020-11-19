package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item replacedItem = tracker.findById(item.getId());
        assertThat(replacedItem.getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "Y", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Test
    public void whenFindAll() {
        final String EOL = System.lineSeparator();

        Tracker tracker = new Tracker();
        tracker.add(new Item("First task"));
        tracker.add(new Item("Second task"));
        tracker.add(new Item("Third task"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        String matcher = EOL
                + "There are 3 items:" + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + String.format("| %-2d | %-100s |", 1, "First task") + EOL
                + String.format("| %-2d | %-100s |", 2, "Second task") + EOL
                + String.format("| %-2d | %-100s |", 3, "Third task") + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + "The Tracker has closed. Goodbye!" + EOL;
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(matcher));
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Test
    public void whenFindByName() {
        final String EOL = System.lineSeparator();

        Tracker tracker = new Tracker();
        tracker.add(new Item("The same task"));
        tracker.add(new Item("Another task"));
        tracker.add(new Item("The Same Task"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "the same task", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        String matcher = EOL
                + "Search results: found 2 items:" + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + String.format("| %-2d | %-100s |", 1, "The same task") + EOL
                + String.format("| %-2d | %-100s |", 3, "The Same Task") + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + "The Tracker has closed. Goodbye!" + EOL;
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(matcher));
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Test
    public void whenFindById() {
        final String EOL = System.lineSeparator();

        Tracker tracker = new Tracker();
        tracker.add(new Item("First task with ID = 1"));
        tracker.add(new Item("Second task with ID = 2"));
        tracker.add(new Item("Third task with ID = 3"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "2", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        String matcher = EOL
                + "Search results: found 1 item:" + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + String.format("| %-2d | %-100s |", 2, "Second task with ID = 2") + EOL
                + "--------------------------------------------------------------------------------------------------------------" + EOL
                + "The Tracker has closed. Goodbye!" + EOL;
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(matcher));
    }

    /**
     * 2. Рефакторинг - Шаблон Декоратор для валидатора. [#285736]
     */
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"Exit", "1", "0"}
        );
        Input validateInput = new ValidateInput(out, in);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(validateInput, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Incorrect input! Enter the number%n"
                        + "Wrong input! You can select a number from 0 to 0%n"
                        + "The Tracker has closed. Goodbye!%n"
                )
        ));
    }
}