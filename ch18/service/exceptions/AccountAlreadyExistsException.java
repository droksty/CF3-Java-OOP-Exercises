package gr.aueb.cf.testbed.ch18.service.exceptions;

import gr.aueb.cf.testbed.ch18.model.Account;

public class AccountAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountAlreadyExistsException(Account account) {
        super("Account with IBAN " + account.getIban() + " already exists");
    }
}
