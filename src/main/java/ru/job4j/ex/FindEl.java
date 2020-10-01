package ru.job4j.ex;

/**
 * 0.4. Пользовательские исключения. [#285741]
 */
public class FindEl {
    public static int indexOf(String[] value, String key) throws UserInputException, ElementNotFoundException {
        if (key == null) {
            throw new UserInputException("Search key cannot be null!");
        }
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException(String.format("The element \"%s\" was not found!%n", key));
    }

    public static void main(String[] args) {
        String[] values = {"Меркурий", "Венера", "Земля", "Марс"};
        try {
            String key = "Земля";
            System.out.printf("For key = %s result: %d%n", key, indexOf(values, key));

            key = "Юпитер";
            System.out.printf("For key = %s result: %d%n", key, indexOf(values, key));
        } catch (UserInputException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
