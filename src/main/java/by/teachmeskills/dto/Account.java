package by.teachmeskills.dto;

import by.teachmeskills.providers.Provider;

public class Account extends Provider {

    private String accountName;
    private String website;
    private String phone;
    private String type;
    private String industry;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return accountName.equals(that.accountName) &&
                website.equals(that.website)  &&
                phone.equals(that.phone)  &&
                type.equals(that.type)  &&
                industry.equals(that.industry);
    }
}
