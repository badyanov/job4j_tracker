package ru.job4j.tracker;

/**
 * 2.1. Реализация класса StartUI [#285731]
 * @author d.badyanov@outlook.com
 */
public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = inputNumber(input, "Select: ");
            switch (select) {
                case 0 -> {
                    System.out.println("-= Create new item =-");
                    String itemName = input.askStr("Enter the name of new item: ");
                    Item newItem = new Item(itemName);
                    tracker.add(newItem);
                    System.out.println("The item was added successfully");
                }
                case 1 -> {
                    System.out.println("-= All items =-");
                    showItems(tracker.findAll());
                }
                case 2 -> {
                    System.out.println("-= Edit item =-");
                    int id = inputNumber(input, "Enter the ID: ");
                    Item foundItem = tracker.findById(id);
                    if (foundItem == null) {
                        System.out.println("Item not found...");
                        continue;
                    }
                    System.out.printf("Found the item \"%s\". Enter a new name and press Enter", foundItem.getName());
                    System.out.println();
                    String newName = input.askStr("New name: ");
                    if (newName.isBlank()) {
                        System.out.println("Name was blank. Item has not been changed");
                        continue;
                    }
                    Item newItem = new Item(newName);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Item was renamed successfully");
                    } else {
                        System.out.println("Error! Item has not been changed.");
                    }
                }
                case 3 -> {
                    System.out.println("-= Deleting an item =-");
                    int id = inputNumber(input, "Enter the ID: ");
                    Item foundItem = tracker.findById(id);
                    if (foundItem == null) {
                        System.out.println("Item not found...");
                        continue;
                    }
                    System.out.printf("The item \"%s\" will be deleted. Are you sure?", foundItem.getName());
                    System.out.println();
                    if (!askYesOrNo(input)) {
                        System.out.println("Item has not been deleted");
                        continue;
                    }
                    if (tracker.delete(id)) {
                        System.out.println("Item was deleted successfully");
                    } else {
                        System.out.println("Error! Item has not been deleted");
                    }
                }
                case 4 -> {
                    System.out.println("-= Find item by ID =-");
                    int id = inputNumber(input, "Enter the ID: ");
                    Item foundItem = tracker.findById(id);
                    if (foundItem == null) {
                        System.out.println("Item not found...");
                        continue;
                    }
                    Item[] foundItems = {foundItem};
                    showItems(foundItems);
                }
                case 5 -> {
                    System.out.println("-= Find items by Name =-");
                    String searchKey = input.askStr("Enter the Name (exactly): ");
                    if (searchKey.isBlank()) {
                        System.out.println("Incorrect name!");
                        continue;
                    }
                    Item[] foundItems = tracker.findByName(searchKey);
                    if (foundItems.length == 0) {
                        System.out.println("No items found under this name");
                    } else {
                        System.out.println("Search results:");
                        showItems(foundItems);
                    }
                }
                case 6 -> {
                    System.out.println("-= Exit =-");
                    run = false;
                }
            }
        }
    }

    private boolean askYesOrNo(Input input) {
        while (true) {
            String answer = input.askStr("Y/N?: ");
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }

    private int inputNumber(Input input, String msgQuestion) {
        int result = -1;
        try {
            result = input.askInt(msgQuestion);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input! Enter the number");
        }
        return result;
    }

    private void showItems(Item[] items) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        if (items.length == 0) {
            System.out.println("There are no tasks here...");
            return;
        }
        for (Item item : items) {
            System.out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }

    private void showMenu() {
        System.out.println();
        System.out.println("=== Tracker's Menu ===");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by ID");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit tracker");
        System.out.println("======================");
    }

    public static void main(String[] args) {
        Input con = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(con, tracker);
    }
}
