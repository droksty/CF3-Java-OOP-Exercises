package gr.aueb.cf.testbed.ch19.account.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private final static long serialVersionUID = 1L;

    public InsufficientBalanceException(double balance) {
        super("Transaction Error: Insufficient balance. Current balance: " + balance);
    }
}
