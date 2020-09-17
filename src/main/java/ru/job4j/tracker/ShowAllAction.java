package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        // Так как метод showItems использовался у меня в нескольких местах, вывел его в отдельный класс
        // Не придумал, как это лучше реализовать в данном случае
        CommonMethods.showItems(tracker.findAll());
        return true;
    }
}