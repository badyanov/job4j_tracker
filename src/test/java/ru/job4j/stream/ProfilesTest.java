package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2. Список адресов [#285564]
 */
public class ProfilesTest {
    private List<Profile> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add(new Profile(new Address("SPb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("SPb", "Marata street", 11, 111)));
        list.add(new Profile(new Address("SPb", "Ligovskiy prospekt", 22, 33)));
    }

    @Test
    public void collectTest() {
        Profiles pr = new Profiles();
        List<Address> result = pr.collect(list);

        List<Address> expected = new ArrayList<>();
        expected.add(new Address("SPb", "Nevskiy prospekt", 1, 1));
        expected.add(new Address("SPb", "Marata street", 11, 111));
        expected.add(new Address("SPb", "Ligovskiy prospekt", 22, 33));

        assertThat(result, is(expected));
    }

}