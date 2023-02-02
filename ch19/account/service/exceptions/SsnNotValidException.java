package gr.aueb.cf.testbed.ch19.account.service.exceptions;

public class SsnNotValidException extends Exception {
    private final static long serialVersionUID = 1L;

    public SsnNotValidException(String ssn) {
        super("Transaction error. SSN: " + ssn + "is not valid");
    }
}
