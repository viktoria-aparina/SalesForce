package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.wrappers.AccountDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'slds-is-active')]/following::a[text()='Details']")
    WebElement detailsButton;

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class, 'slds-is-active')]//a[text()='Related']")));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    @Override
    public AccountDetailsPage open() {
        driver.get(baseUrl + "lightning/o/Account/list?filterName=Recent");
        return this;
    }

    public AccountDetailsPage clickDetailsButton() {
        detailsButton.click();
        return this;
    }

    public Account getAccount() {
        Account actualAccount = new Account(new AccountDetail(driver, "Account Name").getAccountDetail());
        actualAccount.setWebsite(new AccountDetail(driver, "Website").getPhoneAndWebsiteDetail());
        actualAccount.setPhone(new AccountDetail(driver, "Phone").getPhoneAndWebsiteDetail());
        actualAccount.setType(new AccountDetail(driver, "Type").getAccountDetail());
        actualAccount.setIndustry(new AccountDetail(driver, "Industry").getAccountDetail());
        return actualAccount;
    }
}
