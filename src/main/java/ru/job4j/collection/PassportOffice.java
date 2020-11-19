package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Паспорт и жители. [#285708]
 */
public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean result = false;
        String passport = citizen.getPassport();
        if (!citizens.containsKey(passport)) {
            citizens.put(passport, citizen);
            result = true;
        }
        return result;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
