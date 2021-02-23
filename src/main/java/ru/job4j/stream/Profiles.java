package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3. Уникальность элементов и сортировка. [#285565]
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.getAddress())
                .sorted(new AddressComparatorByCityAndStreet()) // Добавлена еще сортировка по улице
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("SPb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("Msk", "Tverskaya street", 13, 31)));
        list.add(new Profile(new Address("SPb", "Bolshoy prospekt V.O.", 5, 5)));
        list.add(new Profile(new Address("Sochi", "Vinogradnaya street", 123, 23)));
        list.add(new Profile(new Address("SPb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("SPb", "Marata street", 11, 111)));
        list.add(new Profile(new Address("Msk", "Akademika Koroleva street", 12, 52)));
        list.add(new Profile(new Address("Msk", "Tverskaya street", 13, 31)));
        list.add(new Profile(new Address("Kaliningrad", "Kanta street", 1, 1)));
        list.add(new Profile(new Address("Sochi", "Vinogradnaya street", 123, 23)));

        Profiles pr = new Profiles();
        List<Address> result = pr.collect(list);
        result.forEach(address -> System.out.println(address));

    }
}
