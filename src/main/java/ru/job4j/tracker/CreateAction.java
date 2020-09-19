package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class CreateAction implements UserAction {
    private Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println();
        String itemName = input.askStr(out, "Enter the name of new item: ");
        Item newItem = new Item(itemName);
        tracker.add(newItem);
        out.println("The item was added successfully");
        return true;
    }
}

