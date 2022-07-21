package by.teachmeskills;

import by.teachmeskills.pages.*;
import by.teachmeskills.wrappers.DropDownInContactModal;
import by.teachmeskills.wrappers.InputWithHintsInContactModal;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactsTest extends BaseTest {

    @Test
    public void createContactsTest() {
        new LoginPage(driver).open().
                             fillInUserName().
                             fillInPassword().
                             submitForm();
        assertTrue(new HomePage(driver).getQuarterlyPerformance().isDisplayed(), "You are not on Home Page");


        new AccountsPage(driver).open().
                                clickNewButton();
        assertTrue(new NewAccountModal(driver).getTitleNewAccount().isDisplayed(),
                   "The window \"New Account Modal\" didn't appear");

        Faker faker = new Faker();

        String accountName = faker.company().name();

        NewAccountModal accountModal = new NewAccountModal(driver).createNewAccount(accountName,
                                                                                    faker.internet().url(),
                                                                                    faker.phoneNumber().phoneNumber());
        accountModal.saveAccount();
        assertTrue(new AccountsPage(driver).notificationMessage().isDisplayed());

        new ContactsPage(driver).open().clickNewButton();
        Assert.assertTrue(new NewContactModal(driver).getTitleNewContact().isDisplayed(),
                          "The window \"New Contact Modal\" didn't appear");

        NewContactModal contactModal = new NewContactModal(driver).createNewContact(faker.company().name(),
                                                                                    faker.company().name(),
                                                                                    faker.internet().emailAddress(),
                                                                                    faker.phoneNumber().phoneNumber());
        new DropDownInContactModal(driver).selectInNewContactModal("Dr.");
        new InputWithHintsInContactModal(driver).fillInHint(accountName);
        contactModal.saveAccount();
    }
}