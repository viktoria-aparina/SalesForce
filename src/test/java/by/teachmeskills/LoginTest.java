package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.pages.*;
import by.teachmeskills.providers.Provider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    public static final By DELETE_BUTTON_LOCATOR = By.xpath("//button[text()='Delete']");
    public static final By DELETE_BUTTON_IN_NOTIFICATION = By.xpath("//span[text()='Delete']");
    public static final By NOTIFICATION_MESSAGE = By.xpath("//div[@role='alertdialog']");

    @Test
    public void createAccountTest() {
        new LoginPage(driver).open()
                             .fillInUserName()
                             .fillInPassword()
                             .submitForm();
        assertTrue(new HomePage(driver).getQuarterlyPerformance().isDisplayed(), "You are not on Home Page");

        new AccountsPage(driver).open().
                                clickNewButton();
        assertTrue(new NewAccountModal(driver).getTitleNewAccount().isDisplayed(),
                   "The window \"New Account Modal\" didn't appear");

        Account account = new Provider().getAccount();

        new NewAccountModal(driver).createNewAccount(account).saveAccount();
        assertTrue(new AccountsPage(driver).notificationMessage().isDisplayed(), "The account wasn't created");

        Account actualAccount = new AccountDetailsPage(driver).clickDetailsButton()
                                                              .getAccount();
        assertEquals(actualAccount.getAccountName(), account.getAccountName(), "Names are different");
        assertEquals(actualAccount.getPhone(), account.getPhone(), "Phones are different");
        assertEquals(actualAccount.getWebsite(), account.getWebsite(), "Websites are different");
        assertEquals(actualAccount.getIndustry(), account.getIndustry(), "Industries are different");
        assertEquals(actualAccount.getType(), account.getType(), "Types sre different");
    }

    @AfterMethod
    public void deleteAccount() {
        driver.findElement(DELETE_BUTTON_LOCATOR).click();
        driver.findElement(DELETE_BUTTON_IN_NOTIFICATION).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_MESSAGE)).isDisplayed());
    }
}
