package by.teachmeskills.providers;

import by.teachmeskills.dto.Account;
import by.teachmeskills.dto.Contact;
import com.github.javafaker.Faker;

public class Provider {

    Faker faker = new Faker();
    String accountName = faker.company().name();

    public Account getAccount() {
        Account account = Account.builder()
                                 .accountName(accountName)
                                 .website(faker.internet().url())
                                 .phone(faker.phoneNumber().phoneNumber())
                                 .type("Competitor")
                                 .industry("Healthcare").build();
        return account;
    }

    public Contact getContact(Account account) {
        Contact contact = Contact.builder()
                                 .firstName(faker.team().name())
                                 .lastName(faker.company().name())
                                 .email(faker.internet().emailAddress())
                                 .phone(faker.phoneNumber().phoneNumber())
                                 .salutation("Dr.")
                                 .account(account).build();
        return contact;
    }
}
