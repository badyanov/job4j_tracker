package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3. Уникальность элементов и сортировка. [#285565]
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.getAddress())
                .sorted(Comparator.comparing(Address::getCity).thenComparing(Address::getStreet))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Address> collectIgnoreCase(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.getAddress())
                .sorted(new AddressComparatorByCityAndStreetIgnoreCase())
                .distinct()
                .collect(Collectors.toList());
    }
}
