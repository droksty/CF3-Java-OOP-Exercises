package gr.aueb.cf.testbed.ch18.dto;

public class AccountDTO {
    private String iban;
    private UserDTO holder;
    private double balance;


    public AccountDTO() {}
    public AccountDTO(String iban, UserDTO holder, double balance) {
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
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
                "Holder = " + holder +
                ", IBAN = '" + iban + '\'' +
                ", Balance = " + balance +
                '}';
    }
}
