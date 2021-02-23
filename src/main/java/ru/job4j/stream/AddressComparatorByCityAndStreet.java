package ru.job4j.stream;

import java.util.Comparator;

/**
 * 3. Уникальность элементов и сортировка. [#285565]
 */
public class AddressComparatorByCityAndStreet implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        int result = a1.getCity().compareToIgnoreCase(a2.getCity());
        if (result == 0) {
            result = a1.getStreet().compareToIgnoreCase(a2.getStreet());
        }
        return result;
    }
}