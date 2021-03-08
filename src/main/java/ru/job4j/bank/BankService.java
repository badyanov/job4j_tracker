package ru.job4j.bank;

import java.util.*;

/**
 * 3. Банковские переводы. [#285709]
 * 6. Тестовое задание из модуля коллекции Lite переделать на Stream API. [#285561]
 * 4. Optional в Stream API. [#285576]
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = findAccountsByPassport(passport);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        List<Account> accounts = findAccountsByPassport(passport);
        return accounts.stream()
                .filter(a -> requisite.equals(a.getRequisite()))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Optional<Account> srcAccountOptional = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccountOptional = findByRequisite(destPassport, destRequisite);
        if (srcAccountOptional.isPresent() && destAccountOptional.isPresent()) {
            Account srcAccount = srcAccountOptional.get();
            Account destAccount = destAccountOptional.get();
            if (amount <= srcAccount.getBalance()) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    private List<Account> findAccountsByPassport(String passport) {
        Optional<User> userOptional = findByPassport(passport);
        if (userOptional.isEmpty()) {
            return Collections.emptyList();
        }
        return users.get(userOptional.get());
    }
}
