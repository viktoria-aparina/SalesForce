package by.teachmeskills.dto;

public class Contact {

    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String salutation;
    private String contactName;
    private Account account;

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    public String getAccountName() {
        return account.getAccountName();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getContactName() {
        return String.format(getSalutation() + " " + getFirstName() + " " + getLastName());
    }

    public void setContactName() {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
