package gr.aueb.cf.testbed.ch18.service.exceptions;

public class InsufficientBalanceException extends Exception {
    private final static long serialVersionUID = 1L;

    public InsufficientBalanceException(double balance) {
        super("Transaction Error: Insufficient balance. Current balance: " + balance);
    }
}
