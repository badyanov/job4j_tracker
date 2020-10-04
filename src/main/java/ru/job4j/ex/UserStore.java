package ru.job4j.ex;

/**
 * 0.5. Иерархия исключений и множественный catch. [#285742]
 */
public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equalsIgnoreCase(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User \"" + login + "\" not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        int usernameLenth = user.getUsername().length();
        if (user.isValid() && usernameLenth >= 3) {
            return true;
        } else {
            throw new UserInvalidException("User \"" + user.getUsername() + "\" is not valid");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("D", true),
                new User("Bill Gates", false)
        };

        findAndValidate(users, "Petr Arsentev");
        findAndValidate(users, "Dmitriy Badyanov");
        findAndValidate(users, "D");
        findAndValidate(users, "Bill Gates");
    }

    private static void findAndValidate(User[] users, String login) {
        try {
            User user = findUser(users, login);
            if (validate(user)) {
                System.out.println("User \"" + user.getUsername() + "\" has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
