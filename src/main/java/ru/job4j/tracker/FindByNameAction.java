package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 */
public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        String searchKey = input.askStr("Enter the Name (exactly): ");
        if (!searchKey.isBlank()) {
            Item[] foundItems = tracker.findByName(searchKey);
            System.out.println("Search results:");
            // Так как метод showItems использовался у меня в нескольких местах, вывел его в отдельный класс
            // Не придумал, как это лучше реализовать в данном случае
            CommonMethods.showItems(foundItems);
        } else {
            System.out.println("Incorrect name!");
        }
        return true;
    }
}
