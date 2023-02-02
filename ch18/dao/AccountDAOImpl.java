package gr.aueb.cf.testbed.ch18.dao;

import gr.aueb.cf.testbed.ch18.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO {
    private static final List<Account> accounts = new ArrayList<>();


    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return accounts.set(accounts.indexOf(account), account);
        /*//Mayhaps return the updated account instead?
        accounts.set(accounts.indexOf(account), account);
        int index = accounts.indexOf(account);
        return accounts.get(index);*/
    }

    @Override
    public Account get(String iban) {
        int pos = getIndexByIban(iban);
        if (pos == -1) return null;
        return accounts.get(pos);
    }

    @Override
    public boolean accountExists(String iban) {
        return getIndexByIban(iban) != -1;
    }

    /*@Override
    public boolean userExists(String ssn) {
        return false;
    }*/

    /**
     * TBA
     * @param iban  TBA
     * @return      TBA
     */
    private int getIndexByIban(String iban) {
        int pos = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getIban().equals(iban)) {
                pos = i;
                break;
            }
        }

        return pos;
    }

    @Override
    public boolean isSsnValid(Account account, String ssn) {
        return account.getHolder().getSsn().equals(ssn);
    }
}
