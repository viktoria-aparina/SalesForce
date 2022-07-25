package by.teachmeskills.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//div[@role='alertdialog']")
    private WebElement notification;

    private static final By NOTIFICATION_LOCATOR = By.xpath("//div[@role='alertdialog']");

    public ContactsPage(WebDriver driver) {
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
    public ContactsPage open() {
        driver.get(baseUrl + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public NewContactModal clickNewButton() {
        newButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New Contact']")));
        return new NewContactModal(driver);
    }

    public WebElement notificationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_LOCATOR));
        return notification;
    }
}
