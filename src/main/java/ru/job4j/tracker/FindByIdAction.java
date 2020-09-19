package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        int id = input.askInt("Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println("Search results: found 1 item:");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2d | %-100s |" + System.lineSeparator(), foundItem.getId(), foundItem.getName());
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Search result: item not found...");
        }
        return true;
    }
}
