package gr.aueb.cf.testbed.ch19.account.dto;

public class UserDTO {
    private Long userID;
    private String ssn;
    private String lastname;
    private String firstname;


    public UserDTO() {}
    public UserDTO(Long userID, String ssn, String lastname, String firstname) {
        this.userID = userID;
        this.ssn = ssn;
        this.lastname = lastname;
        this.firstname = firstname;
    }


    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
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
                "ID = " + userID +
                ", SSN = " + ssn +
                ", firstname = " + firstname +
                ", lastname = " + lastname +
                "}";
    }
}
