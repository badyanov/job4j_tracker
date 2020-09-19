package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class EditAction implements UserAction {
    private Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        int id = input.askInt(out, "Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            out.printf("Found the item \"%s\". Enter a new name and press Enter", foundItem.getName());
            out.println();
            String newName = input.askStr(out, "New name: ");
            if (!newName.isBlank()) {
                Item newItem = new Item(newName);
                if (tracker.replace(id, newItem)) {
                    out.println("Item was renamed successfully");
                } else {
                    out.println("Error! Item has not been changed.");
                }
            } else {
                out.println("Name was blank. Item has not been changed");
            }
        } else {
            out.println("Item not found...");
        }
        return true;
    }
}