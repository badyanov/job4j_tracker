package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class DeleteAction implements UserAction {
    private Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        int id = input.askInt(out, "Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            String question = String.format("The item \"%s\" will be deleted. Are you sure?", foundItem.getName());
            if (input.askYesOrNo(out, question)) {
                if (tracker.delete(id)) {
                    out.println("Item was deleted successfully");
                } else {
                    out.println("Error! Item has not been deleted");
                }
            } else {
                out.println("Item has not been deleted");
            }
        } else {
            out.println("Item not found...");
        }
        return true;
    }
}