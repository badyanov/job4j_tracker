package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        int id = input.askInt("Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            String question = String.format("The item \"%s\" will be deleted. Are you sure?", foundItem.getName());
            if (input.askYesOrNo(question)) {
                if (tracker.delete(id)) {
                    System.out.println("Item was deleted successfully");
                } else {
                    System.out.println("Error! Item has not been deleted");
                }
            } else {
                System.out.println("Item has not been deleted");
            }
        } else {
            System.out.println("Item not found...");
        }
        return true;
    }
}