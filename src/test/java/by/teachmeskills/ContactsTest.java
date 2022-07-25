package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.dto.Contact;
import by.teachmeskills.pages.*;
import by.teachmeskills.providers.Provider;
import by.teachmeskills.steps.AccountSteps;
import by.teachmeskills.wrappers.InputWithSuggestionsInContactModal;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactsTest extends BaseTest {

    Account account = new Provider().getAccount();
    private final String accountName = account.getAccountName(); ;

    @BeforeMethod
    public void loginAndCreateNewAccount() {

        new AccountSteps(driver).login();
        new AccountSteps(driver).createNewAccount(account);
    }

    @Test
    public void createContactsTest() {

        new ContactsPage(driver).open().clickNewButton();
        assertTrue(new NewContactModal(driver).getTitleNewContact().isDisplayed(),
                          "The window \"New Contact Modal\" didn't appear");

        Contact contact = new Provider().getContact();
        NewContactModal contactModal = new NewContactModal(driver).createNewContact(contact);
        contactModal.saveAccount();
        assertTrue(new ContactsPage(driver).notificationMessage().isDisplayed(), "The contact wasn't created");
    }
}