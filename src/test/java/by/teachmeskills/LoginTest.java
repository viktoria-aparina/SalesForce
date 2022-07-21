package by.teachmeskills;

import by.teachmeskills.pages.AccountsPage;
import by.teachmeskills.pages.HomePage;
import by.teachmeskills.pages.LoginPage;
import by.teachmeskills.pages.NewAccountModal;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    public static final By DELETE_BUTTON_LOCATOR = By.xpath("//button[text()='Delete']");
    public static final By DELETE_BUTTON_IN_NOTIFICATION = By.xpath("//span[text()='Delete']");
    public static final By NOTIFICATION_MESSAGE = By.xpath("//div[@role='alertdialog']");

    @Test
    public void createAccountTest() {
        new LoginPage(driver).open().
                             fillInUserName().
                             fillInPassword().
                             submitForm();
        assertTrue(new HomePage(driver).getQuarterlyPerformance().isDisplayed(), "You are not on Home Page");

        new AccountsPage(driver).open().
                                clickNewButton();
        assertTrue(new NewAccountModal(driver).getTitleNewAccount().isDisplayed(), "The window \"New Account Modal\" didn't appear");

        Faker faker = new Faker();

        NewAccountModal accountModal = new NewAccountModal(driver).createNewAccount(faker.company().name(),
                                                                                    faker.internet().url(),
                                                                                    faker.phoneNumber().phoneNumber());

        accountModal.saveAccount();
        assertTrue(new AccountsPage(driver).notificationMessage().isDisplayed());
    }

    @AfterMethod(alwaysRun = true)

    public void deleteAccount() {
        WebElement deleteButton;
        WebElement deleteButtonInNotification = driver.findElement(NOTIFICATION_MESSAGE);
        driver.findElement(DELETE_BUTTON_LOCATOR).click();
        driver.findElement(DELETE_BUTTON_IN_NOTIFICATION).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_MESSAGE));
        Assert.assertTrue(deleteButtonInNotification.isDisplayed());
    }
}
