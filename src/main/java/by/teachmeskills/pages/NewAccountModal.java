package by.teachmeskills.pages;

import by.teachmeskills.wrappers.DropDownInAccountModal;
import by.teachmeskills.wrappers.InputInAccountModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public NewAccountModal createNewAccount(String accountName, String website, String phone) {
        new InputInAccountModal(driver, "Account Name").fillInNewAccountModal(accountName);
        new InputInAccountModal(driver, "Website").fillInNewAccountModal(website);
        new InputInAccountModal(driver, "Phone").fillInNewAccountModal(phone);
        new DropDownInAccountModal(driver, "Type").selectInNewAccountModal("Competitor");
        new DropDownInAccountModal(driver, "Industry").selectInNewAccountModal("Healthcare");
        return this;
    }

    public NewAccountModal saveAccount() {
        saveButton.click();
        return this;
    }

    public WebElement getTitleNewAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_NEW_ACCOUNT_LOCATOR));
        return titleNewAccount;
    }
}
