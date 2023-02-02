package gr.aueb.cf.testbed.ch18.model;

public class Account /*extends AbstractEntity*/ {
    private String iban;
    private User holder;
    private double balance;


    public Account() {}


    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public User getHolder() {
        return holder;
    }
    public void setHolder(User holder) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return getIban().equals(account.getIban());
    }

    @Override
    public int hashCode() {
        return getIban().hashCode();
    }
}
