package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 * @author d.badyanov@outlook.com
 */
public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select >= 0 && select < actions.length) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println();
        System.out.println("=== Tracker's Menu ===");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d. %s" + System.lineSeparator(), i, actions[i].name());
        }
        System.out.println("======================");
    }

    public static void main(String[] args) {
        Input con = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(con, tracker, actions);
    }
}
