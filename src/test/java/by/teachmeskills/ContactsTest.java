package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.dto.Contact;
import by.teachmeskills.pages.ContactDetailsPage;
import by.teachmeskills.pages.ContactsPage;
import by.teachmeskills.pages.NewContactModal;
import by.teachmeskills.providers.Provider;
import by.teachmeskills.steps.AccountSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactsTest extends BaseTest {

    Account account = new Provider().getAccount();

    public static final By DELETE_BUTTON_LOCATOR = By.xpath("//button[text()='Delete']");
    public static final By DELETE_BUTTON_IN_NOTIFICATION = By.xpath("//span[text()='Delete']");
    public static final By NOTIFICATION_MESSAGE = By.xpath("//div[@role='alertdialog']");

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

        Contact contact = new Provider().getContact(account);
        NewContactModal contactModal = new NewContactModal(driver).createNewContact(contact);
        contactModal.saveAccount();
        assertTrue(new ContactsPage(driver).notificationMessage().isDisplayed(), "The contact wasn't created");
        Contact actualContact = new ContactDetailsPage(driver).clickDetailsButton()
                                                              .getActualContact();
        assertEquals(contact, actualContact, "Contacts aren't the same");
    }

    @AfterMethod
    public void deleteContact() {
        driver.findElement(DELETE_BUTTON_LOCATOR).click();
        driver.findElement(DELETE_BUTTON_IN_NOTIFICATION).click();
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_MESSAGE)).isDisplayed());
    }
}