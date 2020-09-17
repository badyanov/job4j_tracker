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
            Item[] foundItems = {foundItem};
            CommonMethods.showItems(foundItems);
        } else {
            System.out.println("Item not found...");
        }
        return true;
    }
}