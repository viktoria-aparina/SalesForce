package by.teachmeskills.providers;

import by.teachmeskills.dto.Account;
import by.teachmeskills.dto.Contact;
import com.github.javafaker.Faker;

public class Provider {

    Faker faker = new Faker();
    String accountName = faker.company().name();
    String contactName = faker.company().name();

    public Account getAccount() {
        Account account = new Account(accountName);
        account.setAccountName(accountName);
        account.setWebsite(faker.internet().url());
        account.setPhone(faker.phoneNumber().phoneNumber());
        account.setType("Competitor");
        account.setIndustry("Healthcare");
        return account;
    }

    public Contact getContact() {
        Contact contact = new Contact(contactName);
        contact.setFirstName(faker.team().name());
        contact.setLastName(faker.company().name());
        contact.setEmail(faker.internet().emailAddress());
        contact.setPhone(faker.phoneNumber().phoneNumber());
        contact.setSalutation("Dr.");
//        contact.getContactName();
//        contact.getAccountName();
        return contact;
    }
}
