package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 1. Паспорт и жители. [#285708]
 */
public class PassportOfficeTest {

    @Test
    public void addNewCitizen() {
        Citizen citizen = new Citizen("7508123456", "Dmitriy Badyanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addExistingCitizen() {
        Citizen citizen = new Citizen("7508123456", "Dmitriy Badyanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean hasBeenAdded = office.add(citizen);
        assertThat(hasBeenAdded, is(false));
    }

    @Test
    public void getNonExistentCitizen() {
        Citizen citizen = new Citizen("7508123456", "Dmitriy Badyanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
        assertThat(office.get("1234567890"), is(nullValue()));
    }
}