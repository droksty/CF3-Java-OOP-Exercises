package gr.aueb.cf.testbed.ch18.service.exceptions;

public class AccountNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(String iban) {
        super("Transaction error. Account with IBAN " + iban + " does not exist.");
    }
}
