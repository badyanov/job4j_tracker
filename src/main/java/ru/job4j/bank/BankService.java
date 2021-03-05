package ru.job4j.bank;

import java.util.*;

/**
 * 3. Банковские переводы. [#285709]
 * 6. Тестовое задание из модуля коллекции Lite переделать на Stream API. [#285561]
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

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = findAccountsByPassport(passport);
        return accounts.stream()
                .filter(a -> requisite.equals(a.getRequisite()))
                .findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (amount <= srcAccount.getBalance()) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    private List<Account> findAccountsByPassport(String passport) {
        User user = findByPassport(passport);
        if (user == null) {
            return Collections.emptyList();
        }
        return users.get(user);
    }
}
