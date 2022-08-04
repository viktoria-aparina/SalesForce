package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.wrappers.AccountDetail;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
            log.error("The page {} wasn't opened, because of {}", "Account Details Page", exception.getMessage());
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

    public Account getActualAccount() {
        Account actualAccount = Account.builder()
                                       .accountName(new AccountDetail(driver, "Account Name").getAccountDetail())
                                       .website(new AccountDetail(driver, "Website").getPhoneAndWebsiteDetail())
                                       .phone(new AccountDetail(driver, "Phone").getPhoneAndWebsiteDetail())
                                       .type(new AccountDetail(driver, "Type").getAccountDetail())
                                       .industry(new AccountDetail(driver, "Industry").getAccountDetail())
                                       .build();
        log.info("The account was created successfully");
        return actualAccount;
    }
}
