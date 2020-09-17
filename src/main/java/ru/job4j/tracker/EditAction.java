package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        int id = input.askInt("Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.printf("Found the item \"%s\". Enter a new name and press Enter", foundItem.getName());
            System.out.println();
            String newName = input.askStr("New name: ");
            if (!newName.isBlank()) {
                Item newItem = new Item(newName);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item was renamed successfully");
                } else {
                    System.out.println("Error! Item has not been changed.");
                }
            } else {
                System.out.println("Name was blank. Item has not been changed");
            }
        } else {
            System.out.println("Item not found...");
        }
        return true;
    }
}