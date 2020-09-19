package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class ExitAction implements UserAction {
    private Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit from tracker";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("The Tracker has closed. Goodbye!");
        return false;
    }
}