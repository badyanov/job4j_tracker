package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов [#285564]
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.getAddress())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("SPb", "Nevskiy prospekt", 1, 1)));
        list.add(new Profile(new Address("SPb", "Marata street", 11, 111)));
        list.add(new Profile(new Address("SPb", "Ligovskiy prospekt", 22, 33)));

        Profiles pr = new Profiles();
        List<Address> result = pr.collect(list);
        result.forEach(address -> System.out.println(address));

    }
}
