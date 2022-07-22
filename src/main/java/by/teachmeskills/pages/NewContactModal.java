package by.teachmeskills.pages;

import by.teachmeskills.wrappers.InputInContactModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public WebElement getTitleNewContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_NEW_CONTACT_LOCATOR));
        return titleNewContact;
    }

    public NewContactModal createNewContact(String firstName, String lastName, String email, String phone) {
        new InputInContactModal(driver, "First Name").fillInNewContactModalNameInformation(firstName);
        new InputInContactModal(driver, "Last Name").fillInNewContactModalNameInformation(lastName);
        new InputInContactModal(driver, "Email").fillInNewContactModalOtherInformation(email);
        new InputInContactModal(driver, "Phone").fillInNewContactModalOtherInformation(phone);
        return this;
    }

    public NewContactModal saveAccount() {
        saveButton.click();
        return this;
    }
}
