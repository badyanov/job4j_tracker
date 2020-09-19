package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        Item[] allItems = tracker.findAll();
        System.out.println("There are " + allItems.length + " items:");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Item item : allItems) {
            System.out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        return true;
    }
}