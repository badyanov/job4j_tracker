package ru.job4j.ex;

/**
 * 0.5. Иерархия исключений и множественный catch. [#285742]
 */
public class User {
    private String username;
    private boolean valid;

    public User(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid() {
        return valid;
    }
}
