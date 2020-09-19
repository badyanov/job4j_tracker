package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        String searchKey = input.askStr("Enter the Name (exactly): ");
        if (!searchKey.isBlank()) {
            Item[] foundItems = tracker.findByName(searchKey);
            System.out.println("Search results: found "+ foundItems.length + " items:");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (Item item : foundItems) {
                System.out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Incorrect name!");
        }
        return true;
    }
}
