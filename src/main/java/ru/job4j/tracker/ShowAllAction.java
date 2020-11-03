package ru.job4j.tracker;

import java.util.List;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class ShowAllAction implements UserAction {
    private Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        List<Item> allItems = tracker.findAll();
        out.println("There are " + allItems.size() + " items:");
        out.println("--------------------------------------------------------------------------------------------------------------");
        for (Item item : allItems) {
            out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
        }
        out.println("--------------------------------------------------------------------------------------------------------------");
        return true;
    }
}