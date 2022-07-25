package by.teachmeskills.pages;

import by.teachmeskills.dto.Contact;
import by.teachmeskills.utils.PropertiesLoader;
import by.teachmeskills.wrappers.DropDownInContactModal;
import by.teachmeskills.wrappers.InputInContactModal;
import by.teachmeskills.wrappers.InputWithSuggestionsInContactModal;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class NewContactModal extends BasePage {

    public static final By TITLE_NEW_CONTACT_LOCATOR = By.xpath("//h2[text()='New Contact']");

    @FindBy(xpath = "//h2[text()='New Contact']")
    private WebElement titleNewContact;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public NewContactModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        try {
            By contactsLocator = By.xpath("//div[contains(@class,'slds-breadcrumb__item')]//span[text()='Contacts']");
            wait.until(ExpectedConditions.visibilityOfElementLocated((contactsLocator)));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    @Override
    public NewContactModal open() {
        driver.get(baseUrl + "lightning/o/Contact/new?count=2&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=165849223661879618&backgroundContext=%2Flightning%2Fo%2FContact%2Flist%3FfilterName%3DRecent");
        return this;
    }

    public WebElement getTitleNewContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_NEW_CONTACT_LOCATOR));
        return titleNewContact;
    }

    public NewContactModal createNewContact(Contact contact) {
        new DropDownInContactModal(driver).selectInNewContactModal(contact.getSalutation());
        new InputInContactModal(driver, "First Name").fillInNewContactModalNameInformation(contact.getFirstName());
        new InputInContactModal(driver, "Last Name").fillInNewContactModalNameInformation(contact.getLastName());
        new InputInContactModal(driver, "Email").fillInNewContactModalOtherInformation(contact.getEmail());
        new InputInContactModal(driver, "Phone").fillInNewContactModalOtherInformation(contact.getPhone());
        new InputWithSuggestionsInContactModal(driver, "Account Name").fillSuggestion(contact.getAccountName());
        return this;
    }

    public ContactDetailsPage saveAccount() {
        saveButton.click();
        return new ContactDetailsPage(driver);
    }
}
