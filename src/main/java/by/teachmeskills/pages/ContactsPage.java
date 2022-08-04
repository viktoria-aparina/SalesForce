package by.teachmeskills.pages;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
            log.error("The page {} wasn't opened, because of {}", "Contact Page", exception.getMessage());
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
        log.info("The notification message was displayed");
        return notification;
    }
}
