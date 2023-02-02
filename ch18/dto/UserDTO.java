package gr.aueb.cf.testbed.ch18.dto;

public class UserDTO {
    private String ssn;
    private String lastname;
    private String firstname;


    public UserDTO() {}
    public UserDTO(String ssn, String lastname, String firstname) {
        this.ssn = ssn;
        this.lastname = lastname;
        this.firstname = firstname;
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
                "SSN = '" + ssn + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", lastname = '" + lastname + '\'' +
                '}';
    }
}
