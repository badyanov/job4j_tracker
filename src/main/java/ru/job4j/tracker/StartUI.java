package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия. [#285728]
 * @author d.badyanov@outlook.com
 */
public class StartUI {
    private Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt(out, "Select: ");
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
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new EditAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(con, tracker, actions);
    }
}
