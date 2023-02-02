package gr.aueb.cf.testbed.ch19.account.model;

public class User extends AbstractEntity {
    private String ssn;
    private String lastname;
    private String firstname;


    public User() {}


    @Override
    public Long getId() {
        return super.getId();
    }
    @Override
    public void setId(Long id) {
        super.setId(id);
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Override
    public String toString() {
        return "User {" +
                "ID = " + getId() +
                ", SSN = " + ssn +
                ", firstname = " + firstname +
                ", lastname = " + lastname +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getSsn().equals(user.getSsn());
    }

    @Override
    public int hashCode() {
        return getSsn().hashCode();
    }
}
