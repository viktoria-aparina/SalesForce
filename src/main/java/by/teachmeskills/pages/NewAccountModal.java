package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.utils.PropertiesLoader;
import by.teachmeskills.wrappers.DropDownInAccountModal;
import by.teachmeskills.wrappers.InputInAccountModal;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

@Log4j2
public class NewAccountModal extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[text()='New Account']")
    private WebElement titleNewAccount;

    private static final By TITLE_NEW_ACCOUNT_LOCATOR = By.xpath("//h2[text()='New Account']");

    public NewAccountModal(WebDriver driver) {
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
            log.error("The page {} wasn't opened, because of {}", "New Account Modal", exception.getMessage());
            return false;
        }
    }

    @Override
    public NewAccountModal open() {
        driver.get(baseUrl + "lightning/o/Account/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=165849212939531886&backgroundContext=%2Flightning%2Fo%2FAccount%2Flist%3FfilterName%3DRecent");
        return this;
    }

    public NewAccountModal createNewAccount(Account account) {
        new InputInAccountModal(driver, "Account Name").fillInNewAccountModal(account.getAccountName());
        new InputInAccountModal(driver, "Website").fillInNewAccountModal(account.getWebsite());
        new InputInAccountModal(driver, "Phone").fillInNewAccountModal(account.getPhone());
        new DropDownInAccountModal(driver, "Type").selectInNewAccountModal(account.getType());
        new DropDownInAccountModal(driver, "Industry").selectInNewAccountModal(account.getIndustry());
        log.info("The form was filled in successfully");
        return this;
    }

    public AccountDetailsPage saveAccount() {
        saveButton.click();
        return new AccountDetailsPage(driver);
    }

    public WebElement getTitleNewAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_NEW_ACCOUNT_LOCATOR));
        return titleNewAccount;
    }
}
