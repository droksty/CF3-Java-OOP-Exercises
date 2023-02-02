package gr.aueb.cf.testbed.ch18.service.exceptions;

public class InsufficientAmountException extends Exception {
    private final static long serialVersionUID = 1L;

    public InsufficientAmountException(double amount) {
        super("Error. " + amount + " is not a valid amount");
    }
}
