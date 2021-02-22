package ru.job4j.stream;

import java.util.List;

/**
 * 2. Список адресов [#285564]
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
