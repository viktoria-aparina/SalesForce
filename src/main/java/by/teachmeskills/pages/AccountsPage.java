package by.teachmeskills.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//div[@role='alertdialog']")
    private WebElement notification;

    public static final By ACCOUNTS_LOCATOR = By.xpath("//div[contains(@class,'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NOTIFICATION_LOCATOR = By.xpath("//div[@role='alertdialog']");

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountsPage open() {
        driver.get("https://d5i0000052jrcea2.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated((ACCOUNTS_LOCATOR)));
        return this;
    }

    public AccountsPage clickNewButton() {
        newButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New Account']")));
        return this;
    }

    public WebElement notificationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_LOCATOR));
        return notification;
    }
}
