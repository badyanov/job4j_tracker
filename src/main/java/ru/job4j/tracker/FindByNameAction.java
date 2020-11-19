package ru.job4j.tracker;

import java.util.List;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class FindByNameAction implements UserAction {
    private Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        String searchKey = input.askStr(out, "Enter the Name (exactly): ");
        if (!searchKey.isBlank()) {
            List<Item> foundItems = tracker.findByName(searchKey);
            out.println("Search results: found " + foundItems.size() + " items:");
            out.println("--------------------------------------------------------------------------------------------------------------");
            for (Item item : foundItems) {
                out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
            }
            out.println("--------------------------------------------------------------------------------------------------------------");
        } else {
            out.println("Incorrect name!");
        }
        return true;
    }
}
