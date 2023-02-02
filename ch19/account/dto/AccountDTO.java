package gr.aueb.cf.testbed.ch19.account.dto;

public class AccountDTO {
    private Long accountID;
    private String iban;
    private UserDTO holder;
    private double balance;


    public AccountDTO() {}
    public AccountDTO(Long accountID, String iban, UserDTO holder, double balance) {
        this.accountID = accountID;
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
    }


    public Long getAccountID() {
        return accountID;
    }
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public UserDTO getHolder() {
        return holder;
    }
    public void setHolder(UserDTO holder) {
        this.holder = holder;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Account {" +
                "ID = " + accountID +
                ", Holder = " + holder +
                ", IBAN = " + iban +
                ", Balance = " + balance +
                "}";
    }
}
