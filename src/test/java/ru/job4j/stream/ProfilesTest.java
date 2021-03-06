package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 3. Уникальность элементов и сортировка. [#285565]
 */
public class ProfilesTest {
    private List<Profile> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add(new Profile(new Address("spb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("msk", "Tverskaya street", 13, 31)));
        list.add(new Profile(new Address("spb", "Bolshoy prospekt V.O.", 5, 5)));
        list.add(new Profile(new Address("sochi", "Vinogradnaya street", 123, 23)));
        list.add(new Profile(new Address("spb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("spb", "Marata street", 11, 111)));
        list.add(new Profile(new Address("msk", "Akademika Koroleva street", 12, 52)));
        list.add(new Profile(new Address("msk", "Tverskaya street", 13, 31)));
        list.add(new Profile(new Address("kaliningrad", "Kanta street", 1, 1)));
        list.add(new Profile(new Address("sochi", "Vinogradnaya street", 123, 23)));
    }

    @Test
    public void collectTest() {
        Profiles pr = new Profiles();
        List<Address> result = pr.collect(list);

        List<Address> expected = new ArrayList<>();
        expected.add(new Address("kaliningrad", "Kanta street", 1, 1));
        expected.add(new Address("msk", "Akademika Koroleva street", 12, 52));
        expected.add(new Address("msk", "Tverskaya street", 13, 31));
        expected.add(new Address("sochi", "Vinogradnaya street", 123, 23));
        expected.add(new Address("spb", "Bolshoy prospekt V.O.", 5, 5));
        expected.add(new Address("spb", "Marata street", 11, 111));
        expected.add(new Address("spb", "Nevskiy prospekt", 1, 1));

        assertThat(result, is(expected));
    }

    /**
     * Сравнение без учета регистра символов
     */
    @Test
    public void addressComparatorTest() {
        Comparator<Address> compatator = new AddressComparatorByCityAndStreetIgnoreCase();

        Address a1 = new Address("Kaliningrad", "Kanta street", 1, 1);
        Address a2 = new Address("Msk", "Akademika Koroleva street", 12, 52);
        assertThat(compatator.compare(a1, a2), lessThan(0));

        a1 = new Address("Tula", "Lenina prospekt", 1, 1);
        a2 = new Address("SPb", "Bolshoy prospekt V.O.", 5, 5);
        assertThat(compatator.compare(a1, a2), greaterThan(0));

        a1 = new Address("SPb", "Bolshoy prospekt V.O.", 5, 5);
        a2 = new Address("SPb", "Bolshoy prospekt V.O.", 5, 5);
        assertThat(compatator.compare(a1, a2), is(0));
    }
}