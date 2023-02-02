package gr.aueb.cf.testbed.ch19.account.dao;

import gr.aueb.cf.testbed.ch19.account.model.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountDAOImpl implements IAccountDAO {
    private static final Map<Long, Account> accounts = new HashMap<>();


    @Override
    public Account insert(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public Account update(Account account) {
        accounts.replace(account.getId(), account);
        return accounts.get(account.getId());
    }

    @Override
    public Account get(String iban) {
        return getAccountByIban(iban);
    }

    @Override
    public boolean accountExists(String iban) {
        return getAccountByIban(iban) != null;
    }

    @Override
    public boolean accountExists(Long id) {
        return getAccountByID(id) != null;
    }

    /**
     * Returns the {@link Account} matching passed IBAN
     * @param iban      the passed IBAN
     * @return          the {@link Account} matching passed IBAN
     */
    private Account getAccountByIban(String iban) {
        for (Map.Entry<Long, Account> accountEntry : accounts.entrySet()) {
            if (accountEntry.getValue().getIban().equals(iban)) {
                return accountEntry.getValue();
            }
        }

        return null;
    }

    /**
     * Returns the {@link Account} matching passed id
     * @param id      the passed id
     * @return          the {@link Account} matching passed id
     */
    private Long getAccountByID(Long id) {
        for (Map.Entry<Long, Account> accountEntry : accounts.entrySet()) {
            if (accountEntry.getKey().equals(id)) {
                return accountEntry.getKey();
            }
        }

        return null;
    }

    /*@Override
    public boolean isSsnValid(Account account, String ssn) {
        return account.getHolder().getSsn().equals(ssn);
    }*/
}
