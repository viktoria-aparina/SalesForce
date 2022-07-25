package by.teachmeskills.steps;

import by.teachmeskills.dto.Account;
import by.teachmeskills.dto.Contact;
import by.teachmeskills.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountsPage accountsPage;
    ContactsPage contactPage;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    AccountDetailsPage accountDetailsPage;
    ContactDetailsPage contactDetailsPage;

    public AccountSteps(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.accountsPage = new AccountsPage(driver);
        this.contactPage = new ContactsPage(driver);
        this.newAccountModal = new NewAccountModal(driver);
        this.newContactModal = new NewContactModal(driver);
        this.accountDetailsPage = new AccountDetailsPage(driver);
        this.contactDetailsPage = new ContactDetailsPage(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login() {
        return loginPage.open()
                        .fillInUserName()
                        .fillInPassword()
                        .submitForm();
    }

    public AccountDetailsPage createNewAccount(Account account) {
        accountsPage.open().clickNewButton();
        return newAccountModal.createNewAccount(account)
                              .saveAccount();
    }

    public ContactDetailsPage createNewContact(Contact contact) {
        contactPage.open()
                   .clickNewButton();
        return newContactModal.createNewContact(contact).saveAccount();
    }
}
