package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class FindByIdAction implements UserAction {
    private Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        int id = input.askInt(out, "Enter the ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            out.println("Search results: found 1 item:");
            out.println("--------------------------------------------------------------------------------------------------------------");
            out.printf("| %-2d | %-100s |" + System.lineSeparator(), foundItem.getId(), foundItem.getName());
            out.println("--------------------------------------------------------------------------------------------------------------");
        } else {
            out.println("Search result: item not found...");
        }
        return true;
    }
}
