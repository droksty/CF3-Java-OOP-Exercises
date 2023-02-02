package gr.aueb.cf.testbed.ch19.account.service.exceptions;

import gr.aueb.cf.testbed.ch19.account.model.Account;

public class AccountAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountAlreadyExistsException(String iban) {
        super("Account with IBAN " + iban + " already exists");
    }

    public AccountAlreadyExistsException(Long id) {
        super("Account with ID " + id + " already exists");
    }
}
